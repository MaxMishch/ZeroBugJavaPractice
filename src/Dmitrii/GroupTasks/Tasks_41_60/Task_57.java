package Dmitrii.GroupTasks.Tasks_41_60;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Task_57 {

    public static void main(String[] args) {
//            Given an array nums with 7 integers every element is repeated twice
//            - except one. Find that element and print it to console.
//            Example:
//            nums -> [1, 1, 2, 3, 4, 3, 4]
//            2

//   Dima's solution through the regular Array (not correct! Correct only for current array value)
        int[] nums = {1, 1, 2, 3, 4, 3, 4};
        IntStream nums1 = Arrays.stream(nums).sorted();
        int[] sortedNums = nums1.toArray();
        for (int i = 0; i < sortedNums.length; i++) {
            for (int j = i + 1; j < sortedNums.length; j++) {
                if (sortedNums[i] == sortedNums[j]) {
                    i = j;
                    break;
                } else {
                    System.out.println("Dima - " + sortedNums[i]);
                    if (j < nums.length-1) {
                        i = nums.length-1;
                        break;
                    }
                }
            }
        }


////   Original solution through the frequency method.
//        Integer nums55[] = {1, 1, 2, 3, 4, 3, 4, 7, 4, 9};
//
//        for (int i = 0; i < nums55.length; i++) {
//            //   Frequency method as a constructor from Collections class ask to assign two parameters array as List and int.
//            //   Then it iterates through the list and return result amount of duplicate numbers in comparison.
//            //   Ex. (Arrays.asList(nums55), nums55[i]) --> (Arrays.asList(1, 1, 2, 3, 4, 3, 4), and 1 then 1 then 2 then 3 etc.)
//            //   After each time it return count of duplicate value, and then it compares into if statement, if 1 meaning unique --> Print this value.
//            int count = Collections.frequency(Arrays.asList(nums55), nums55[i]);
//            if (count == 1) {
//                System.out.println("Original - " + nums55[i]);
//            }
//        }

    }//main
}//class
