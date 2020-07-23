package goldmansach;

public class AtioFunction28 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       System.out.println(atoi("     33a2 3"));
    }

    public static int atoi(String s) {
        if(s == null) {
            return 0;
        }
        s = s.trim();
        if(s.length() < 1) {
            return 0;
        }
        char flag = '+';
        int i = 0;
        if(s.charAt(i) == '-') {
            flag = '-';
            i++;
        } else if(s.charAt(i) == '+'){
            i++;
        }
        double result = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }
        
        if(flag == '-') result = -result;
        
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        
        return (int)result;
    }
}
