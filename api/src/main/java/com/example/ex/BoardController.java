package com.example.ex;

import com.example.ex.dto.request.CreateBoardRequest;
import com.example.ex.dto.request.LikesRequest;
import com.example.ex.dto.request.ModifyBoardRequest;
import com.example.ex.dto.response.GetBoardResponse;
import com.example.ex.dto.response.GetBoardsResponse;
import com.example.ex.dto.response.LikesResponse;
import com.example.ex.dto.response.ModifyBoardResponse;
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
    public ResponseEntity<MsgResponseDto> createBoard(@RequestBody CreateBoardRequest request) {
        boardService.createBoard(request);
        return ResponseEntity.ok(new MsgResponseDto("작성완료", HttpStatus.OK.value()));
    }

    // 글 찾기
    @GetMapping
    public ResponseEntity<List<GetBoardsResponse>> getBoards() {
        return ResponseEntity.ok( boardService.getBoards());
    }

    // 특정 글 찾기
    @GetMapping("/{id}")
    public ResponseEntity<GetBoardResponse> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    // 글 수정
    @PutMapping("/{id}")
    public ResponseEntity<ModifyBoardResponse> modifyBoard(@PathVariable Long id, @RequestBody ModifyBoardRequest request) {
        return ResponseEntity.ok(new ModifyBoardResponse(boardService.modifyBoard(id, request)));
    }

    // 글 식제
    @DeleteMapping("/{id}")
    public ResponseEntity<MsgResponseDto> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok(new MsgResponseDto("삭제완료", HttpStatus.OK.value()));
    }

    // 좋아요 누르기
    @PostMapping("/like")
    public ResponseEntity<LikesResponse> likesBoard(@RequestBody LikesRequest request) {
        return ResponseEntity.ok(new LikesResponse(boardService.likes(request.getBoardId())));
    }
}
