package com.example.sort;

public class Sorter {
	private String elementSort ;
	private String sortBy ;
	
	public Sorter(String elementSort, String sortBy)
	{
		this.elementSort = elementSort;
		this.sortBy=sortBy;
	}
	public String getElementSort() {
		return elementSort;
	}
	public void setElementSort(String elementSort) {
		this.elementSort = elementSort;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
