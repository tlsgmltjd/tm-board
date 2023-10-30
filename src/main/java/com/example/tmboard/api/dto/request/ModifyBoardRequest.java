package com.example.tmboard.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyBoardRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
