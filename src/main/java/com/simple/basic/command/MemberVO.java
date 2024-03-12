package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	@NotBlank(message = "아이디를 입력해주세요.")
	@Pattern(regexp="[a-zA-Z0-9])){8,}", message="옳바른 형식이 아닙니다.")
	private String id;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,}" , message="형식을 지켜주세요")
	private String pw;
}
