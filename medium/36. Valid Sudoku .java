class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !column.add(board[j][i])) {
                    return false;
                }
                int cubeRow = 3 * (i / 3) + j / 3;
                int cubeColumn = 3 * (i % 3) + j % 3;
                if (board[cubeRow][cubeColumn] != '.' && !cube.add(board[cubeRow][cubeColumn])) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int m = i / 3 * 3 + j / 3;
                int n = i % 3 * 3 + j % 3;
                if (board[m][n] != '.' && !cube.add(board[m][n])) {
                    return false;
                }
            }
        }
        return true;
    }
}