package com.bo;

public class CustomerBO {

	private String custId;
	private String custName;
	private String mobile;
	private String eMail;
	private String address;
	private String password;
	@Override
	public String toString() {
		return "CustomerBO [custId=" + custId + ", custName=" + custName + ", mobile=" + mobile + ", eMail=" + eMail
				+ ", address=" + address + ", password=" + password + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBO other = (CustomerBO) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}
	public CustomerBO(String custId, String custName, String mobile,
			String eMail, String address, String password) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobile = mobile;
		this.eMail = eMail;
		this.address = address;
		this.password = password;
	}
	public CustomerBO() {
		super();
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
