package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	//인코딩 설정값 변수 
	private String charset = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터클래스 초기화 메소드
		
		
		//web.xml에 설정한 초기화파라미터(<init-param>) 변수 값 얻어오기
		charset = filterConfig.getInitParameter("enc");
		
		System.out.println(charset);
		
		System.out.println( filterConfig.getInitParameter("var"));
		
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//HTTP요청 전, HTTP 응답 후 필터링 처리 메소드
		
		System.out.println("EncodingFilter [dofilter]");
		
		//컨트롤러 처리 전
		System.out.println("컨트롤러 처리 전");
		//전달 파라미터 한글 인코딩 설정
		request.setCharacterEncoding(charset);
		
		//-----------------
		//요청정보를 컨트롤러로 보내는 코드
		chain.doFilter(request, response);
		//-----------------
		
		//컨트롤러 처리 후
		System.out.println("컨트롤러 처리 후");
		
	}
	

}
