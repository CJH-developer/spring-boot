package com.simple.basic.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;
import com.simple.basic.mapper.MemoMapper;

@Service("MemoService")
public class MemoServiceImpl implements MemoService{

	@Autowired
	private MemoMapper memoMapper;
	
	@Override
	public void regist(MemoVO vo) {
		memoMapper.regist(vo);
		
	}

	@Override
	public ArrayList<MemoVO> getList() {
		
		return memoMapper.getList();
	}


}
