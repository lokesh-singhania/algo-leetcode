package algo.backtrack.ss;

import algo.backtrack.SudokuSolver;

import java.util.Arrays;

public class SudokuSolverImpl implements SudokuSolver {

    public static void main(String[] args) {
        char[][] array = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new SudokuSolverImpl().solveSudoku(array);
    }

    @Override
    public void solveSudoku(char[][] board) {
        new Board(board).solve();
    }

    static class Values {
        boolean[] values;

        Values() {
            values = new boolean[9];
        }

        boolean isAvailable(int val) {
            return !values[val - 1];
        }

        void mark(int val) {
            values[val - 1] = true;
        }

        void unmark(int val) {
            values[val - 1] = false;
        }

    }

    static class Board {
        int[][] board;
        boolean solved;
        Values[] rows;// 9 rows
        Values[] cols;
        Values[][] boxes;
        char[][] original;

        Board(char[][] board) {
            this.board = new int[9][9];
            rows = new Values[9];
            cols = new Values[9];
            boxes = new Values[3][3];
            original = board;
            init();
            populate(board);
        }

        int[] move(int[] rc) {
            int r = rc[0], c = rc[1];
            if (c == 8) {
                return new int[]{r + 1, 0};
            }
            return new int[]{r, c + 1};
        }

        void solve() {
            backtrack(new int[]{0, 0});
            if (!solved) {
                throw new RuntimeException("Not solved");
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    original[i][j] = (char) (board[i][j] + '0');
                }
            }
        }


        void backtrack(int[] rc) {
            int r = rc[0], c = rc[1];
            if (r == 9) {
                solved = true;
                return;// how not to back track on success
            }
            if (original[r][c] != '.') {
                backtrack(move(rc));
                return;
            }
            for (int i = 1; i <= 9; i++) {
                if (isAvailable(i, r, c)) {
                    mark(r, c, i);

                    backtrack(move(rc));

                    if (!solved) {
                        unmark(r, c, i);
                    }
                }
            }
        }

        void populate(char[][] b) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = b[i][j];
                    int v = c - '0';
                    if (c != '.') {
                        mark(i, j, v);
                    }
                }
            }
        }

        void init() {
            Arrays.setAll(rows, i -> new Values());
            Arrays.setAll(cols, i -> new Values());
            for (int j = 0; j <= 2; j++) {

                Arrays.setAll(boxes[j], i -> new Values());
            }
        }

        void mark(int r, int c, int v) {
            board[r][c] = v;
            rows[r].mark(v);
            cols[c].mark(v);
            boxes[r / 3][c / 3].mark(v);
        }

        void unmark(int r, int c, int v) {
            board[r][c] = 0;
            rows[r].unmark(v);
            cols[c].unmark(v);
            boxes[r / 3][c / 3].unmark(v);
        }

        boolean isAvailable(int value, int row, int col) {
            return rows[row].isAvailable(value) &&
                    cols[col].isAvailable(value) &&
                    boxes[row / 3][col / 3].isAvailable(value);
        }
    }
}
