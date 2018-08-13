package jx.sun.feature.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Auther: sunjx
 * @Date: 2018/8/13 0013 17:46
 * @Description: Base64
 */
public class Base64Main {
    public static void main(String[] args) {
        final String source = "abcd";
        String target ;
        String encodedString;

        encodedString = new String(Base64.getEncoder().encode(new String(source).getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);

        target = new String(Base64.getDecoder().decode(encodedString), StandardCharsets.UTF_8);

        System.out.println("encodedString => " + encodedString);
        System.out.println("decodedString => " + target);
    }
}
