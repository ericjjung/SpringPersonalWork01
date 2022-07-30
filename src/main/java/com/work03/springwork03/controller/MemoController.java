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
    public ResponseDto readMemo(){

         List<Memo> testList =  memoRepository.findAllByOrderByIdDesc();
         ResponseDto responseDto = new ResponseDto(testList);

        return responseDto;

    }

    @PostMapping("/api/memos")
    public ResponseDto createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        memo = memoRepository.save(memo);
        List<Memo> setList = new ArrayList<>();
        setList.add(memo);
        return new ResponseDto(setList);
    }

    @GetMapping("/api/memos/{id}")
    public ResponseDto getAuthorMemo(@PathVariable Long id){
        Optional<Memo> testList = memoRepository.findById(id);
        List<Memo> testvar= new ArrayList<>();
        testvar.add(testList.get());

        return new ResponseDto(testvar);
    }

    @PostMapping("/api/memos/{id}")
    public ResponseDto checkPassword(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        Boolean result;
        result = memoService.checkPassword(id,requestDto);
        Optional<Memo> testList = memoRepository.findById(id);
        List<Memo> memoList = new ArrayList<>();
        memoList.add(testList.get());
        ResponseDto response;
        if(result){
            response = new ResponseDto(memoList);
        }else{
            throw new RuntimeException("비밀 번호가 잘못되거나 삭제된 글입니다.");
        }

        return response;

    }

    @PutMapping("/api/memos/{id}")
    public ResponseDto updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
            memoService.update(id, requestDto);
            List<Memo> memoList = new ArrayList<>();
            memoList.add(memoRepository.findById(id).get());


        return new ResponseDto(memoList);
    }

    @DeleteMapping("/api/memos/{id}")
    public Map<String,String> deleteMemo(@PathVariable Long id){
            memoRepository.deleteById(id);
            Map<String,String> response = new HashMap<>();
            response.put("success","true");
            response.put("data",null);
            response.put("error",null);



        return response;
    }
}
