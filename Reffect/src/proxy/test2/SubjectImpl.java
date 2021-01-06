package proxy.test2;
//被代理类
public class SubjectImpl implements Subject{

    @Override
    public void method() {
        System.out.println("是被代理类，记得执行");
    }
}
