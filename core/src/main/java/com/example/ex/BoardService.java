package com.example.ex;

import com.example.ex.dto.request.CreateBoardRequest;
import com.example.ex.dto.request.ModifyBoardRequest;
import com.example.ex.dto.response.GetBoardResponse;
import com.example.ex.dto.response.GetBoardsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void createBoard(CreateBoardRequest request) {
        Board newBoard = new Board();
        newBoard.createBoard(request.getTitle(), request.getContent());
        boardRepository.save(newBoard);
    }

    @Transactional(readOnly = true)
    public List<GetBoardsResponse> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> GetBoardsResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .likes(board.getLikes())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public GetBoardResponse getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return GetBoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .likes(board.getLikes())
                .build();
    }

    @Transactional
    public Long modifyBoard(Long id, ModifyBoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        board.modifyBoard(request.getTitle(), request.getContent());
        boardRepository.save(board);

        return id;
    }

    @Transactional
    public void deleteBoard(Long id) {
        if (!boardRepository.existsById(id)) throw new RuntimeException();
        boardRepository.deleteById(id);
    }

    @Transactional
    public Integer likes(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        board.likes(board.getLikes() + 1);
        boardRepository.save(board);

        return board.getLikes();
    }
}
