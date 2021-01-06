package proxy.test2;

public class Test {
    @org.junit.Test
    public void proxyTest(){
        //1.创建一个被代理类对象
        SubjectImpl subject = new SubjectImpl();
        //2.创建一个InvocationHander接口
        MyInvocationHandler handler = new MyInvocationHandler();
        //3.调用方法，会动态的返回一个被代理类接口的对象
        Object obj = handler.setObject(subject);
        Subject sub = (Subject)obj;
        sub.method();
    }
}
