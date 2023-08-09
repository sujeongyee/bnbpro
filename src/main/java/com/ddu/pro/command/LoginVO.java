package com.ddu.pro.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVO {
	@NotBlank(message = "아이디를 입력해주세요.")
	private String bn_id;
    
	@NotBlank(message = "비밀번호를 입력해주세요.")
    private String bn_pw;
}
