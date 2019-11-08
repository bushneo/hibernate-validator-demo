package com.bushneo.validator.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Bean Validation工具类
 *
 * @Author chenck
 * @Date 2019/1/24 19:43
 */
public class ValidatorUtil {


    private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();

    public static ValidatorFactory getFactory() {
        return FACTORY;
    }

    /**
     * 验证器的初始化
     *
     * @return
     */
    public static Validator getValidator() {
        return FACTORY.getValidator();
    }

    public static <T> Set<ConstraintViolation<T>> validate(T arg) {
        return validate(arg, null);
    }

    /**
     * 验证
     *
     * @param arg
     * @param groups
     * @return
     */
    public static <T> Set<ConstraintViolation<T>> validate(T arg, Class<?>[] groups) {
        if (null == groups || groups.length == 0) {
            return getValidator().validate(arg);
        } else {
            return getValidator().validate(arg, groups);
        }
    }

    public static <T> String dealErrorMsg(Set<ConstraintViolation<T>> violations) {
        return dealErrorMsg(violations, MsgThrowMode.NOT_THROW);
    }

    /**
     * 违反约束信息处理
     *
     * @param violations
     * @param msgThrowMode
     * @return
     */
    public static <T> String dealErrorMsg(Set<ConstraintViolation<T>> violations, int msgThrowMode) {
        if (null == violations || violations.size() == 0) {
            return null;
        }
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<T> constraintViolation : violations) {
            sb.append(constraintViolation.getMessage());
            // throw第一条验证消息
            if (msgThrowMode == MsgThrowMode.THROW_ONE) {
                throw new IllegalArgumentException(sb.toString());
            }
            if (i < violations.size()) {
                sb.append("|");
            }
            i++;
        }
        // throw所有
        if (msgThrowMode == MsgThrowMode.THROW_ALL) {
            throw new IllegalArgumentException(sb.toString());
        }
        return sb.toString();
    }


    // validate and check

    /**
     * 验证并处理违反约束信息
     * 注：默认不抛出异常
     *
     * @param arg
     * @return
     */
    public static <T> String validAndDealMsg(T arg) {
        return dealErrorMsg(validate(arg), MsgThrowMode.NOT_THROW);
    }

    public static <T> String validAndDealMsg(T arg, Class<?>[] groups) {
        return dealErrorMsg(validate(arg, groups), MsgThrowMode.NOT_THROW);
    }

    public static <T> String validAndDealMsg(T arg, int msgThrowMode) {
        return dealErrorMsg(validate(arg), msgThrowMode);
    }

    public static <T> String validAndDealMsg(T arg, Class<?>[] groups, int msgThrowMode) {
        return dealErrorMsg(validate(arg, groups), msgThrowMode);
    }
}
