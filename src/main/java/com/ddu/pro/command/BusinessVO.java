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
public class BusinessVO {
	@Pattern(message = "아이디는 영문자, 숫자 8자 이상이어야 합니다.", regexp = "[a-zA-Z0-9]{8,}")
	private String bn_id;

    @NotBlank(message = "이름은 필수입니다.")
    private String bn_name;
    
    @NotBlank(message = "사업자명은 필수입니다.")
    private String bn_title;
    
    @Pattern(message = "비밀번호는 영문자, 숫자, 특수문자 8자 이상이어야 합니다.", regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+]).{8,}")
    private String bn_pw;

    @NotBlank(message = "사업자번호는 000-00-00000 형식이어야 합니다.")
    @Pattern(message = "000-00-00000 형식이어야 합니다.", regexp = "\\d{3}-\\d{2}-\\d{5}")
    private String bn_num;
    
    @NotBlank(message = "전화번호는 000-000-0000 형식이어야 합니다.")
    @Pattern(message = "000-0000-0000 형식이어야 합니다.", regexp = "\\d{3}-\\d{4}-\\d{4}")
    private String bn_phone;
}
