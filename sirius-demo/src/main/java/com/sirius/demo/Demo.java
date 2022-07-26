package com.sirius.demo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description TODO
 * @createTime 2022年07月26日 17:48:00
 */
public class Demo {
    public static String Replace(char[] replace, String replaced) {
        String flag = "SUCESS";
        String flag_1 = "";
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char word : replace) {
            if ('a' < word && word < 'z') {
                switch (word) {
                    case 'a':
                        replaced = ")" + replaced;
                        flag_1 = "(";
                    case 'b':
                    default:
                        flag = "ERRO 数组内容不符合规定";
                }
                char i = stack.removeFirst();
                while (i < 'A' && i > 'Z') {
                    replaced = i + replaced;
                    i = stack.removeFirst();
                }
                if (i != word - 32) {
                    flag = "ERRO 数组中有多余字母";
                } else {
                    replaced = flag_1 + replaced;
                }
            } else {
                stack.addFirst(word);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s= "aassssss";
        char[] chars = s.toCharArray();
        Replace(chars,"s");
    }
}
