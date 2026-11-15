package com.tictactoe.domain.service.impl;

import com.tictactoe.datasource.mapper.GameMapper;
import com.tictactoe.datasource.model.GameEntity;
import com.tictactoe.datasource.repository.GameRepository;
import com.tictactoe.domain.model.Game;
import com.tictactoe.domain.model.GameBoard;
import com.tictactoe.domain.service.GameService;

public class GameServiceImpl implements GameService {
    private final GameRepository repository;

    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public int[] getNextMoveMinimax(Game game) {
        int[][] board = game.getBoard().getCells();
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = 0;

                    if (moveVal > bestVal) {
                        bestMove = new int[]{i, j};
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(int[][] board, int depth, boolean isMaximizing) {
        int score = evaluate(board);
        if (score == 10 || score == -10 || !hasEmptyCells(board)) return score;

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 2;
                        best = Math.max(best, minimax(board, depth + 1, false));
                        board[i][j] = 0;
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        best = Math.min(best, minimax(board, depth + 1, true));
                        board[i][j] = 0;
                    }
                }
            }
            return best;
        }
    }

    private int evaluate(int[][] b) {
        // Проверка строк, столбцов и диагоналей для 1 (победа юзера = -10) и 2 (победа ПК = 10)
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == b[i][1] && b[i][1] == b[i][2] && b[i][0] != 0) return b[i][0] == 2 ? 10 : -10;
            if (b[0][i] == b[1][i] && b[1][i] == b[2][i] && b[0][i] != 0) return b[0][i] == 2 ? 10 : -10;
        }
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2] && b[0][0] != 0) return b[0][0] == 2 ? 10 : -10;
        if (b[0][2] == b[1][1] && b[1][1] == b[2][0] && b[0][2] != 0) return b[0][2] == 2 ? 10 : -10;
        
        return 0;
    }

    private boolean hasEmptyCells(int[][] board) {
        for (int[] row : board) for (int cell : row) if (cell == 0) return true;
        return false;
    }

    @Override
    public void validateBoard(Game previousGame, Game currentGame) {
        int[][] prev = previousGame.getBoard().getCells();
        int[][] curr = currentGame.getBoard().getCells();
        int changesCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (prev[i][j] != curr[i][j]) {
                    if (prev[i][j] != 0 || curr[i][j] != 1) {
                        throw new IllegalArgumentException("Некорректное изменение поля: разрешено менять только 0 на 1");
                    }
                    changesCount++;
                }
            }
        }
        if (changesCount != 1) {
            throw new IllegalArgumentException("Пользователь должен сделать ровно один ход");
        }
    }

    @Override
    public boolean isGameOver(Game game) {
        int[][] board = game.getBoard().getCells();
        return evaluate(board) != 0 || !hasEmptyCells(board);
    }
}