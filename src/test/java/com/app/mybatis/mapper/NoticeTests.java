package com.app.mybatis.mapper;

import com.app.mybatis.domain.NoticeDTO;
import com.app.mybatis.domain.NoticeVO;
import com.app.mybatis.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class NoticeTests {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private UserMapper userMapper;

    // 게시글 등록
    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("mina0000@gmail.com");
        userVO.setUserPassword("1234");
        userMapper.select(userVO)
                .map(UserVO::getId)
                .ifPresent((id) -> {
                    NoticeVO noticeVO = new NoticeVO();
                    noticeVO.setUserId(id);
                    noticeVO.setNoticeTitle("게시글3");
                    noticeVO.setNoticeContent("내용3");
                    noticeMapper.insert(noticeVO);
                });
    }

    // 게시글 단일 조회
    @Test
    public void selectTest(){
        Optional<NoticeDTO> notice = noticeMapper.select(3L);
        notice.map(NoticeDTO::toString).ifPresent(log::info);
    }

    // 게시글 전체 조회
    @Test
    public void selectAllTest(){
        List<NoticeDTO> notices = noticeMapper.selectAll();
        notices.stream().map(NoticeDTO::toString).forEach(log::info);
    }

    // 게시글 수정
    @Test
    public void updateTest(){
        noticeMapper.select(2L).ifPresent((noticeDTO) -> {
            NoticeVO noticeVO = new NoticeVO();
            noticeDTO.setNoticeTitle("수정한 제목");
            noticeDTO.setNoticeContent("수정한 내용");

            noticeVO.setId(noticeDTO.getId());
            noticeVO.setNoticeTitle(noticeDTO.getNoticeTitle());
            noticeVO.setNoticeContent(noticeDTO.getNoticeContent());
            noticeMapper.update(noticeVO);
        });
    }

    // 게시글 삭제
    @Test
    public void deleteTest(){
        noticeMapper.select(1L)
                .map(NoticeDTO::getId)
                .ifPresent(noticeMapper::delete);
    }
}
