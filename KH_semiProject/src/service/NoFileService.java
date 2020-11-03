package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface NoFileService {
	
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
	
	public void insertFile(UploadFile up);

}
