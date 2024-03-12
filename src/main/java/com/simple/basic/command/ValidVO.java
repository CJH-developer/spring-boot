package com.simple.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidVO {

	/*
	 * @NotNull : null 제외(String, Integer, Long 등에 적용)
	 * @NotEmpty : null 제외 / 공백 제외(String, Map, Arrays)
	 * @NotBlank : null/공백/whitespace 제외 (String)
	 * 
	 * 
	 * @Patter : 정규표현식에 맞는 문자열 정할 수 있다.
	 * @Email : 이메일 형식, blank 허용
	 * @Max : 최대값
	 * @Min : 최소값
	 * 
	 * */
	@NotBlank(message = "이름은 필수 입니다.")
	private String name;
	@NotNull(message = "급여는 필수입니다. ")
	private int salary;
	@Pattern(regexp="[0-9]{3}-[0-9]{4}-[0-9]{4}", message="형식을 유지해주세요.")
	private String phone;
	@Email(message ="옳바른 형식이 아닙니다.") // blank 통과
	private String email;
}
