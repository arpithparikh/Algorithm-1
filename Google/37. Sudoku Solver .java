class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length < 9 || board[0].length < 9) {
            return;
        }
        helper(board, 0, 0);
    }
    private boolean helper(char[][] board, int i, int j) {
        if (j == 9) {
            return helper(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            return helper(board, i, j + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char)(k + '0');
                if (isValid(board, i, j) && helper(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j]) {
                return false;
            }
            if (k != j && board[i][k] == board[i][j]) {
                return false;
            }
        }
        int rowStart = i / 3 * 3;
        int colStart = j / 3 * 3;
        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}