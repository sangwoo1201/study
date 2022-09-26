package com.dw.emp.vo;

import lombok.Getter;
import lombok.Setter;

//VO(Value Object) == DTO(Data Trasfer Object)
@Getter
@Setter
public class EmpVO {
	
	private int empno; //사원 번호
	private String ename; //사원 이름
	private String job; //사원 직책
	private int mgr; //사수 번호
	private String hiredate; //입사 날짜
	private int sal; //급여
	private int comm; //보너스
	private int deptno; //부서 번호
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
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
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
