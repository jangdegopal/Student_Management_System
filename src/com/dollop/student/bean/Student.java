package com.dollop.student.bean;
public class Student {
	
	private Integer stdid;
	private String stdname;
	private String stdEmail;
	private String stdmobileno;
	private Double stdfees;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer stdid, String stdname, String stdEmail, String stdmobileno, Double stdfees) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.stdEmail = stdEmail;
		this.stdmobileno = stdmobileno;
		this.stdfees = stdfees;
	}

	public Student(String stdname, String stdEmail, String stdmobileno, Double stdfees) {
		super();
		this.stdname = stdname;
		this.stdEmail = stdEmail;
		this.stdmobileno = stdmobileno;
		this.stdfees = stdfees;
	}

	/**
	 * @return the stdid
	 */
	public Integer getStdid() {
		return stdid;
	}

	/**
	 * @param stdid the stdid to set
	 */
	public void setStdid(Integer stdid) {
		this.stdid = stdid;
	}

	/**
	 * @return the stdname
	 */
	public String getStdname() {
		return stdname;
	}

	/**
	 * @param stdname the stdname to set
	 */
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	/**
	 * @return the stdEmail
	 */
	public String getStdEmail() {
		return stdEmail;
	}

	/**
	 * @param stdEmail the stdEmail to set
	 */
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	/**
	 * @return the stdmobileno
	 */
	public String getStdmobileno() {
		return stdmobileno;
	}

	/**
	 * @param stdmobileno the stdmobileno to set
	 */
	public void setStdmobileno(String stdmobileno) {
		this.stdmobileno = stdmobileno;
	}

	/**
	 * @return the stdfees
	 */
	public Double getStdfees() {
		return stdfees;
	}

	/**
	 * @param stdfees the stdfees to set
	 */
	public void setStdfees(Double stdfees) {
		this.stdfees = stdfees;
	}

	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", stdEmail=" + stdEmail + ", stdmobileno="
				+ stdmobileno + ", stdfees=" + stdfees + "]";
	}
	

}
