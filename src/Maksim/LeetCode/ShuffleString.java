package Maksim.LeetCode;

import java.util.Arrays;

public class ShuffleString {

//https://leetcode.com/problems/shuffle-string/

    static String restoreString(String s, int[] indices) {

        String res = "";
        String[] orig = s.split("");
        System.out.println(Arrays.toString(orig));

        for (int index : indices) {
            res += orig[index];
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(restoreString("abc", new int[]{0, 1, 2}));
        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3})); //leetcode

    }
}
