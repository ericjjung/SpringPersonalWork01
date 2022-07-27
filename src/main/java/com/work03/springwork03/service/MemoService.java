package com.work03.springwork03.service;

import com.work03.springwork03.domain.Memo;
import com.work03.springwork03.domain.MemoRepository;
import com.work03.springwork03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Boolean checkPassword(Long id,MemoRequestDto requestDto){
        Boolean result;
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("잘못된 비밀번호거나 삭제된 게시물입니다.")
        );
        if(requestDto.getPassword().equals(memo.getPassword())){
            result = true;
        }else{
            result = false;
        }

        return result;
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        memo.update(requestDto);
        return memo.getId();
    }
}