package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/29 10:08
 * author:WLK
 */

/**
 * 题目描述 缩写
 * <p>
 * <p>
 * 在英文中,我们会把一些长的名字或者短语进行缩写。例如"looks good to me"缩写为"lgtm",短语中的每个单词的首字母组成缩写。现在给出一个字符串s,字符串s中包括一个或者多个单词,单词之间以空格分割,请输出这个字符串的缩写。
 * 输入描述:
 * <p>
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串中只包括小写字母('a'~'z')和空格。
 * <p>
 * 输出描述:
 * <p>
 * 输出一个字符串,即缩写的结果。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * looks good to me
 * <p>
 * 输出
 * 复制
 * <p>
 * lgtm
 * 解法：水题，不用解法
 */
public class shortWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s.toCharArray()[0]);
        }
        System.out.println(sb.toString());
    }
}
