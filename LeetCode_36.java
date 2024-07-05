36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false


Solution:

class Solution {
    public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
        if (!isValidRow(board, i)) return false;
        if (!isValidCol(board, i)) return false;
        
        int row = i / 3 * 3;
        int col = i % 3 * 3;
        if (!isValidGrid(board, row, col)) return false;
    }
    return true;
}

public static boolean isValidRow(char[][] board, int i) {
    ArrayList<Character> li = new ArrayList<>();
    for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
            if (li.contains(board[i][j])) {
                return false;
            } else {
                li.add(board[i][j]);
            }
        }
    }
    return true;
}

public static boolean isValidCol(char[][] board, int i) {
    ArrayList<Character> li = new ArrayList<>();
    for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.') {
            if (li.contains(board[j][i])) {
                return false;
            } else {
                li.add(board[j][i]);
            }
        }
    }
    return true;
}
public static boolean isValidGrid(char[][] board, int row, int col) {
    ArrayList<Character> li = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            char current = board[row + i][col + j];
            if (current != '.') {
                if (li.contains(current)) {
                    return false;
                } else {
                    li.add(current);
                }
            }
        }
    }
    return true;
}



}
