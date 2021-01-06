package proxy.test1;
//代理类
public class NikeFactoryProxy implements NikeFactory{
    NikeFactory nikeFactory;
    public NikeFactoryProxy(){
        nikeFactory = new NikeFactoryImpl();
    }
    @Override
    public void production() {
        System.out.println("收取中介费");
        nikeFactory.production();
    }
}
