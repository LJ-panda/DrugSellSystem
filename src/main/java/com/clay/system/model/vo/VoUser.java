package com.clay.system.model.vo;

import com.clay.system.model.enity.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 13:18
 * @Version 1.0
 *
 * 用户对象
 * 用于接收和效验前端传递的用户数据
 * 便于参数效验
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoUser
{
    //@Positive(message = "用户ID必须大于0")
    private int id;

    @NotBlank(message = "用户名不可为空白")
    private String userName;

    @Size(min = 7,max = 35,message = "邮箱的字符数必须在7-35之间")
    @Email(message = "邮箱必须要遵守格式")
    private String email;

    @Size(min = 10,max = 20,message = "密码的位数必须在10-20之间")
    private String password;

    private int status;

    @Size(max = 150,message = "描述必须在150字内")
    private String description;

    @Valid
    private List<Permission>permissions;
}
