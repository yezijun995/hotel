package edu.fdzc.hotel.common.utils.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Bean 工具类
 * 
 * @author yifelix
 */
@Slf4j
public class BeanUtils extends org.springframework.beans.BeanUtils
{
    /** Bean方法名中属性名开始的下标 */
    private static final int BEAN_METHOD_PROP_INDEX = 3;

    /** * 匹配getter方法的正则表达式 */
    private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");

    /** * 匹配setter方法的正则表达式 */
    private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");

    /**
     * Bean属性复制工具方法。
     * 
     * @param dest 目标对象
     * @param src 源对象
     */
    public static void copyBeanProp(Object dest, Object src)
    {
        try
        {
            copyProperties(src, dest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

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
            org.springframework.beans.BeanUtils.copyProperties(sourceObject, t);
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
            org.springframework.beans.BeanUtils.copyProperties(sourceObject, r);
            if (null != consumer) {
                consumer.accept(sourceObject, r);
            }
            return r;
        } catch (Exception e) {
            log.error("convert object error,targetClass:{}", targetClass.getName(), e);
            throw new RuntimeException("convert object error", e);
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
            return null;
        }
        return sourceObjectList.stream().map(sourceObject -> convertObject(sourceObject, targetClass, consumer)).collect(Collectors.toList());
    }

    /**
     * 获取对象的setter方法。
     * 
     * @param obj 对象
     * @return 对象的setter方法列表
     */
    public static List<Method> getSetterMethods(Object obj)
    {
        // setter方法列表
        List<Method> setterMethods = new ArrayList<Method>();

        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();

        // 查找setter方法

        for (Method method : methods)
        {
            Matcher m = SET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 1))
            {
                setterMethods.add(method);
            }
        }
        // 返回setter方法列表
        return setterMethods;
    }

    /**
     * 获取对象的getter方法。
     * 
     * @param obj 对象
     * @return 对象的getter方法列表
     */

    public static List<Method> getGetterMethods(Object obj)
    {
        // getter方法列表
        List<Method> getterMethods = new ArrayList<Method>();
        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();
        // 查找getter方法
        for (Method method : methods)
        {
            Matcher m = GET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 0))
            {
                getterMethods.add(method);
            }
        }
        // 返回getter方法列表
        return getterMethods;
    }

    /**
     * 检查Bean方法名中的属性名是否相等。<br>
     * 如getName()和setName()属性名一样，getName()和setAge()属性名不一样。
     * 
     * @param m1 方法名1
     * @param m2 方法名2
     * @return 属性名一样返回true，否则返回false
     */

    public static boolean isMethodPropEquals(String m1, String m2)
    {
        return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
    }
}
