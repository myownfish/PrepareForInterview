package goldmansach;

public class FibonacciNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        fib(5);
        System.out.println(Integer.MIN_VALUE );

        System.out.println(Float.MIN_VALUE);

        System.out.println(Integer.MIN_VALUE < Float.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE < Float.MAX_VALUE);
    }
    
    private static Integer[] cache = new Integer[31];

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public static int memoize(int N) {
      if (cache[N] != null) {
          return cache[N];
      }
      cache[N] = memoize(N-1) + memoize(N-2);
      return memoize(N);
    }

    //bottom to top
    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }

        int[] mem = new int[N + 1];
        mem[0] = 0;
        mem[1] =1;
        for (int i = 2; i < mem.length; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[N];
    }
    
    public int fib3(int N) {
        if (N<=1) {
            return N;
        }
        if (N==2) {
            return 1;
        }
        int prev1 = 1;
        int prev2 = 1;
        int current = 0;
        
        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
