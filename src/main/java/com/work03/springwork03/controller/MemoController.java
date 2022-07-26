package com.work03.springwork03.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.work03.springwork03.service.MemoService;
import com.work03.springwork03.domain.Memo;
import com.work03.springwork03.domain.MemoRepository;
import com.work03.springwork03.domain.MemoRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Optionals;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;



    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        return memoRepository.findAllByOrderByModifiedAtDesc();

//        return memoRepository.findAll();
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getAuthorMemo(@PathVariable Long id){

        return memoRepository.findById(id);
    }

    @PostMapping("/api/memos/{id}")
    public Boolean checkPassword(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        Boolean result;
        result = memoService.checkPassword(id,requestDto);

        return result;

    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        if (memoService.checkPassword(id,requestDto)) {
            memoService.update(id, requestDto);
        }else {
            System.out.println("비밀번호 안 맞아서 수정 안됫...!");
            id = 333L;
        }

        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        if (memoService.checkPassword(id,requestDto)) {
            memoRepository.deleteById(id);
        }else {
            System.out.println("비밀번호 안 맞아서 삭제 안됫...!");
            id = 333L;
        }

        return id;
    }
}
