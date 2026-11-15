package com.tictactoe.web.model;

import java.util.UUID;

public class BoardDto {
    private int[][] cells;
    public BoardDto() {}
    public BoardDto(int[][] cells) { this.cells = cells; }
    public int[][] getCells() { return cells; }
    public void setCells(int[][] cells) { this.cells = cells; }
}