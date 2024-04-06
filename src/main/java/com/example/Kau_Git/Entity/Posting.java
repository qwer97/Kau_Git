package com.example.Kau_Git.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "POSTING")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID", nullable = false)
    private Long postId;

    @Column(name = "TYPE", length = 1)
    private String type;

    @Column(name = "POST_ORD")
    private Short postOrd;

    @Column(name = "WRITE_DATE")
    private Date writeDate;

    @Column(name = "CLASS", length = 1)
    private String postClass;

    @Column(name = "CONTENT", length = 4000)
    private String content;

    @Column(name = "WRITER_ID")
    private Long writerId;

    @Column(name = "HASHTAG", length = 1000)
    private String hashtag;

    @Column(name = "REPORT_CNT")
    private Short reportCnt;

    @Column(name = "VIEW_CNT")
    private Integer viewCnt;

    @Column(name = "RECOMMENT_CNT")
    private Integer recommentCnt;

    @Column(name = "IS_HIDE", nullable = false)
    private Boolean isHide = false;

}
