package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dto.UploadFile;
import service.NoFileService;
import service.NoFileServiceImpl;

@WebServlet("/nofileup")
public class NoFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoFileService nofileService = new NoFileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청완료");
		
		req.getRequestDispatcher("write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청완료");
		
		if(!ServletFileUpload.isMultipartContent(req)) {
			
			//파일 업로드 형식의 요청이 아닐 경우 처리
			
			// 에러페이지에 전달할 메시지
			req.setAttribute("message", "form의 enctype 속성이 안맞습니다");

			// 에러처리하는 정용 View(JSP)로 응답 - forward
			req.getRequestDispatcher("/WEB-INF/views/file/error.jsp")
					.forward(req, resp);
						
			return; //doPost() 메소드를 중단시키기
			
		}
		
		System.out.println("multipart/form-data 방식으로 요청한 경우 처리");
		
		//----- 매개변수 준비 -----
		//1. 요청 객체
		//	-> req
		
		//2. 파일 저장 위치
		String saveDirectory = getServletContext().getRealPath("upload");
		
		//3. 업로드 제한 크기
		int maxPostSize = 10 * 1024 * 1024; //10MB
		
		//4. 한글 인코딩
		String encoding = "UTF-8";
		
		//5. 중복된 파일이름 처리할 정책
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		// *DefaultFileRenamePolicy
		//	이미 업로드 된 파일 중에 같은 이름이 있다면
		//	새롭게 업로드된 파일이름에 번호를 붙여서 구분한다
		//	-> 자동으로 번호 부여함 (1부터 1씩 증가)
		
		//----------------------
		
		//----- COS 파일 업로드 객체 생성 -----
		MultipartRequest mul = new MultipartRequest(
				req
				, saveDirectory
				, maxPostSize
				, encoding
				, policy);
		//MultipartRequest 객체가 생성되면서 파일 업로드를 수행한다
		//----------------------
		
		//원본 파일명
		String origin = mul.getOriginalFileName("upfile");
		
		//저장된 파일명
		String stored = mul.getFilesystemName("upfile");
		
		System.out.println("CosFileUploadController Origin - " + origin);
		System.out.println("CosFileUploadController stored - " + stored);
		
		UploadFile up = new UploadFile();
		up.setOrigin_name(origin);
		up.setStored_name(stored);
		
		nofileService.insertFile(up);
		
		
		resp.sendRedirect("view.jsp");
	}

}
