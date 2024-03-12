package com.simple.basic.test01;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.MemoJoinVO;
import com.simple.basic.command.UsersJoinVO;
import com.simple.basic.mapper.TestMapper;

@SpringBootTest
public class TestCode02 {

	@Autowired
	TestMapper testMapper;


	@Test public void testCode01() { System.out.println("결과 : " +
			testMapper.getTime()); 
	}


	// 조인의 처리
	// N : 1
	@Test
	public void testCode02() {
		ArrayList<MemoJoinVO> list = testMapper.joinOwn();

		System.out.println(list.toString());
	}
	
	public void testCode03() {
		UsersJoinVO vo = testMapper.joinTwo();
		
		System.out.println(vo.toString());
	}

}
