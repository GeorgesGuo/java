package com.guo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态生成代理对象JDK1.5
public class SecurityHandler implements InvocationHandler {

    private Object targetObject;

    //反射
    public Object proxyInstance(Object paramObject){
        this.targetObject = paramObject;

        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),this);

    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object resultObj = null;
        checkSecurity();
        try {
            resultObj= method.invoke(this.targetObject,args);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resultObj;
    }

    public void checkSecurity(){
        System.out.println("====checkSecurity()====");
    }

}
