package goldmansach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class SumOfSubArrayGreaterOrEqualToTarget {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 9, 1 };
        int[] result = twoSum2(nums, 10);

    }

    public static int[] twoSum2(int[] nums, int target) {
        // sort the array desc
        int[] sortedNums = IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        int i = 0;
        int result = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i < sortedNums.length) {
            result += sortedNums[i];
            resultList.add(sortedNums[i]);
            if (result >= target) {
                return resultList.stream().mapToInt(Integer::intValue).toArray();
            }
            i++;
        }
        return null;
    }

}
