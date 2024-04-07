package com.example.Kau_Git.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyRole {// spring security에는 항상 권한 코드에 ROLE이 앞에 붙어야 한다.
    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","사용자");

    private final String key;
    private final String string;
}
