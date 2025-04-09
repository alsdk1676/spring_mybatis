package com.app.mybatis.mapper;

import com.app.mybatis.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
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
        userVO.setUserEmail("mina5678@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("서민아");

        Optional<UserVO> foundUser = userMapper.select(userVO);

        foundUser.map(UserVO::toString).ifPresent(log::info);
    }

    // 회원 전체 조회
    @Test
    public void userSelectAllTest(){
        userMapper.selectAll().forEach((userVO) -> {
            log.info(userVO.toString());
//            log.info("{}",userVO);
        });
    }

    // 회원 정보 수정
    @Test
    public void userUpdateTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("mina6789@gmail.com");
        userVO.setUserPassword("1234");
        userMapper.select(userVO).ifPresent((user) -> {
            user.setUserEmail("mina0000@gmail.com");
            userMapper.update(user);
        });
    }

    // 회원 탈퇴
    @Test
    public void userDeleteTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("mina1234@gmail.com");
        userVO.setUserPassword("1234");
        userMapper.select(userVO).map(UserVO::getId).ifPresent((id) -> {
            userMapper.delete(id);
        });
    }
}
