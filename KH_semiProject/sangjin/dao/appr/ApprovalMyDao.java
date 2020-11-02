package dao.appr;

import java.sql.Connection;
import java.util.List;


import common.Paging_app;
import dto.appr.ApprMy;

public interface ApprovalMyDao {

	List<ApprMy> selectList(Connection connection, ApprMy paramData);

	int selectCntAll(Connection connection,ApprMy apprMy);
	
	

	List<ApprMy> selectList(Connection connection, ApprMy apprMy, Paging_app paging);

}
