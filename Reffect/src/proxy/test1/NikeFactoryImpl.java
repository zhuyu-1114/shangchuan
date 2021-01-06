package proxy.test1;
//被代理类
public class NikeFactoryImpl implements NikeFactory{

    @Override
    public void production() {
        System.out.println("生产Nike");
    }
}
