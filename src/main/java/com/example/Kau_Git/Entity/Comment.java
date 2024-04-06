package com.example.Kau_Git.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", nullable = false)
    private Long commentId;

    @Column(name = "POST_ID")
    private Long postId;

    @Column(name = "WRITER_ID")
    private Integer writerId;

    @Column(name = "WRITE_DATE")
    private Date writeDate;

    @Column(name = "ORD")
    private Short ord;

    @Column(name = "GROUP_ORD")
    private Short groupOrd;

    @Column(name = "CONTENT", length = 300)
    private String content;

    @Column(name = "WARNING_CNT")
    private Integer warningCnt;

    @Column(name = "IS_HIDE_FLAG", nullable = false)
    private Boolean isHideFlag = false;

}