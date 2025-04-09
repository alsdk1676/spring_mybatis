package com.app.mybatis.mapper;

import com.app.mybatis.domain.NoticeDTO;
import com.app.mybatis.domain.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {
    // 게시글 등록
    public void insert(NoticeVO noticeVO);
    // 게시글 단일 조회
    public Optional<NoticeDTO> select(Long id);
    // 게시글 전체 조회
    public List<NoticeDTO> selectAll();
    // 게시글 수정
    public void update(NoticeVO noticeVO);
    // 게시글 삭제
    public void delete(Long id);

}
