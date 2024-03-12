package com.simple.basic.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoJoinVO;
import com.simple.basic.command.MemoVO;

@Mapper
public interface MemoMapper {
	public void regist(MemoVO vo);
	public ArrayList<MemoVO> getList();
	
}
