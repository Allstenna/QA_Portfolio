package datasource.repository;

import datasource.model.GameEntity;
import java.util.UUID;

public interface GameRepository {
    void save(GameEntity game);
    GameEntity findById(UUID id);
}