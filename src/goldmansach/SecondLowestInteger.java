package goldmansach;

import java.util.Comparator;
import java.util.stream.IntStream;

public class SecondLowestInteger {

    public static void main(String[] args) {

        int[] input = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int[] result = IntStream.of(input).boxed().sorted(Comparator.naturalOrder()).mapToInt(i -> i).toArray();
        System.out.println(result[1]);
    }

}
