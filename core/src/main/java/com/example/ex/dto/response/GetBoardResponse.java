package com.example.ex.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetBoardResponse {
    private Long id;
    private String title;
    private String content;
    private Integer likes;
}
