package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {
		Connection conn = getConnection();

		MemberDAO mDAO = new MemberDAO();

		Member loginUser = mDAO.loginMember(conn, member);

		close(conn);

		return loginUser;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();

		int result = new MemberDAO().insertMember(conn, member);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int checkId(String userId) {
		Connection conn = getConnection();

		int result = new MemberDAO().checkId(conn, userId);

		close(conn);

		return result;
	}

	public int checkNickname(String nickName) {
		Connection conn = getConnection();

		int result = new MemberDAO().checkNickname(conn, nickName);

		close(conn);

		return result;
	}

	public Member selectMember(String loginUserId) {
		Connection conn = getConnection();

		Member member = new MemberDAO().selectMember(conn, loginUserId);

		close(conn);

		return member;
	}

	public int updateMember(Member myInfo) {
		Connection conn = getConnection();

		int result = new MemberDAO().updateMember(conn, myInfo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int updatePwd(Member myInfo, String newPwd) {
		Connection conn = getConnection();

		int result = new MemberDAO().updatePwd(conn, myInfo, newPwd);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int memberDelete(String userId) {
		Connection conn = getConnection();

		int result = new MemberDAO().memberDelete(conn, userId);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

}
