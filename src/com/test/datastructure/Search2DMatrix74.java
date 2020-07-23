package com.test.datastructure;

public class Search2DMatrix74 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {
                  {1,3,5,6},
                  {10, 11, 16, 20},
                  {23, 30, 34, 50}};
        matrix = new int[1][];
        int target = 1;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || (matrix.length ==1 && (matrix[0] == null || matrix[0].length == 0))) {
            return false;
        }
        if(target< matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) {
            return false;
        }
        
        return searchIn2dMatrix(matrix, target);

    }

    private static boolean searchIn2dMatrix(int[][] matrix, int target) {
        int right = matrix.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int[] midArray = matrix[mid];
            if(target >= midArray[0] && target <= midArray[midArray.length-1]) {
                return inMatrix(matrix[mid], target);
            } else if (target < midArray[0]){
                right = mid -1;
            } else if (target > midArray[midArray.length-1]) {
                left = mid + 1;
            }
            
        }
        return false;
    }

    private static boolean inMatrix(int[] matrix, int target) {

        int left = 0;
        int right = matrix.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
