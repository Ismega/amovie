package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author mega
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String nickname;
    private String email;
    private String password;
    /**
     * 加盐
     */
    private String salt;
    private String phone;
    private Integer gender;
    private Integer role;

    public User(String nickname, String email, String password, String salt, String phone, Integer gender, Integer role) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public User(Integer id, String nickname, String phone, Integer gender, Integer role) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }
}
