package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;

public class MemberDAO {
	private Properties prop = null;

	public MemberDAO() {
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection conn, Member mem) {
		/*
		 * 이전 프로젝트에서 DAO가 맡은 업무 1) JDBC드라이버 등록 2) DB 연결(Connection객체 생성) 3) SQL 전송 4)
		 * 처리결과에 따른 트랜잭션 처리(commit, rollback) 5) 자원 반납
		 * 
		 * 실제 DAO가 해야하는 역할은 3번 뿐 ==> 쿼리 전송 후 반환 값 받아오기 1, 2, 4, 5번의 경우 어디서든 공통적으로 이루어지기
		 * 때문에 한 번에 묶어서 실행 ==> JDBCTemplate클래스
		 */

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, String.valueOf(mem.getGender()));
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setInt(8, mem.getAge());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Member> selectAll(Connection conn) {

		// SELECT * FROM MEMBER
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;

		String query = prop.getProperty("selectAll");

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<Member>();

			while (rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");

				Member member = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address,
						enrollDate);

				list.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public ArrayList<Member> selectMemberId(Connection conn, String id) {
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();

		String query = prop.getProperty("selectMemberId");

		try {
//			stmt = conn.createStatement();
//			query += " '%" + id + "%'";
//			rset = stmt.executeQuery(query);

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + id + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");

				Member member = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address,
						enrollDate);

				list.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
//			close(stmt);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Member> selectGender(Connection conn, char gender) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();

		String query = prop.getProperty("selectGender");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, String.valueOf(gender));

			rset = pstmt.executeQuery();

			while (rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gen = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");

				Member member = new Member(memberId, memberPwd, memberName, gen, email, phone, age, address,
						enrollDate);

				list.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int checkMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		// SELECT * FROM MEMBER WHERE MEMBER_ID = ? ==> Member
		// SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? ==> int

		String query = prop.getProperty("checkMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int updateMember(Connection conn, String input, int sel, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMember" + sel);
		/*
		 * input : 수정할 값 sel : 어떤 것에 대해 바꿀지 (1-비밀번호 / 2-이메일 / 3-전화번호 / 4-주소) 1) UPDATE
		 * MEMBER SET MEMBER_PWD = ? WHERE MEMBER_ID = ? 2) UPDATE MEMBER SET EMAIL = ?
		 * WHERE MEMBER_ID = ? 3) UPDATE MEMBER SET PHONE = ? WHERE MEMBER_ID = ? 4)
		 * UPDATE MEMBER SET ADDRESS = ? WHERE MEMBER_ID = ? memberId : 누구를 바꿀지
		 */

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, input);
			pstmt.setString(2, memberId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
