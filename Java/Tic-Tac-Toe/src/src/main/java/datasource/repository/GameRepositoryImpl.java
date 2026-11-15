package datasource.repository;

import datasource.model.GameEntity;
import java.util.UUID;

public class GameRepositoryImpl implements GameRepository {
    private final GameStorage storage;

    public GameRepositoryImpl(GameStorage storage) {
        this.storage = storage;
    }

    public void save(GameEntity game) {
        storage.save(game);
    }

    public GameEntity findById(UUID id) {
        return storage.findById(id);
    }
}