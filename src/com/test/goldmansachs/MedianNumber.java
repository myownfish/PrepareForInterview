package com.test.goldmansachs;

import java.util.Comparator;
import java.util.stream.IntStream;

public class MedianNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums1 = {1,2,3};
        int[] nums2 = {4};
        double result = calculateMedianNumber(nums1, nums2);
        System.out.println(result);
    }

    private static double calculateMedianNumber(int[] nums1, int[] nums2) {
        int length = 0;
        int[] array =  null;
        if(nums1 == null && nums2 != null) {
            length = nums2.length;
            array = nums2;
        } else if(nums1 != null && nums2 == null) {
            length = nums1.length;
            array = nums1;
        } else {
            length = nums1.length + nums2.length;
            array = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).boxed().sorted(Comparator.naturalOrder()).mapToInt(i -> i).toArray();

        }
        if(length == 1)
            return array[0];
        if(length % 2 == 0) {
            int[] position = {length/2-1, length/2 + 1};
            double result = (array[length/2-1] + array[length/2])/2.0;
            return result;
        } else {
            int position = length/2;
            return array[position];
        }
    }

}
