package algo.matrix.paint.black;

import algo.annotations.undesired.TLE;
import algo.matrix.PaintBlack;

@TLE
public class Backtrack implements PaintBlack {

    boolean[][] black;// 0 - white, 1 - black, 2 - adjacent black
    long max = 0;
    int[][] value;
    int n;

    public long maximumScore(int[][] grid) {
        n = grid.length;
        value = grid;
        black = new boolean[n][n];

        backtrack(0, 0, 0L);
        return max;
    }

    void backtrack(int r, int c, long val) {
        if (c == n) {
            max = Math.max(val, max);
            return;
        }
        if (c < n) {
            backtrack(0, c + 1, val);
        }
        // color
        black[r][c] = true;
        long add = calculateValueDiff(r, c);
        // move down
        if (r < n - 1) {
            backtrack(r + 1, c, val + add);
        } else {
            backtrack(0, c + 1, val + add);
        }
        black[r][c] = false;

    }

    private long calculateValueDiff(int r, int c) {
        long add = c < n - 1 ? value[r][c + 1] : 0;
        if (c > 0) {
            if (black[r][c - 1]) {
                add -= value[r][c];
            } else {
                if (c < 2 || !black[r][c - 2]) {
                    add += value[r][c - 1];
                }
            }
        }
        return add;
    }
}
