package service.impl.appr;

import java.io.File;
import java.io.IOException;
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
import dao.appr.FileDao;
import dao.impl.appr.FileDaoImpl;
import dto.appr.Appr;
import dto.appr.ApprFile;
import service.appr.FileService;

public class FileServiceImpl implements FileService {
	
	private FileDao fileDao = new FileDaoImpl();

	
	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;

		

		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		// 1-1.multipart/form-data인코딩으로 전송되지않았을 경우 처리 중단
		if (!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data가 아닙니다</h1>");
			out.append("<a href='/commons/fileupload'>업로드페이지로 이동</a>");

			// fileupload()메소드 중단시키기
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		ServletContext context = req.getServletContext();

		String path = context.getRealPath("tmp");
		System.out.println(path);

		// 임시 저장 폴더
		File repository = new File(path);

		// 폴더 생성
		repository.mkdir();
		factory.setRepository(repository);

		int maxFile = 10 * 1024 * 1024;// 10MB
		// 파일업로드를 수행하는 객체 생성
		// -> DiskFileItemFactory 객체 이용해서 생성한다
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 파일 업로드 용량제한 설정 : 10MB
		upload.setFileSizeMax(maxFile);

		List<FileItem> items = null;

		try {
			// 요청객체에 담겨있는 파일업로드 전달파라미터를 파싱한다
			items = upload.parseRequest(req); // 파일업로드 실행됨
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		Iterator<FileItem> iter = items.iterator();

		// 폼필드를 저장할 DTO 객체 생성
		Appr appr = new Appr();

		// 업로드 파일 정보를 저장할 DTO 객체 생성
		ApprFile apprFile = new ApprFile();

		
		String startDay="";
		String endDay="";
		while (iter.hasNext()) {

			// 요청정보를 하나씩 추출
			FileItem item = iter.next();

			// 1) 빈 파일에 대한 처리
			if (item.getSize() <= 0) {
				continue;
			}
			// 2) 기본 전달 파라미터에 대한 처리 - form-data
			if (item.isFormField()) {
				// 전달 파라미터 처리 개요----
				// formField(form-data)는 key=value 쌍으로 전달된다
				// key는 item.getFieldName()메소드로 얻어온다
				// value는 item.getString()메소드로 얻어온다

				// ** req.setCharacterEncoding("UTF-8"); 적용되지 않는다
				// -> req.getParameter("key");를 사용할 때만 적용된다

				// ** item.getString("UTF-8");로 사용해야 한글 인코딩 적용

				// -----------------------------------
				// -------기본 처리 방식---------------

				out.print("- - - 폼필드 - - -<br>");
				out.println("키 : " + item.getFieldName() + "<br>");
				try {
					out.println("값 : " + item.getString("UTF-8") + "<br>");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}	
				
			//-----------------------------------------------------------------------
			String key = item.getFieldName(); // 키값 추출
			
			
			appr.setAprvl_type("휴가계");

			try {
				if ("r".equals(key)) {
					

					appr.setAppr_holi_kind(item.getString("UTF-8"));
//					appr.setHoliday_end();
				}else if ("title".equals(key)) {// 전달파라미터의 name이 "title"일 때
					
					appr.setAprvl_title(item.getString("UTF-8"));
					System.out.println("title = "+ item.getString("UTF-8"));
				} else if ("reason".equals(key)) {// 전달파라미터의 name이 "title"일 때
					appr.setAprvl_article(item.getString("UTF-8"));
					System.out.println("reason = "+ item.getString("UTF-8"));
					
				} else if ("startday".equals(key)) {
					startDay=item.getString("UTF-8");
					
					
				} else if("start_time".equals(key)) {
					//디버깅
					System.out.println(item.getString("UTF-8"));
					//--
					//--
					startDay += " " + item.getString("UTF-8")+":00.0";
					
					System.out.println(startDay);
					

					java.sql.Timestamp t = java.sql.Timestamp.valueOf(startDay);
					System.out.println(startDay);
					System.out.println(t);
					appr.setHoliday_start(t);
					
				} else if ("endday".equals(key)) {
					endDay = item.getString("UTF-8");
				} else if("end_time".equals(key)) {
					//디버깅
					System.out.println(item.getString("UTF-8"));
					
					//--
					
					endDay += " " + item.getString("UTF-8")+":00.0";
					java.sql.Timestamp t = java.sql.Timestamp.valueOf(endDay);
					
					System.out.println(endDay);
					appr.setHoliday_end(t);
					System.out.println(t);


				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();

			}
			
			
			
			
			//-----------------------------------------------------------------------
		
			// 3) 파일에 대한 처리
			if (!item.isFormField()) {
				// ----업로드된 파일 처리하는 방법 ----
				// 1. 파일을 웹 서버의 로컬 디스크(HDD)에 저장
				// 파일의 정보를 DB에 기록한다
				// 파일의 저장위치를 남겨놓는다

				// 2.테이블의 컬럼으로 파일의 내용을 저장
				// BLOB 타입의 컬럼을 사용한다

				// **우리는 1번 방식을 사용할 예정
				// --------------------------

				// DB의 테이블에 파일의 원본이름,업로드된 이름을 기록한다
				// 업로드된 이름은 원본이름과 구분되도록 변경한다

				// 서버에 저장되는 이름을
				// "년월일시분초밀리초.확장자"로 변경하기

				// 파일명 계산하기 - 현재시간 기준
				// java.util.Date - > String 변환 : SimpleDataFormat 클래스
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ssS");
				String rename = sdf.format(new Date());
				String file_addr = path;
				// 확장자 계산하기 - 원본파일 확장자 기준
				String origin = item.getName();// 원본파일명
				int dotIdx = origin.lastIndexOf("."); // 가장 마지막 "."의 문자열 인덱스
				String ext = origin.substring(dotIdx + 1); // 확장자

				// 서버에 저장될 파일이름
				String stored = rename + "." + ext;

				System.out.println("[TEST] stored file name : " + stored);

				
				
				// 업로드 된 파일이 저장되는 폴더
				File upFolder = new File(context.getRealPath("upload"));
				file_addr=context.getRealPath("upload") +"\\" +stored;
				
				// --------업로드된 파일의 정보를 DTO에 저장하기 ---
				apprFile.setFile_addr(file_addr);
				apprFile.setOrigin_name(origin);
				apprFile.setStored_name(stored);
				// ------------------------------------------------

				// ----임시파일을 실제로 저장하기 ----

				
				upFolder.mkdir();// 폴더 생성
				// 실제 업로드될 파일
				File up = new File(upFolder, stored);

				try {
					item.write(up);// 실제 업로드(최종 결과 파일 생성됨)
					item.delete();// 임시 파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}

				// --------------------------------------------

			} // if(!item.isFormField()) end

		}
		//--------DB에 최종 데이터 삽입하기 ----------
		System.out.println("[File]" + apprFile);
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res=0;
		
		res=fileDao.insertParam(conn,appr);
		if(res >=0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
			
		}
		
		
		res =fileDao.insertFile(conn,apprFile);
		
		if(res >=0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
			
		}
	}
}
