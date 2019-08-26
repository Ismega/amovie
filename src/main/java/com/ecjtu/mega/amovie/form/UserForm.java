package com.ecjtu.mega.amovie.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author mega
 * @date 2019-08-23 14:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private String nickname;

    @Email(message = "请输入正确的邮箱格式")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotBlank(message = "电话号码不能为空")
    private String phone;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Range(min = 1, max = 2)
    private Integer gender;
}
