package com.simple.basic.test01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.SimpleVO;



@SpringBootTest
public class TestCode01 {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void test01() {
		
//		Builder builder = BuilderVO.builder();
//		
//		BuilderVO vo =  builder.name("홍길동").age(20).build();
		
		BuilderVO vo = BuilderVO.builder().name("홍길동").age(20).build();
		
		SimpleVO svo = SimpleVO.builder().id("aaa123").age(20).email("bbb").build();
		
		System.out.println(svo);
	}
}
