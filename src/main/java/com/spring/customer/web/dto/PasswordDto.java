package com.spring.customer.web.dto;


import com.spring.customer.annotations.ValidPassword;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {

    private String oldPassword;
    private  String token;
    @ValidPassword
    private String newPassword;


}
