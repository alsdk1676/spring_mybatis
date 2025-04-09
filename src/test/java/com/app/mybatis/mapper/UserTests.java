package com.app.mybatis.mapper;

import com.app.mybatis.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserVO userVO;

    // 회원 등록
    @Test
    public void userInsertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("mina6789@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("서민아");

        userMapper.insert(userVO);
    }

    // 회원 단일 조회
    @Test
    public void userSelectTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("mina1234@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("서민아");

        Optional<UserVO> foundUser = userMapper.select(userVO);
    }
}
