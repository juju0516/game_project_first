package com.ict.edu2;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService2.getFactory().openSession();
		}
		return ss;
	}

	public static int getIns(Customer_2VO cvo) {
		int result = 0;
		try {
			result = getSession().insert("customer2.custIns", cvo);
			ss.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public static int getUp(Customer_2VO cvo) {
		int result = 0;
		result = getSession().update("customer2.custUp", cvo);
		ss.commit();
		return result;
	}

	public static Customer_2VO getpwchk(Customer_2VO cvo) {
		try {
			cvo = getSession().selectOne("customer2.pwchk", cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cvo;
	}

	public static Customer_2VO getIdChk(Customer_2VO cvo) {
		Customer_2VO cvo2 = null;
		try {
			cvo2 = getSession().selectOne("customer2.idchk", cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cvo2;
	}

	public static Customer_2VO getIdChk2(Customer_2VO cvo) {
		Customer_2VO cvo2 = null;
		try {

			cvo2 = getSession().selectOne("customer2.idchk2", cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cvo2;
	}

	public static int getCindex(int cindex) {
		int result = 0;
		result = getSession().selectOne("customer2.cindex", cindex);
		return result;
	}

	public static Customer_2VO getLogin(Customer_2VO cvo) {
		cvo = getSession().selectOne("customer2.login", cvo);
		return cvo;
	}

	public static String getCheck(String id) {
		String idchk = null;
		idchk = getSession().selectOne("customer2.check", id);
		return idchk;
	}

}
