package com.simple.basic.service;

import java.util.ArrayList;

import com.simple.basic.command.MemoVO;

public interface MemoService {

	public void regist(MemoVO vo);
	public ArrayList<MemoVO> getList();
}
