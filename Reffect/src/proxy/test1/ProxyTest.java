package proxy.test1;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void NikeFactory(){
        //静态代理：要求被代理类和代理类实现同一套接口
        //用代理类取代原始对象，任何对原始对象的调用
        //都要通过代理，代理对象再决定是否调用，何时调用
       NikeFactory nikeFactory = new NikeFactoryProxy();
       nikeFactory.production();
    }
}
