package jx.sun.feature.methodrefrence;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 17:24
 * @Description: 方法引用的函数式调用
 */
public class MethodRefrenceMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d","e");
        list.forEach(System.out::println);
        list.forEach(Method::staticPrint);
        list.forEach(new Method()::print);
    }
}

class Method{
    static void staticPrint(String s){
        System.out.println("static print => " + s);
    }

    void print(String s){
        System.out.println("print => " + s);
    }
}
