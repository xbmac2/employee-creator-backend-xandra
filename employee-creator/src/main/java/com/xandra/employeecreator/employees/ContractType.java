package com.xandra.employeecreator.employees;

public enum ContractType {
	PERMANENT(1), CONTRACT(2);
	
	private int code;
	
	ContractType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
