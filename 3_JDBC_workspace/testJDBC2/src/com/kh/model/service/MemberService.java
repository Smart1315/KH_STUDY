package com.kh.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberService {
	// DAO를 호출하여 데이터 접근/갱신
	// 트랜잭션 처리

	// Controller로부터 인자 전달받음
	// Connection객체 생성
	// DAO객체 생성
	// DAO에 Connection객체, 인자 전달
	// DAO수행결과를 가지고 비즈니스 로직 및 트랜잭션 관리

	public int insertMember(Member mem) {

		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		int result = mDAO.insertMember(conn, mem);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		ArrayList<Member> list = mDAO.selectAll(conn);

		return list;
	}

	public ArrayList<Member> selectMemberId(String id) {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		ArrayList<Member> list = mDAO.selectMemberId(conn, id);

		return list;
	}

	public ArrayList<Member> selectGender(char gender) {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		ArrayList<Member> list = mDAO.selectGender(conn, gender);

		return list;
	}

	public int updateMember(String id) {

		return 0;
	}

	public int checkMember(String memberId) {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		int result = mDAO.checkMember(conn, memberId);

		return result;

	}

	public int updateMember(String input, int sel, String memberId) {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		int result = mDAO.updateMember(conn, input, sel, memberId);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		int result = mDAO.deleteMember(conn, memberId);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public void exitProgram() {
		Connection conn = getConnection();
		close(conn);
	}

}
