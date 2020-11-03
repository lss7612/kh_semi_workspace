package service;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import dao.NoFileDao;
import dao.NoFileDaoImpl;
import dto.ParamData;
import dto.UploadFile;

public class NoFileServiceImpl implements NoFileService {
	
	private NoFileDao nofileDao = new NoFileDaoImpl();

	
	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {
		
		//응답 객체 설정
		resp.setContentType("text/html; charset=UTF-8");
		
		//응답 출력 스트림 얻기
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//1. 파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우 처리
		if(!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data가 아닙니다</h1>");
			out.append("<a href='/commons/fileupload'>업로드페이지로 이동</a>");
			
		//fileupload() 메소드 중단시키기
		return;
		
		}
			
		//1-2. multipart/form-data 인코딩으로 전송되었을 경우 파일업로드
		
				//---------------------------------------------
				
				//2. 업로드될 파일을 처리하는 아이템팩토리 객체 생성
				
				//	FileItemFactory
				//		업로드된 데이터(FileItem)를 처리하는 방식을 설정하는 클래스
				
				//	FileItem
				//		클라이언트에서 전송될 데이터를 객체화시킨 것
				
				//	DistFileItemFactory
				//		디스크(HDD) 기반으로 파일아이템을 처리하는 클래스
				//		업로드된 파일을 디스크에 임시 저장하고 나중에 처리한다
				
//				DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory factory = new DiskFileItemFactory();
				
				//---------------------------------------------
				
				//3. 업로드된 파일아이템의 용량이 설정값보다 작으면 메모리에서 처리
				int maxMem = 1 * 1024 * 1024; // 1MB
				factory.setSizeThreshold(maxMem);
				
				//---------------------------------------------
				
				//4. 용량이 설정보다 크면 임시파일(HDD)을 만들어서 처리
				//	-> 임시파일을 저장할 폴더를 설정해야 함 = .getRealPath
				
				//서블릿 컨텍스트 객체
				ServletContext context = req.getServletContext();
				
				//서버에 배포된(설치된) 폴더의 실제 경로의 tmp폴더를 나타낸다
				String path = context.getRealPath("tmp"); //tmp : 폴더이름
				
				//확인
				System.out.println(path);
				
				//임시 저장 폴더
				File repository = new File(path);
				
				//폴더 생성
				repository.mkdir();
				
				factory.setRepository(repository);
				
				//---------------------------------------------
				
				//5. 업로드 허용 용량을 넘지 않을 때에만 파일 업로드 되도록 설정
				int maxFile = 10 * 1024 * 1024; //10MB
				
				//파일업로드를 수행하는 객체 생성
				//	-> DiskFileItemFactory 객체 이용해서 생성한다
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				//파일 업로드 용량제한 설정 : 10MB
				upload.setFileSizeMax(maxFile);
				
				//---------------------------------------------
				
				//-----파일 업로드 준비 완료-----
				
				//---------------------------------------------
				
				//6. 업로드된 파일을 추출(파싱)
				//	임시 파일 업로드도 같이 수행됨
				
				List<FileItem> items = null;
				try {
					//요청객체에 담겨있는 파일업로드 전달파라미터를 파싱한다
					items = upload.parseRequest(req); //파일업로드 실행됨
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				
				//---------------------------------------------
				
				//7. 파싱된 전달파라미터 데이터를 처리하기
				//	item 리스트(List<FileItem>)에 파일과 쿼리스트링이
				//	파싱되어 들어있음
				
				//	요청정보의 3가지 형태
				//	1. 빈 파일(용량이 0인 파일)
				//	2. form-data(전달 파라미터, 쿼리스트링)
				//	3. 파일
				
				//파일아이템 반복자, Iterator
				Iterator<FileItem> iter = items.iterator();
				
				//폼필드를 저장할 DTO 객체 생성
				ParamData paramData = new ParamData();
				
				//업로드 파일정보를 저장할 DTO 객체 생성
				UploadFile uploadFile = new UploadFile();
				
				//모든 요청정보를 처리하는 반복문
				while(iter.hasNext()) {
					
					//요청정보를 하나씩 추출
					FileItem item = iter.next();
					
					//1) 빈 파일에 대한 처리
					if(item.getSize() <= 0) {
						continue;
					}
					
					//2) 기본 전달 파라미터에 대한 처리 - form-data
					if(item.isFormField()) {
						//-----전달 파라미터 처리 개요-----
						//	formField(form-data)는 key=value 쌍으로 전달됨
						
						//	key는 item.getFieldName() 메소드로 얻어온다
						//	value는 item.getString() 메소드로 얻어온다
						
						//**req.setCharacterEncoding("YTF-8"); 적용되지 않는다
						//	->req.getParameter("key"); 를 사용할 때만 적용된다
						
						//**item.getString("UTF-8"); 로 사용해야 한글 인코딩 적용됨
						
						//---------------------------
						
						//-----기본 처리 방식-----
//						out.println("- - - 폼필드 - - -<br>");
//						out.println("키 : " + item.getFieldName() + "<br>");
//						try {
//							out.println("값 : " + item.getString("UTF-8") + "<br>");
//						} catch (UnsupportedEncodingException e) {
//							e.printStackTrace();
//						}
						//---------------------------
						
						//-----키값에 따른 처리 방식-----
						//	->최종 결과를 DTO객체에 저장한다
						
						String key = item.getFieldName(); //키값 추출
						try {
							if("title".equals(key)) { //전달파라미터의 name이 "title"일때
								paramData.setTitle(item.getString("UTF-8"));
								
							} else if("data1".equals(key)) {//전달파라미터의 name이 "data1"일때
								paramData.setData1(item.getString("UTF-8"));
								
							} 
							
						} catch(UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						
						//---------------------------
						
					} //if(item.isFormField()) end
					
					//3) 파일에 대한 처리
					if(!item.isFormField()) {
						
						//-----업로드된 파일 처리하는 방법-----
						// 1. 파일을 웹 서버의 로컬 디스크(HDD)에 저장
						//	파일의 정보를 DB에 기록한다
						//	파일의 저장위치를 남겨놓는다
						
						// 2. 테이블의 컬럼으로 파일의 내용을 저장
						//	BLOB 타입의 컬럼을 사용한다
						
						//	** 1번 방식 사용할 예정
						//---------------------------
						
						//DB의 테이블에 파일의 원본이름, 업로드된 이름을 기록한다
						//	업로드된 이름은 원본이름과 구분되도록 변경한다
						
						//서버에 저장되는 이름을
						//	"년월일시분초밀리초.확장자" 로 변경하기
						
						//파일명 계산하기 - 현재시간 기준
						//	java.util.Date -> String 변환 : SimpleDateFormat
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
						String rename = sdf.format(new Date());
						
						//확장자 계산하기 - 원본파일 확장자 기준
						String origin = item.getName(); //원본파일명
						int dotIdx = origin.lastIndexOf("."); //가장 마지막 "."의 문자열 인덱스
						String ext = origin.substring(dotIdx + 1); //확장자
						
						//서버에 저장될 파일 이름
						String stored = rename + "." + ext;
						
						System.out.println("[TEST] stored file name : " + stored);
						
						//-----업로드된 파일의 정보를 DTO에 저장하기-----
						uploadFile.setStored_name(origin);
						uploadFile.setOrigin_name(stored);
						
						//---------------------------
						
						//-----임시파일을 실제로 저장하기-----
						//업로드 된 파일이 저장되는 폴더
						File upFolder = new File(context.getRealPath("upload"));
						upFolder.mkdir(); //폴더 생성
						
						//실제 업로드될 파일
						File up = new File(upFolder, stored);
						
						try {
							item.write(up); //실제 업로드(최종 결과 파일 생성됨)
							item.delete(); //임시 파일 삭제
						} catch (Exception e) {
							e.printStackTrace();
						}
								
						//---------------------------

						
					} //if(!item.isFormField()) end
					
				} //whild(iter.hasNext()) end	
				
				//최종 데이터 확인
				System.out.println("[Param] " + paramData);
				System.out.println("[File] " + uploadFile);
				
				//-----DB에 최종 데이터 삽입하기-----
				int res = 0;
				Connection conn = JDBCTemplate.getConnection();
				
				//파라미터 데이터 삽입
				res = nofileDao.insertParam(conn, paramData);
				if(res >= 0) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
				
				//파일 데이터 삽입
				res = nofileDao.insertFile(conn, uploadFile);
				if(res >= 0) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
				
			} //method fileupload() end




	@Override
	public void insertFile(UploadFile up) {
		
		int result = nofileDao.insertFile(JDBCTemplate.getConnection(), up);
		
		if(result > 0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
		
	}
	
	
}
