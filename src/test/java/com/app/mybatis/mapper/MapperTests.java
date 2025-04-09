package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberVO memberVO;

    @Test
    public void getTimeTest() {
        log.info("=====================");
//        log.info("{}", timeMapper.getTime());
        log.info("{}", timeMapper.getTime2());
        log.info("=====================");
    }

    @Test
    public void memberInsertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("sma1234@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("홍길동");

        memberMapper.insert(memberVO);
    }

    @Test
    public void memberSelectTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("sma5678@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("이순신");

//        MemberVO foundMember = memberMapper.select(memberVO);
        Optional<MemberVO> foundMember = memberMapper.select(memberVO);

//        foundMember.ifPresent((member) -> {
//            log.info("{}", member);
//        });

//      1번
        foundMember.map(MemberVO::toString).ifPresent(log::info);

//      2번
        foundMember.map(MemberVO::toString).ifPresentOrElse(log::info, () -> {
            new RuntimeException("로그인 실패");
        });
        
//        log.info("{}", foundMember);
    }

    @Test
    public void memberSelectAllTest() {
        memberMapper.selectAll().forEach((memberVO) -> {
            log.info("{}", memberVO);
        });
    }

    @Test
    public void memberUpdateTest() {
//        회원 조회
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("sma5678@gmail.com");
        memberVO.setMemberPassword("1234");
//        Optional<MemberVO> foundUser = memberMapper.select(memberVO); // 옵셔널로 감싸진 memberVO
        memberMapper.select(memberVO).ifPresent((member) -> {
            // 회원 수정
            member.setMemberName("강감찬");
            memberMapper.update(member);
        });
    }

    @Test
    public void memberDeleteTest() {
//        회원 조회
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("sma5678@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId).ifPresent((id) -> {
//            회원 탈퇴
            memberMapper.delete(id);
        });
    }

}
