package com.ict.edu2;

import java.io.Serializable;
import java.util.List;

public class Protocol implements Serializable {
	// 통신 규약(프로토콜)
	// cmd => 0 : 종료(접속해제)
	// cmd => 1 : 회원가입 // 결과가 int result(int);
	// cmd => 2 : 업데이트 //결과가 int result(int);
	// cmd => 3 : 아이디 찾기 // 결과가 vo
	// cmd => 4: 불러오기 // 결과가 vo
	// cmd => 5: 가입 결과 => 0 이면 실패, 1이면 성공
	// cmd => 6: 아이디 중복체크 result; 0(아이디 없음), 1 이상(아이디 있음)
	// cmd => 7: 패스워드 찾기 // 결과가 vo
	// cmd => 8: 로그인하기 vo

	int cmd;
	List<Customer_2VO> clist;
	int result;
	Customer_2VO vo;
	int custid;
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public List<Customer_2VO> getClist() {
		return clist;
	}

	public void setClist(List<Customer_2VO> clist) {
		this.clist = clist;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Customer_2VO getVo() {
		return vo;
	}

	public void setVo(Customer_2VO vo) {
		this.vo = vo;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

}
