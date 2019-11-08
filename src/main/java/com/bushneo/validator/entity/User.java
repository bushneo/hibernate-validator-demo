package com.bushneo.validator.entity;

import com.bushneo.validator.group.GroupUser;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private int id;

    @NotNull(message = "姓名不能为空！",groups = GroupUser.GroupB.class)
    private String name;

    @NotNull(message = "地址不能为空！")
    private String address;

    @Size(max = 11, min = 11, message = "长度只能为11位！")
    private String phoneNumber;

    @Email(message = "email地址无效！")
    @NotNull(message = "email地址不能为空！")
    private String email;

//    @Min(value = 0, message = "年龄不合法！")
//    @Max(value = 30, message = "年龄不能大于30岁！")
    @Range(min = 0,max = 150,message = "年龄不合法")
    private int age;

    /**
     * 包含了0
     */
    @Min(value = 0,message = "钱不能为空")
    private double money;

    @NotNull
    @Valid
    private Set<Tag> tags = new HashSet<>();

    @URL(message = "无效的URL地址")
    @NotNull(message = "URL不能为空！",groups = {GroupUser.GroupA.class})
    private String url;


}
