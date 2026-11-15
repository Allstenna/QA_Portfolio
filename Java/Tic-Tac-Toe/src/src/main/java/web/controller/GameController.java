package com.tictactoe.web.controller;

import com.tictactoe.domain.model.Game;
import com.tictactoe.domain.model.GameBoard;
import com.tictactoe.domain.service.GameService;
import com.tictactoe.web.mapper.GameWebMapper;
import com.tictactoe.web.model.GameDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{id}")
    public GameDto makeMove(@PathVariable UUID id, @RequestBody GameDto requestDto) {
        Game userGame = GameWebMapper.toDomain(requestDto);     
        Game previousGame = getPreviousGameState(id); // Условный метод получения из репозитория
        
        gameService.validateBoard(previousGame, userGame);
        
        if (gameService.isGameOver(userGame)) {
            throw new IllegalStateException("Game is Over");
        }

        int[] computerMove = gameService.getNextMoveMinimax(userGame);
        if (computerMove[0] != -1) {
            userGame.getBoard().getCells()[computerMove[0]][computerMove[1]] = 2;
        }
        
        return GameWebMapper.toDto(userGame);
    }
    
    private Game getPreviousGameState(UUID id) {
        throw new UnsupportedOperationException("Implement the GameRepository via injection into the controller or service");
    }
}