package edu.fdzc.hotel.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Slf4j
public class BeanUtil {

    /**
     * T transfer R
     * @param sourceObject
     * @param targetClass
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> T convertObject(R sourceObject, Class<T> targetClass) {
        try {
            if (ObjectUtils.isEmpty(sourceObject)) {
                throw new RuntimeException("sourceObject must not be null");
            }
            T t = targetClass.newInstance();
            BeanUtils.copyProperties(sourceObject, t);
            return t;
        } catch (Exception e) {
            log.error("convert object error,targetClass:{}", targetClass.getName(), e);
            throw new RuntimeException("convert object error",e);
        }
    }

    /**
     * list<T>  convert to list<R>
     *
     * @param sourceObjectList
     * @param targetClass
     * @param <T>              输入类型
     * @param <R>              输出 类型
     * @return list<R>
     */
    public static <T, R> List<R> convertObjectList(Collection<T> sourceObjectList, Class<R> targetClass) {
        if (CollectionUtils.isEmpty(sourceObjectList)) {
            return null;
        }
        List<R> result = sourceObjectList.stream().map(sourceObject -> {
            return convertObject(sourceObject, targetClass);
        }).collect(Collectors.toList());
        return result;
    }

    /**
     * T transfer R
     *
     * @param sourceObject 输入
     * @param targetClass  输出
     * @param consumer     对目标对象进行额外操作：比如赋值等
     * @param <T>          输入类型
     * @param <R>          输出 类型
     * @return R
     */
    public static <T, R> R convertObject(T sourceObject, Class<R> targetClass, BiConsumer<T, R> consumer) {
        try {
            if (ObjectUtils.isEmpty(sourceObject)) {
                throw new RuntimeException("sourceObject must not null");
            }
            R r = targetClass.newInstance();
            BeanUtils.copyProperties(sourceObject, r);
            if (null != consumer) {
                consumer.accept(sourceObject, r);
            }
            return r;
        } catch (Exception e) {
            log.error("convert object error,targetClass:{}", targetClass.getName(), e);
            throw new RuntimeException("convert object error",e);
        }
    }

    /**
     * list<T>  convert to list<R>
     *
     * @param sourceObjectList 输入
     * @param targetClass      输入
     * @param <T>              输入类型
     * @param <R>              输出 类型
     * @param consumer         对目标对象进行额外操作：比如赋值等
     * @return list<R>
     */
    public static <T, R> List<R> convertObjectList(Collection<T> sourceObjectList, Class<R> targetClass, BiConsumer<T, R> consumer) {
        if (CollectionUtils.isEmpty(sourceObjectList)) {
            throw new RuntimeException("sourceObjectList is null");
        }
        return sourceObjectList.stream().map(sourceObject -> convertObject(sourceObject, targetClass, consumer)).collect(Collectors.toList());
    }
}
