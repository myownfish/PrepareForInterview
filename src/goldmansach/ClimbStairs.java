package goldmansach;

public class ClimbStairs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(climbStairs(3));
    }
    
    public static int climbStairs(int n) {
        if(n ==1) {
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = dp[1] + dp[2] + 1;
        for(int i = 4 ; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[n];
    }

}
