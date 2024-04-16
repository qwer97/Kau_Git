package com.example.Kau_Git.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.BindParam;

import java.util.*;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@Getter
@Setter
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID", nullable = false)
    @Getter
    @Setter
    private long userId;

    private String id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "NICKNAME", length = 100)
    private String nickname;

    @Column(name = "PROFILE_IMAGE", length = 1000)
    private String profileImage;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(length = 100)
    private String password;

    @Column(name = "GENDER")
    private Integer gender; // 1이 남성 , 0이 여자

    @Column(name = "RELIGION", length = 100)
    private String religion;

    @Column(name = "NATIONALITY", length = 100)
    private String nationality;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "CONTACT_TYPE")
    private Integer contactType;

    @Column(name = "CONTACT_DETAIL", length = 100)
    private String contactDetail;

    @Column(name = "USER_POINT")
    @Getter
    @Setter
    private Integer userPoint=0;

    @Column(name = "HAS_BANNED_FLAG", nullable = false)
    private Boolean hasBannedFlag = false;

    @Enumerated(EnumType.STRING) // Enum값을 어떤 형태로 저장할지 결정합니다. (기본적은 int)
    @Column(nullable = false)
    private MyRole role; // 사용자의 권한을 관리할 Enum 클래스



    @Builder
    public User(String id,String name, String email, MyRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User update(String name) {
        this.name = name;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}