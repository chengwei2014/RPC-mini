package com.order.rpc.v2;

import com.order.rpc.RpcRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 媒介
 * 2020-06-18
 */
public class Mediator {
    public static Map<String,BeanMethod> map = new ConcurrentHashMap<>();
    private volatile static Mediator instance;

    private Mediator() {
    }

    public static Mediator getInstance(){
        if (null == instance){
            synchronized (Mediator.class){
                if (null == instance){
                    instance = new Mediator();
                }
            }
        }
        return instance;
    }

    public Object processor(RpcRequest request){
        String key = request.getClassName() + "." + request.getMethodName();
        BeanMethod beanMethod = map.get(key);
        if (null == beanMethod){
            return null;
        }
        Object bean = beanMethod.getBean();
        Method method = beanMethod.getMethod();
        try {
            return method.invoke(bean, request.getArgs());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
