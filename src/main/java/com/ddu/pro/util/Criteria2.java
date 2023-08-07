package com.ddu.pro.util;

import lombok.Data;

@Data
public class Criteria2 {
	private int page;
	private int amount;

	//검색에 필요한 키워드를 선언
	private String searchWriter;
	private String searchContent;
	private String searchTitle;
	private String searchTitleCont;
	
	//기본생성자로 만들어지면 1, 10 기본값
	public Criteria2() {
		this.page = 1;
		this.amount = 3;
	}

	//기본생성자 아니면 값 전달 받음
	public Criteria2(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}

	//페이지시작을 저장하는 getter
	public int getPageStart() {
		return (page-1) * amount;
	}




}


