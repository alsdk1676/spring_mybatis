package com.app.mybatis.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NoticeDTO {
    private Long id;
    private String noticeTitle;
    private String noticeContent;
    private Long userId;
    private String userName;
}
