package dao.face.appr;

import java.sql.Connection;

import dto.appr.ApprMy;

public interface ApprovalDoUpdateDao {

	int UpdateParam(Connection conn, ApprMy apprmy);

}
