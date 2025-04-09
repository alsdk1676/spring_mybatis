package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

// spring한테 알려주기
@Mapper
public interface MemberMapper {
//  회원 등록
    public void insert(MemberVO memberVO);
//  회원 개별 조회
    public Optional<MemberVO> select(MemberVO memberVO);
//  회원 전체 조회
    public List<MemberVO> selectAll();
//  회원 수정
    public void update(MemberVO memberVO);
// 회원 탈퇴
    public void delete(Long id);

}



