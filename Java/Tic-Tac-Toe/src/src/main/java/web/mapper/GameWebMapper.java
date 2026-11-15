package com.tictactoe.web.mapper;

import com.tictactoe.domain.model.Game;
import com.tictactoe.domain.model.GameBoard;
import com.tictactoe.web.model.BoardDto;
import com.tictactoe.web.model.GameDto;

public class GameWebMapper {
    public static Game toDomain(GameDto dto) {
        return new Game(dto.getId(), new GameBoard(dto.getBoard().getCells()));
    }

    public static GameDto toDto(Game domain) {
        return new GameDto(domain.getId(), new BoardDto(domain.getBoard().getCells()));
    }
}