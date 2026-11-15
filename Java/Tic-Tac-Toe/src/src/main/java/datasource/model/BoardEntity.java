package datasource.model;

public class BoardEntity {
    private int[][] cells;
    public BoardEntity(int[][] cells) { this.cells = cells; }
    public int[][] getCells() { return cells; }
}