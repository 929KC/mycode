package com.kc.bot.job.util;

import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * PropertyUtil 是一个用于处理 Spring Boot 应用程序中属性解析的实用工具类。
 * 支持 Spring Boot 1.x 和 Spring Boot 2.x 版本，通过动态检测版本进行适配。
 */
public class PropertyUtil {

    // 用于标识检测到的 Spring Boot 版本，1 表示 Spring Boot 1.x，2 表示 Spring Boot 2.x
    private static int springBootVersion = 1;

    static {
        try {
            // 尝试加载 Spring Boot 1.x 版本的类
            Class.forName("org.springframework.boot.bind.RelaxedPropertyResolver");
        } catch (ClassNotFoundException e) {
            // 如果加载失败，将 springBootVersion 更新为 2，表示使用 Spring Boot 2.x
            springBootVersion = 2;
        }
    }

    /**
     * 处理 Spring Boot 中的属性解析，根据检测到的 Spring Boot 版本调用不同的处理方法。
     *
     * @param environment 用于获取属性的 Spring 环境上下文
     * @param prefix      属性键的前缀部分
     * @param targetClass 目标结果的类类型
     * @param <T>         目标结果的泛型类型
     * @return 根据给定前缀解析后的目标结果
     */
    @SuppressWarnings("unchecked")
    public static <T> T handle(final Environment environment, final String prefix, final Class<T> targetClass) {
        switch (springBootVersion) {
            case 1:
                // 如果是 Spring Boot 1.x，调用版本 1 的处理方法
                return (T) v1(environment, prefix);
            default:
                // 如果是 Spring Boot 2.x，调用版本 2 的处理方法
                return (T) v2(environment, prefix, targetClass);
        }
    }

    /**
     * Spring Boot 1.x 版本的属性处理方法。
     *
     * @param environment Spring 环境上下文
     * @param prefix      属性键的前缀部分
     * @return 解析后的属性结果
     */
    private static Object v1(final Environment environment, final String prefix) {
        try {
            // 使用反射获取 RelaxedPropertyResolver 类和相关方法
            Class<?> resolverClass = Class.forName("org.springframework.boot.bind.RelaxedPropertyResolver");
            Constructor<?> resolverConstructor = resolverClass.getDeclaredConstructor(PropertyResolver.class);
            Method getSubPropertiesMethod = resolverClass.getDeclaredMethod("getSubProperties", String.class);

            // 创建 Resolver 对象并调用 getSubProperties 方法解析属性
            Object resolverObject = resolverConstructor.newInstance(environment);
            String prefixParam = prefix.endsWith(".") ? prefix : prefix + ".";
            return getSubPropertiesMethod.invoke(resolverObject, prefixParam);
        } catch (final ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                       | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    /**
     * Spring Boot 2.x 版本的属性处理方法。
     *
     * @param environment  Spring 环境上下文
     * @param prefix       属性键的前缀部分
     * @param targetClass  目标结果的类类型
     * @return 解析后的目标结果
     */
    private static Object v2(final Environment environment, final String prefix, final Class<?> targetClass) {
        try {
            // 使用反射获取 Binder 类和相关方法
            Class<?> binderClass = Class.forName("org.springframework.boot.context.properties.bind.Binder");
            Method getMethod = binderClass.getDeclaredMethod("get", Environment.class);
            Method bindMethod = binderClass.getDeclaredMethod("bind", String.class, Class.class);
            // 创建 Binder 对象并调用 bind 方法绑定属性到目标类
            Object binderObject = getMethod.invoke(null, environment);
            String prefixParam = prefix.endsWith(".") ? prefix.substring(0, prefix.length() - 1) : prefix;
            Object bindResultObject = bindMethod.invoke(binderObject, prefixParam, targetClass);
            // 获取绑定结果的值
            Method resultGetMethod = bindResultObject.getClass().getDeclaredMethod("get");
            return resultGetMethod.invoke(bindResultObject);
        } catch (final ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
                       | IllegalArgumentException | InvocationTargetException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
