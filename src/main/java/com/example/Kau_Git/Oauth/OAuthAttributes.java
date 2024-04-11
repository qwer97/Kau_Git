package com.example.Kau_Git.Oauth;

import com.example.Kau_Git.Entity.MyRole;
import com.example.Kau_Git.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Slf4j
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OAuthAttributes { //사용자 정보 전달
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;
    private MyRole role;
    private String id;


    public OAuthAttributes(String oauthId,Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture, MyRole mr) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role =mr;
        this.id=oauthId;

    }


    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("google".equals(registrationId)){
            return ofGoogle(userNameAttributeName, attributes);

        }
        return ofNaver("id",attributes);
    }

    // OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야한다.
    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        if (attributes.get("response") instanceof Map<?, ?>) {
            @SuppressWarnings("unchecked") // 형변환 경고 억제
            Map<String,Object> response = (Map<String, Object>) attributes.get("response");

            return OAuthAttributes.builder()
                    .name((String) response.get("name"))
                    .email((String) response.get("email"))
                    .attributes(response)
                    .nameAttributeKey(userNameAttributeName)
                    .build();
        } else {
            log.error("Type mismatch. 'response' is not of type Map<String, Object>.");
            throw new ClassCastException("Type mismatch. 'response' is not of type Map<String, Object>.");
        }
    }


    // User 엔티티 생성 (생성 시점은 처음 가입할 때)
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(MyRole.USER) // 가입할 때 기본 권한
                .build();
    }
}