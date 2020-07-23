package goldmansach;

import java.util.HashSet;

public class FirstNonDuplicateLetter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "aaaabbbbbdeeeee";
        System.out.println(input.charAt(getFirstNonDuplicateLetter(input)));
    }

    private static int getFirstNonDuplicateLetter(String input) {
        // TODO Auto-generated method stub
        HashSet<Integer> searched = new HashSet<>();
        for(int i = 0; i < input.length(); i++) {
            int val = input.codePointAt(i);
            if(!searched.contains(val)) {
                searched.add(val);
                if(input.lastIndexOf(val) == i) {
                    return i;
                } 
            }

        }
        return -1;
    }

}
