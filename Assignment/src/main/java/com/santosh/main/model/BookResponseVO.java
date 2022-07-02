package com.santosh.main.model;

import java.util.List;

public class BookResponseVO<S,F> {
	private long totalRecords;
	private long totalfailedRecords;
	private long totalPaginationRecords;
	private int pageNumber;
	public int searchIn;
	private List<S> success;
	private List<FailedVO<F>> failed;
	public long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public long getTotalfailedRecords() {
		return totalfailedRecords;
	}
	public void setTotalfailedRecords(long totalfailedRecords) {
		this.totalfailedRecords = totalfailedRecords;
	}
	public long getTotalPaginationRecords() {
		return totalPaginationRecords;
	}
	public void setTotalPaginationRecords(long totalPaginationRecords) {
		this.totalPaginationRecords = totalPaginationRecords;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getSearchIn() {
		return searchIn;
	}
	public void setSearchIn(int searchIn) {
		this.searchIn = searchIn;
	}
	public List<S> getSuccess() {
		return success;
	}
	public void setSuccess(List<S> success) {
		this.success = success;
	}
	public List<FailedVO<F>> getFailed() {
		return failed;
	}
	public void setFailed(List<FailedVO<F>> failed) {
		this.failed = failed;
	}
	@Override
	public String toString() {
		return "BookResponseVO [totalRecords=" + totalRecords + ", totalfailedRecords=" + totalfailedRecords
				+ ", totalPaginationRecords=" + totalPaginationRecords + ", pageNumber=" + pageNumber + ", searchIn="
				+ searchIn + ", success=" + success + ", failed=" + failed + "]";
	}
}
