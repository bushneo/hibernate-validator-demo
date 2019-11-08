package com.bushneo.validate.test;

import com.bushneo.validator.entity.Tag;
import com.bushneo.validator.entity.User;
import com.bushneo.validator.group.GroupUser;
import com.bushneo.validator.utils.ValidatorUtil;
import org.junit.Test;

import javax.validation.groups.Default;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bushneo
 * @create 2019-11-08 21:34
 */
public class Test2 {

    @Test
    public void test(){
        User user = new User();
        Set<Tag> tags = new HashSet<>();
        Tag tag = new Tag();
        tags.add(tag);
        user.setTags(tags);
        user.setAge(1);
        user.setMoney(0);

        user.setEmail("sss@163.com");

        String s = ValidatorUtil.validAndDealMsg(user,new Class[]{Default.class,GroupUser.GroupB.class});
        System.out.println(s);
    }
}
