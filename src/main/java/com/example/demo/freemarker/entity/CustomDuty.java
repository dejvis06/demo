package com.example.demo.freemarker.entity;

public class CustomDuty {

	private String awbNo;

	private String value;

	private String currency;

	private String dhlValue;

	private String totalValue;

	public CustomDuty(String awbNo, String value, String currency, String dhlValue, String totalValue) {
		super();
		this.awbNo = awbNo;
		this.value = value;
		this.currency = currency;
		this.dhlValue = dhlValue;
		this.totalValue = totalValue;
	}

	public String getAwbNo() {
		return awbNo;
	}

	public String getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	public String getDhlValue() {
		return dhlValue;
	}

	public String getTotalValue() {
		return totalValue;
	}

}
