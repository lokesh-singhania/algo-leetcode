package algo.matrix.conditions;

import algo.matrix.Conditions;

import java.util.*;

public abstract class TopologicalSort implements Conditions {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rows = topological(rowConditions, k);
        List<Integer> cols = topological(colConditions, k);
        if (rows.isEmpty() || cols.isEmpty()) {
            return new int[0][0];
        }
        Cell[] cells = positions(rows, cols);
        return matrix(cells);
    }

    protected abstract List<Integer> topological(int[][] edges, int n);

    Cell[] positions(List<Integer> rows, List<Integer> cols) {
        int n = rows.size();
        Cell[] cells = new Cell[n];
        Arrays.setAll(cells, i -> new Cell());
        for (int i = 0; i < n; i++) {
            cells[rows.get(i)].r = i;
            cells[cols.get(i)].c = i;
        }
        return cells;
    }

    int[][] matrix(Cell[] cells) {
        int n = cells.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Cell c = cells[i];
            matrix[c.r][c.c] = i + 1;
        }
        return matrix;
    }


    class Cell {
        int r, c;
    }

    class Node {
        List<Integer> adj;
        int in;

        Node() {
            adj = new ArrayList<>();
        }

        void add(int to) {
            adj.add(to);
        }

        void in() {
            in++;
        }

        void reduceIn() {
            in--;
        }

        boolean free() {
            return in == 0;
        }
    }

}
