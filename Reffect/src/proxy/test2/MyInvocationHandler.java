package proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类对象
public class MyInvocationHandler implements InvocationHandler {
    Object obj;//接口的声明
    public Object setObject(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    //当通过代理类对象发起对重写方法调用时，会调用如下的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Enhance e = new Enhance();
        e.a();
        Object returnValue = method.invoke(obj,args);
        e.b();
        return returnValue;
    }
}
