package com.work03.springwork03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemoRequestDto {
    private String author;
    private String title;
    private String content;
    private String password;
}
