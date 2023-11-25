package com.ogiogio.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private String code;
    private String message;

//    public ResponseMessage(String code, String message){
//        this.code = code;
//        this.message = message;
//    }
}
