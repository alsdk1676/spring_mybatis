package com.app.mybatis.mapper;

import com.app.mybatis.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    // 회원 등록
    public void insert(UserVO userVO);
    // 회원 단일 조회
    public Optional<UserVO> select(UserVO userVO);
    // 회원 전체 조회
    public List<UserVO> selectAll();
    // 회원 수정
    public void update(UserVO userVO);
    // 회원 탈퇴
    public void delete(Long id);
}
