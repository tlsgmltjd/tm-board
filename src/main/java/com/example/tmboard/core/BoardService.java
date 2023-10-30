package com.example.tmboard.core;

import com.example.tmboard.api.dto.request.CreateRequest;
import com.example.tmboard.api.dto.response.BoardsResponse;
import com.example.tmboard.domain.entity.Board;
import com.example.tmboard.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void createBoard(CreateRequest request) {
        Board newBoard = new Board();
        newBoard.createBoard(request.getTitle(), request.getContent());
        boardRepository.save(newBoard);
    }

    public List<BoardsResponse> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> BoardsResponse.builder()
                        .title(board.getTitle())
                        .content(board.getContent())
                        .likes(board.getLikes())
                        .build())
                .toList();
    }
}
