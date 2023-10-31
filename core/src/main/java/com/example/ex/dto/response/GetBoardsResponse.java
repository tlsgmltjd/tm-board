package com.example.ex.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetBoardsResponse {
    private Long id;
    private String title;
    private Integer likes;
}
