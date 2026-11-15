package datasource.mapper;

import datasource.model.BoardEntity;
import datasource.model.GameEntity;
import domain.model.Game;
import domain.model.GameBoard;

public class GameMapper {
    public static GameEntity toEntity(Game domain) {
        return new GameEntity(domain.getId(), new BoardEntity(domain.getBoard().getCells()));
    }

    public static Game toDomain(GameEntity entity) {
        return new Game(entity.getId(), new GameBoard(entity.getBoard().getCells()));
    }
}