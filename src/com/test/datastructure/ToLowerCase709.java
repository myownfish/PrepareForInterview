package com.test.datastructure;

public class ToLowerCase709 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ToLowerCase709 toLowerCase = new ToLowerCase709();
        System.out.println(toLowerCase.toLowerCase("aaAA!"));

    }
    
   public String toLowerCase(String str) {
        char[] result = new char[str.length()];
        for(int i = 0; i<str.length(); i++) {
            int c = (int)str.charAt(i);
            if(c >= 65 && c <= 90) {
                result[i] = (char) (c + 32);
            } else {
                result[i] = (char) c;
            }
        }
        return String.valueOf(result);
    }

}
