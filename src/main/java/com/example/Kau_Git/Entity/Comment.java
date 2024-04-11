package com.example.Kau_Git.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long commentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_ID", referencedColumnName = "POST_ID", foreignKey = @ForeignKey(name = "FK_COMMENT_POST_ID"))
    private Posting posting;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WRITER_ID", referencedColumnName = "USERID", foreignKey = @ForeignKey(name = "FK_COMMENT_WRITER_ID"))
    private User writer;

    @Column(name = "WRITE_DATE", nullable = false)
    private LocalDateTime writeDate = LocalDateTime.now();

    @Column(name = "ORD")
    private Short ord;

    @Column(name = "GROUP_ORD")
    private Short groupOrd;

    @Column(name = "CONTENT", length = 300)
    private String content;

    @Column(name = "WARNING_CNT")
    private Integer warningCnt;

    @Column(name = "IS_HIDE_FLAG", nullable = false)
    private boolean isHideFlag = false;
}