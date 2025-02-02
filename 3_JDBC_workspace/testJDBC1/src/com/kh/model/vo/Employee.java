package com.kh.model.vo;

import java.sql.Date;

public class Employee {
	// - empNo:int
	// - empName:String
	// - job:String
	// - mgr:int
	// - hireDate:Date
	// - sal:int
	// - comm:int
	// - deptNo:int
	
	// + Employee()
	// + Employee(job:String, sal:int, comm:int)
	// + Employee(empNo:int, job:String, sal:int, comm:int)
	// + Employee(empNo:int, empNmae:String, job:String, mgr:int, sal:int, comm:int, deptNo:int)
	// + Employee(empNo:int, empName:String, job:String, mgr:int, hireDate:Date, sal:int, comm:int, deptNo:int)
	// + getter/setter
	// + toString():String
	// 		empNo / empName / job / mgr / hireDate / sal / comm / deptNo
	
	private int empNo;
	private String empName;
	private String job;
	private int mgr;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptNo;
	
	public Employee() {
	}

	public Employee(String job, int sal, int comm) {
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	public Employee(int empNo, String job, int sal, int comm) {
		this(job, sal, comm);
		this.empNo = empNo;
	}

	public Employee(int empNo, String empName, String job, int mgr, int sal, int comm, int deptNo) {
		this(empNo, job, sal, comm);
		this.empName = empName;
		this.mgr = mgr;
		this.deptNo = deptNo;
	}
	
	public Employee(int empNo, String empName, String job, int mgr, Date hireDate, int sal, int comm, int deptNo) {
		this(empNo, empName, job, mgr, sal, comm, deptNo);
		this.hireDate = hireDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hireDate;
	}

	public void setHiredate(Date hiredate) {
		this.hireDate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return empNo + " / " + empName + " / " + job + " / " + mgr + " / " + hireDate + " / " + sal + " / " + comm + " / " + deptNo;
	}
	
}
