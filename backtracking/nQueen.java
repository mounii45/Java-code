package backtracking;

public class nQueen {

    public static boolean isSafe(char[][] board, int row, int col) {
        // 3 cases to check

        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagnol up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagnol up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    public static void sol(char[][] board, int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // column wise
        for (int j = 0; j < board.length; j++) {

            if (isSafe(board, row, j)) {// initially , verify that place is safe to place basing on top rows
                board[row][j] = 'Q';
                sol(board, row + 1);
                board[row][j] = '.';
            }

        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------Chess Board--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        sol(board, 0);
    }

}
