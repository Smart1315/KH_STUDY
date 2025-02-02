package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Employee;

public class EmployeeDAO {

	public ArrayList<Employee> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Employee> list = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 사용하고자 하는 DBMS Driver등록
			// 해당 Driver로부터 Connection instance 획득
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1545:xe", "SCOTT", "SCOTT");

			String query = "SELECT * FROM EMP"; // 0 ~ n개

			// Statement vs PreparedStatement
			// 쿼리 완성 쿼리 미완성

			stmt = conn.createStatement();

			// SELECT INSERT/UPDATE/DELETE(DML)
			// ResultSet int
			// executeQuery() executeUpdate()

			rset = stmt.executeQuery(query);

			list = new ArrayList<Employee>();
			Employee emp = null;

			while (rset.next()) {
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("comm");
				int deptNo = rset.getInt("DeptNo");

				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	public Employee selectEmployee(int empNo) {
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Employee emp = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1545:xe", "SCOTT", "SCOTT");

//			String query = "SELECT * FROM EMP WHERE EMPNO = " + empNo;
			String query = "SELECT * FROM EMP WHERE EMPNO = ?";

//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);

//			rset = stmt.executeQuery(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("comm");
				int deptNo = rset.getInt("DeptNo");

				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return emp;

	}

	public int insertEmployee(Employee e) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1545:xe", "SCOTT", "SCOTT");

//			String query = "INSERT INTO EMP VALUES(" + e.getEmpNo() + ", " 
//													 + e.getEmpName() + ", " 
//													 + e.getJob() + ", " 
//													 + e.getMgr() + ", " 
//													 + "SYSDATE, " 
//													 + e.getSal() + ", " 
//													 + e.getComm() + ", " 
//													 + e.getDeptNo() + ")";

			String query = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getMgr());
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComm());
			pstmt.setInt(7, e.getDeptNo());

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return result;
	}

	public int updateEmployee(Employee e) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1545:xe", "SCOTT", "SCOTT");

			String query = "UPDATE EMP SET JOB = ?, SAL = ?, COMM = ? WHERE EMPNO = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, e.getJob());
			pstmt.setInt(2, e.getSal());
			pstmt.setInt(3, e.getComm());
			pstmt.setInt(4, e.getEmpNo());

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return result;
	}

	public int deleteEmployee(int empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1545:xe", "SCOTT", "SCOTT");

			String query = "DELETE FROM EMP WHERE EMPNO = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
