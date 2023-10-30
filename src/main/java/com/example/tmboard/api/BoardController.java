package com.example.tmboard.api;

import com.example.tmboard.api.dto.request.CreateRequest;
import com.example.tmboard.core.BoardService;
import com.example.tmboard.util.MsgResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<MsgResponseDto> createBoard(@RequestBody CreateRequest request) {
        boardService.createBoard(request);
        return ResponseEntity.ok(new MsgResponseDto("작성완료", HttpStatus.OK.value()));
    }
}
