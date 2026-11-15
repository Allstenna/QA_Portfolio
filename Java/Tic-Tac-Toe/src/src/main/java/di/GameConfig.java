package com.tictactoe.di;

import com.tictactoe.datasource.repository.GameRepository;
import com.tictactoe.datasource.repository.GameRepositoryImpl;
import com.tictactoe.datasource.repository.GameStorage;
import com.tictactoe.domain.service.GameService;
import com.tictactoe.domain.service.impl.GameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Bean
    public GameStorage gameStorage() {
        return new GameStorage();
    }

    @Bean
    public GameRepository gameRepository(GameStorage gameStorage) {
        return new GameRepositoryImpl(gameStorage);
    }

    @Bean
    public GameService gameService(GameRepository gameRepository) {
        return new GameServiceImpl(gameRepository);
    }
}