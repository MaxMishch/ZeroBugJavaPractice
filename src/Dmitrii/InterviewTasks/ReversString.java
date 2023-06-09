package Dmitrii.InterviewTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReversString {

    public static void main(String[] args) {
        String string = "Hello World";
        String input = "Geeks For Geeks";
        char[] charStr = string.toCharArray();
        System.out.println("*************************************");
        System.out.println("Trough For Loop: " + reverseStrForLoop(string));
        System.out.println("*************************************");
        System.out.println("Trough String Builder: " + reverseStrBuilder(string));
        System.out.println("*************************************");
        System.out.println("Uses char Array: " + reversStrCharArr(charStr));
        System.out.println("*************************************");
        System.out.println("Uses Arraylist: " + reverseStrList(input));
        System.out.println("*************************************");
        System.out.println("Uses Another Way: " + anotherWayReversString(string));
        System.out.println("*************************************");
    }

    public static String reverseStrForLoop(String str) {
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        return reversedStr;
    }

    public static String reverseStrBuilder(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return reversedStr;
    }

    public static String reversStrCharArr(char[] letters) {
        StringBuilder reverseStr = new StringBuilder();
        for (int i = letters.length - 1; i >= 0; i--) {
            reverseStr.append(letters[i]);
        }
        return reverseStr.toString();
    }

    public static String reverseStrList(String str) {
//        List<Character> arrList = new ArrayList<>();
//        for (Character character : str.toCharArray()) {
//            arrList.add(character);
//        }
//        Collections.reverse(arrList);
//        return arrList.toString().replace(", ", "").replace("[","").replace("]","");

        List<Character> arrList = new ArrayList<>();
        String reverse = "";

        for (char c: str.toCharArray()){
            arrList.add(c);
        }
        Collections.reverse(arrList);

//        // Variant 1
//        Object[] arr2 = arrList.toArray();
//        for(int i = 0; i <arr2.length; i++) {
//            reverse += arr2[i];
//        }
//        System.out.println(reverse);
//        return str;

        // Variant 2
        return arrList.toString().replace(", ", "").replace("[","").replace("]","");
    }

    public static String anotherWayReversString(String str){
        List<Character> arrList = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            arrList.add(character);
        }
        String revers = arrList.stream()
                               .map(String::valueOf)
                               .collect(Collectors.joining());
        return revers;
    }
}