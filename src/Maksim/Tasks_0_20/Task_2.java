package Maksim.Tasks_0_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_2 {

//    use Array sort
//    Write a return method that check if a string is build out of the same letters as another string.
//    String g="abc";
//    String h="cab";
//    Ex:  same("abc",  "cab"); -> true
//    same("abc",  "abb"); -> false:


    public static boolean isSameStr(String g, String h) {
        char[] charG = g.toCharArray();
        char[] charH = h.toCharArray();
        Arrays.sort(charG);
        Arrays.sort(charH);
        return Arrays.equals(charG, charH);
    }

    public static boolean checkArrayStr(String[] str) {

        boolean result = true;
        String example = str[0];

        for (int i = 1; i < str.length; i++) {

            char[] chars = str[i].toCharArray();
            Arrays.sort(chars);
            str[i] = new String(chars);

            result = example.equals(str[i]);
        }
        return result;
    }

    public static boolean checkArrayStr(List<String> list) {
        String example = list.get(0);
        boolean result = true;
        for (String str : list) {
            str = Stream.of(str.split(""))
                    .sorted()
                    .collect(Collectors.joining());
        }
        for (String s : list) {
            result = example.equals(s);
        }
        return result;
    }

    public static void main(String[] args) {

        String g="abc";
        String h="cab";
        System.out.println(isSameStr(g,h));

        String[] str = new String[] {"abc", "cab", "bac"};
        System.out.println(checkArrayStr(str));

        List<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println(checkArrayStr(list));
    }
}


