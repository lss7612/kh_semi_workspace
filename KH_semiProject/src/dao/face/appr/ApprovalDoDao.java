package dao.face.appr;

import java.sql.Connection;
import java.util.List;

import common.Paging_app;
import dto.appr.ApprMy;

public interface ApprovalDoDao {

	List<ApprMy> selectList(Connection connection, ApprMy apprMy, Paging_app paging);

	int selectCntAll(Connection connection, ApprMy apprMy);

}
