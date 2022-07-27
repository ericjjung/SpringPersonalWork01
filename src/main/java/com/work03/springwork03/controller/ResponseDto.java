package com.work03.springwork03.controller;

import com.work03.springwork03.domain.Memo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.util.List;


@AllArgsConstructor
@Getter
@Setter
//@NoArgsConstructor   생성자 ================
public class ResponseDto {

   private Boolean success;
   private List<Memo> data;
   private String error;


   public void Simple(){
     this.success = true;
     this.data = null;
     this.error = null;
   }

   public ResponseDto(List<Memo> testList){
      if(testList.isEmpty()){
         this.data.add(new Memo());
      }else {
         this.data =testList;
      }
      this.success = true;
      this.error = null;
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
