package com.example.builder;

public class NewsBuilder {
	private String title;
	private Integer view;
	private String categoryCode;

	public NewsBuilder(Buider buider) {
		this.title = buider.title;
		this.categoryCode = buider.categoryCode;
		this.view = buider.view;
	}

	public static class Buider {
		private String title;
		private Integer view;
		private String categoryCode;

		public Buider setTitle(String title) {
			this.title = title;
			return this;
		}

		public Buider setView(Integer view) {
			this.view = view;
			return this;
		}

		public Buider setCategoryCode(String categoryCode) {
			this.categoryCode = categoryCode;
			return this;
		}

		public NewsBuilder build() {
			return new NewsBuilder(this);
		}

	}
}
