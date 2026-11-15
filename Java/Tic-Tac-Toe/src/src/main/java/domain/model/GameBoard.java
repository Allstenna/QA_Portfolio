package domain.model;

import java.util.Arrays;

public class GameBoard {
    private int[][] cells;

    public GameBoard(int[][] cells) {
        this.cells = cells;
    }

    public int[][] getCells() {
        return cells;
    }

    public GameBoard deepCopy() {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = Arrays.copyOf(cells[i], cells[i].length);
        }
        return new GameBoard(copy);
    }
}
