package com.santosh.main.model;

import java.util.List;

import com.google.gson.JsonObject;

public class FailedVO<T> {
	
	private T identityDetails;
	private JsonObject identityDetailsAsString;
	private List<ErrorVO> errors;
	public T getIdentityDetails() {
		return identityDetails;
	}
	public void setIdentityDetails(T identityDetails) {
		this.identityDetails = identityDetails;
	}
	public JsonObject getIdentityDetailsAsString() {
		return identityDetailsAsString;
	}
	public void setIdentityDetailsAsString(JsonObject identityDetailsAsString) {
		this.identityDetailsAsString = identityDetailsAsString;
	}
	public List<ErrorVO> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorVO> errors) {
		this.errors = errors;
	}
	@Override
	public String toString() {
		return "FailedVO [identityDetails=" + identityDetails + ", identityDetailsAsString=" + identityDetailsAsString
				+ ", errors=" + errors + "]";
	}
}
