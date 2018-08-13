package jx.sun.feature.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 16:53
 * @Description: 集合数据的流式处理
 */
public class StramMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,-2,3,null,34,-5,6,1,21,null,-1);
        long count = list.stream()
                .distinct()     //去重
                .filter(i -> i !=null && i > 0) //过滤
                .peek(System.out::println)      // 打印
                .mapToInt(i -> i * 2)           // 每个元素处理
                .peek(System.out::println)      // 打印
                .count(); //统计

        /**
         * 计算结果
         * 1
         * 2
         *
         * 3
         * 6
         *
         * 34
         * 68
         *
         * 6
         * 12
         *
         * 21
         * 42
         */
    }
}
