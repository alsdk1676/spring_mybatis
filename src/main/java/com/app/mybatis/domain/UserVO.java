package com.app.mybatis.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userName;
}
