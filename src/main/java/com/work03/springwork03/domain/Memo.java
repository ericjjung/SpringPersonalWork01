package com.work03.springwork03.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @Column(nullable = false)
    private String password;


    @AllArgsConstructor
    @Getter
    public static class pwDto {
        private String password;
    }

    public Memo(String author,String title, String contents,String password) {
        this.author = author;
        this.title = title;
        this.content = contents;
        this.password = password;
    }

    public Memo(MemoRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto requestDto){
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
    }

}