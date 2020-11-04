package dao.face.appr;

import java.sql.Connection;

import dto.appr.Appr;
import dto.appr.ApprFile;

public interface WorkDao {

	int insertParam(Connection connection, Appr appr);

	int insertFile(Connection connection, ApprFile uploadFile);

}
