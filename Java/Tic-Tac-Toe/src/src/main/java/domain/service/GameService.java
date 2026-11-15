package domain.service;

import domain.model.Game;

public interface GameService {
    int[] getNextMoveMinimax(Game game);
    void validateBoard(Game previousGame, Game currentGame);
    boolean isGameOver(Game game);
}