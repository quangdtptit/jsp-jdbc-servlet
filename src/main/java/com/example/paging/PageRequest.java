package com.example.paging;

import com.example.sort.Sorter;

public class PageRequest implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter ;

	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter=sorter;
	}

	public Integer getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public Integer getPage() {
		return this.getPage();
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.maxPageItem!=null)
			return (this.page - 1) * this.maxPageItem;
		else
			return null;
	}

	@Override
	public Integer getLimit() {
		return this.getMaxPageItem();
	}
	
	
	@Override
	public Sorter getSorter() {
		return sorter;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

}
