package com.example.fakecms.autoconfigure.validator;

import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.lang.reflect.Field;

public class EqualFieldValidator implements ConstraintValidator<EqualField, Object> {

    private String srcField;
    private String dstField;
    @Override
    public void initialize(EqualField constraintAnnotation) {
        this.srcField = constraintAnnotation.srcField();
        this.dstField = constraintAnnotation.dstField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        //拿到操作的对象
        Class<?> clazz = object.getClass();

        //获取字段属性值
        Field srcField = ReflectionUtils.findField(clazz, this.dstField);
        Field dstField = ReflectionUtils.findField(clazz, this.dstField);

        try {
            if (srcField == null || dstField == null) {
                throw new ValidationException("反射获取变量失败");
            }

            srcField.setAccessible(true);
            dstField.setAccessible(true);
            Object src = srcField.get(object);
            Object dst = dstField.get(object);

            // 其中一个变量为 null 时，则必须两个都为 null 才相等
            if (src == null || dst == null) {
                return src == dst;
            }

            // 如果两个对象内存地址相同，则一定相等
            if (src == dst) {
                return true;
            }

            // 调用 equals 方法比较
            return src.equals(dst);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
