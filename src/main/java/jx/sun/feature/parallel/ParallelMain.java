package jx.sun.feature.parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 17:58
 * @Description: 数组并行处理
 */
public class ParallelMain {
    public static void main(String[] args) {
        Integer[] ints = new Integer[5];
        Arrays.parallelSetAll(ints, l -> ThreadLocalRandom.current().nextInt());
        Arrays.stream(ints).forEach(l -> System.out.println(l));

        Arrays.parallelSort(ints);
        System.out.println("升序排序后");
        Arrays.stream(ints).forEach(l -> System.out.println(l));

        System.out.println("降序排序");
        Arrays.parallelSort(ints, (a,b) -> b.compareTo(a));
        Arrays.stream(ints).forEach(l -> System.out.println(l));
    }
}
