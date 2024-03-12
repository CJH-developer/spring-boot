package com.simple.basic.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoJoinVO;
import com.simple.basic.command.UsersJoinVO;

@Mapper
public interface TestMapper {

	public String getTime();
	public ArrayList<MemoJoinVO> joinOwn();
	public UsersJoinVO joinTwo();
}
