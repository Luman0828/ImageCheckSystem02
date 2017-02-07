package com.imagecheck.util;

public class Page {
	private int page;
	private int pageCount;
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	
	public Page(int page, int pageCount, boolean hasNextPage, boolean hasPreviousPage) {
		super();
		this.page = page;
		this.pageCount = pageCount;
		this.hasNextPage = hasNextPage;
		this.hasPreviousPage = hasPreviousPage;
	}
	
	public Page() {
		super();
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	
}
