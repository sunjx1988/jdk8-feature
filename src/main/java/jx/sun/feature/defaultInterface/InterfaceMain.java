package jx.sun.feature.defaultInterface;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 17:07
 * @Description: 接口的默认实现 和 静态实现
 */
public class InterfaceMain {
    public static void main(String[] args) {
        DefaultMethod.staticMethod();
        MethodImpl.staticMethod();

        new DefaultMethod(){}.method();
        new DefaultMethodImpl().method();
        new MethodImpl().method();
    }

}

class MethodImpl implements DefaultMethod {
    @Override
    public void method() {
        System.out.println("PrintImpl print");
    }

    static void staticMethod(){
        System.out.println("PrintImpl static method");
    }
}

class DefaultMethodImpl implements DefaultMethod {}

interface DefaultMethod{
    default void method(){
        System.out.println("default method");
    }

    static void staticMethod(){
        System.out.println("static default method");
    }
}
