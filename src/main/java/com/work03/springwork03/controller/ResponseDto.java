package com.work03.springwork03.controller;

import com.work03.springwork03.domain.MemoRequestDto;
import lombok.NoArgsConstructor;


import java.util.List;


public class ResponseDto {

   private String success = "true";
   private List<MemoRequestDto> data;
   private String error = "null";

   public void setResponseDto(MemoRequestDto aa){
      data.add(aa);
   }

   public List<MemoRequestDto> getResponseDto(MemoRequestDto bb){
      return this.data;
   }


//    public void responseDto(String success, String data){
//        Map.Entry<String, String> responseDto = new AbstractMap.SimpleEntry<String,String>(success,data);
//        aaaa();
//    }
//
//
//    public void  aaaa(){
//        Map<String,String> response1 = new HashMap<>();
//        response1.put("실험값","실험값2");
//        response1.put("실험값3","실험값4");
//        System.out.println(response1);
//    }


}
