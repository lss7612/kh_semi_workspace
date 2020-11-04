package dao;

import java.sql.Connection;
import java.util.List;

import dto.ParamData;
import dto.UploadFile;

public interface NoFileDao {
	
	public int insertParam(Connection conn, ParamData paramData);
	
	public int insertFile(Connection conn, UploadFile uploadFile);
	

}
