package dao.face.appr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.appr.Appr;

public interface ApprovalMyDetailDao {

	/**
	 * 
	 * @param req
	 * @param resp
	 * @param appr apprv_no인자
	 * @return
	 */
	List<Appr> selectByApprvlno(HttpServletRequest req, HttpServletResponse resp, Appr appr);

}
