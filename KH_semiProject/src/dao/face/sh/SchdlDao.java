package dao.face.sh;

import java.sql.Connection;
import java.util.List;

import dto.Schdl;

public interface SchdlDao {

	/**
	 * �쟾泥� 議고쉶
	 * 
	 * @param conn - DB�뿰寃� 媛앹껜
	 * @return  議고쉶�맂 �뒪耳�以� 紐⑸줉 諛섑솚�븳�떎
	 */
	
	public List<Schdl> seletAll(Connection conn) ;
	
	



}
