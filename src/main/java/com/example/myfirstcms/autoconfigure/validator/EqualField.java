package com.example.myfirstcms.autoconfigure.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EqualFieldValidator.class)
public @interface EqualField {
    /**
    *原属性
     * */
    String srcField();

    /**
     * 目标属性
     */
    String dstField();

    String message() default "the two fields must be equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
