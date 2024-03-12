package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoJoinVO {

	private int mno;
	private String writer;
	private String memo;
	
	// N : 1인 경우 : N 쪽에 컬럼 추가
	private String id;
	private String name;
	private String email;
}

