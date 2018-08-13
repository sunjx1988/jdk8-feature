package jx.sun.feature.lambda;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 16:43
 * @Description: lambda 表达式
 */
public class LambdaMain {

    public static void main(String[] args) {
        print(() -> System.out.println("hello"));
    }

    static void print(PrintAble printAble){
        printAble.print();
    }
}


interface PrintAble{
    void print();
}
