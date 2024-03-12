package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.SimpleVO;

// @Controller + @ResponseBody
@RestController
public class RestBasic {

	// 보내는 데이터에 대한 타입 명시
	// produces를 생략하게 되면 자동으로 JSON 타입이 된다.
	@GetMapping(value = "/aaa", produces="text/plain")
	public String aaa() {
		
		return "야 ㅅㅂ러마 이게 rest API 냐?";
	}
	
	// 데이터를 보내는 방법
	@GetMapping(value = "/bbb", produces = "application/json")
	public SimpleVO bbb() {
		
		return new SimpleVO("aaa123", 23, "naver", "서울시");
	}
	
	@GetMapping("/getObject")
	public Map<String, Object> getObject(){
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", 1);
		map.put("data", new SimpleVO("bbb123", 21, "naver", "경기도"));
		
		return map;
	}
	
	// 리스트 반환
	// 예 게시글 목록
	@GetMapping("/getObject2")
	public List<SimpleVO> getObject2(){
		
		List<SimpleVO> list = new ArrayList<>();
		list.add(new SimpleVO("ccc123", 25, "daum", "서울"));
		list.add(new SimpleVO("ddd123", 40, "naver", "경기도"));
		
		return list;
	}
	
	// 데이터를 받는 방법
	// get => 쿼리스트림 or URI, 파라미터를 사용해서 데이터를 넘겨줍니다.
	// getData?id=aaa123&age=23
	
//	@GetMapping("/getData")
//	public String getData(@RequestParam("id") String id,
//						  @RequestParam("age") int age) {
//		
//		System.out.println(id + " / " + age);
//		
//		return "success";
//	}
	
	@CrossOrigin("*")
	@GetMapping("/getData")
	public String getData(SimpleVO vo) {
		
		System.out.println(vo.toString());
		
		return "success";
	}
	
	//getData2/홍길동/1
	//가변파라미터 사용
	@GetMapping("/getData2/{name}/{age}")
	public String getData2(@PathVariable("name") String name,
						   @PathVariable("age") int age) {
		
		System.out.println(name + " / " + age);
		
		return "성공!";
	}
	
	// POST 방식으로 데이터 받는 방법
	// FORM 형식으로 데이터를 보내고, 받는 방법
	@PostMapping("/getForm")
	public String getForm(SimpleVO vo) {
		
		System.out.println(vo.toString());
		
		return "success";
	}
	
	//@RequestBody가 있어야 json 데이터 수신시 올바르게 수신된다.
//	@PostMapping("/getJSON")
//	public String getJSON(@RequestBody SimpleVO vo) {
//		System.out.println(vo.toString());
//		return "success";
//	}
	
	@CrossOrigin("*")
	@PostMapping("/getJSON")
	public String getJSON(@RequestBody Map<String, Object> map) {
		System.out.println(map.toString());
		return "success";
	}
	
	// consumes -> 반드시 이 타입으로 보낼 시 
	// produces -> 내가 이 타입으로 보낼 때 
	@PostMapping(value = "/getResult", consumes = "application/json")
	public String getResult(String str) {
		System.out.println(str);
		return "success";
	}
	
	// 응답문서 상세하게 작성하기 @ResponseEntity<보내는타입>
	@PostMapping("/createResponse")
	public ResponseEntity<SimpleVO> createResponse(){
		
		SimpleVO vo = new SimpleVO("aaa123", 20, "bbb", null);
		
		HttpHeaders header = new HttpHeaders();
		// 키(이미 정의) , 값(원하는 값 입력)
		header.add("Authorization", "my json web token");
		header.add("Content-Type", "application/json");
		header.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(vo, header, HttpStatus.OK);
		
		//return new ResponseEntity<>(new SimpleVO("aaa123", 20, "naver", null), HttpStatus.OK);
		
	}
//	
//	1.
//	클라이언트 fetch
//	요청주소 : /api/v1/getData
//	메서드 : get
//	클라이언트에서 보낼데이터는 : num, name
//	서버에서 보낼데이터는 : SimpleVO
//	받을 수 있는 restAPI를 생성, 클라이언트에서는 fetch로 호출
	
//	@GetMapping("/api/v1/getData")
//	public SimpleVO getDatas(@RequestParam("num") int num, @RequestParam("name") String name ) {
//		
//		return new SimpleVO(name, num, null, null);
//	}
	
	@GetMapping("/api/v1/getData")
	public ResponseEntity<SimpleVO> test01(@RequestParam("num") int num, @RequestParam("name") String name){
		System.out.println(num + " / " + name);
		System.out.println("///////////////////");
		// 서비스 -> dao -> db 
		
		return new ResponseEntity<SimpleVO>(new SimpleVO("홍길동", 10, null, null), HttpStatus.OK);
				
	}
	
//  
//   2.
//	 클라이언트 fetch요청
//	 요청주소 : /api/v1/getInfo
//	 메서드 : post
//	 클라이언트에서 보낼데이터는 : num, name
//	 서버에서 보낼데이터는 : 리스트<SimpleVO>
//	 받을 수 있는 restAPI를 생성
//	 ResponseEntity로 응답
//   받을 수 있는 restAPI를 생성, 클라이언트에서는 fetch로 호출
	
//	@PostMapping("/api/v1/getInfo")
//	public ResponseEntity<List<SimpleVO>> rs(@RequestBody Map<String, Object> map){
//		
//		List<SimpleVO> vo = new ArrayList<>();
//		vo.add(new SimpleVO((String)map.get("name"), (Integer)map.get("num"), null, null));
//		
//		HttpHeaders header = new HttpHeaders();
//		// 키(이미 정의) , 값(원하는 값 입력)
//		header.add("Authorization", "my json web token");
//		header.add("Content-Type", "application/json");
//		header.add("Access-Control-Allow-Origin", "*");
//		
//		System.out.println(vo.toString());
//		
//		return new ResponseEntity<>(vo, header, HttpStatus.OK);
//		
//	}
	@PostMapping("/api/v1/getInfo")
	public ResponseEntity<List<SimpleVO>> test02(@RequestBody Map<String, Object> map){
		System.out.println(map.toString());
		List<SimpleVO> list = new ArrayList<>();
		list.add(new SimpleVO("ccc123", 25, "daum", "서울"));
		list.add(new SimpleVO("ddd123", 40, "naver", "경기도"));
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}






