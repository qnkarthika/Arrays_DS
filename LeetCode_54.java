Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Solution:

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return spiralList;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[top][i]);
            }
            top++;
            
            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                spiralList.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    spiralList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    spiralList.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return spiralList;
    }
}
