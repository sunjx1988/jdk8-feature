package jx.sun.feature.parallel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 17:58
 * @Description: 数组并行处理
 */
public class ParallelMain {

    public static void main(String[] args) {
//        Integer[] ints = new Integer[5];
//        Arrays.parallelSetAll(ints, l -> ThreadLocalRandom.current().nextInt());
//        Arrays.stream(ints).forEach(l -> System.out.println(l));
//
//        Arrays.parallelSort(ints);
//        System.out.println("升序排序后");
//        Arrays.stream(ints).forEach(l -> System.out.println(l));
//
//        System.out.println("降序排序");
//        Arrays.parallelSort(ints, Comparator.reverseOrder());
//        Arrays.stream(ints).forEach(l -> System.out.println(l));

        long begin = System.currentTimeMillis();
        String dataFilePath = "E:\\data.txt";
        Charset charset = Charset.forName("UTF-8");
//        System.out.println("开始生成随机数");
//        StringBuffer stringBuffer = new StringBuffer();
//        try {
//            Files.deleteIfExists(Paths.get(dataFilePath));
//            Files.createFile(Paths.get(dataFilePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < 2400; i++) {
//            try {
//                stringBuffer.setLength(0);
//                for (int j = 0; j < 1_024_000; j++) {
//                    stringBuffer.append((int)(Math.random()*1000))
//                    .append("\r\n");
//                }
//                Files.write(Paths.get(dataFilePath), stringBuffer.toString().getBytes(), StandardOpenOption.APPEND);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("随机数生成完成,用时 => " + ((System.currentTimeMillis() - begin) / 1000) + "秒");

        begin = System.currentTimeMillis();
        System.out.println("开始流式处理数据");
        try {
            String resultFilePath = "E:\\result.txt";
            // 将数据流式化
            // 去重
            // 保存
            try {
                Files.deleteIfExists(Paths.get(resultFilePath));
                Files.createFile(Paths.get(resultFilePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Files.lines(Paths.get(dataFilePath), charset)
                    .distinct()
                    .forEachOrdered(a -> {
                        try {
                            Files.write(Paths.get(resultFilePath), (a + "\r\n").getBytes(charset), StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("流式处理数据完成,用时 => " + ((System.currentTimeMillis() - begin) / 1000) + "秒");
    }

    public static void intToByteArray(int a, byte[] bytes) {
        bytes[0] = (byte) ((a >> 24) & 0xFF);
        bytes[1] = (byte) ((a >> 16) & 0xFF);
        bytes[2] = (byte) ((a >> 8) & 0xFF);
        bytes[3] = (byte) (a & 0xFF);
    }
}
