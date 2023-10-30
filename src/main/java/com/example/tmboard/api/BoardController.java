package com.example.tmboard.api;

import com.example.tmboard.api.dto.request.CreateRequest;
import com.example.tmboard.api.dto.response.BoardsResponse;
import com.example.tmboard.core.BoardService;
import com.example.tmboard.util.MsgResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {
    private final BoardService boardService;

    // 글 작성
    @PostMapping
    public ResponseEntity<MsgResponseDto> createBoard(@RequestBody CreateRequest request) {
        boardService.createBoard(request);
        return ResponseEntity.ok(new MsgResponseDto("작성완료", HttpStatus.OK.value()));
    }

    // 글 찾기
    @GetMapping
    public ResponseEntity<List<BoardsResponse>> getBoards() {
        return ResponseEntity.ok( boardService.getBoards());
    }

    // 특정 글 찾기

    // 글 수정

    // 글 식제

    // 좋아요 누르기
}
