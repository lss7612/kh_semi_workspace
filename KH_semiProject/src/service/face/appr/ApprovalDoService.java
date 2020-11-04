package service.face.appr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging_app;
import dto.appr.ApprMy;

public interface ApprovalDoService {

	List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp, Paging_app paging);

	Paging_app getPaging(HttpServletRequest req);

}
