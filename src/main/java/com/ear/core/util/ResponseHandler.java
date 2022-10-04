package com.ear.core.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponseModel(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("data", responseObj);
            return new ResponseEntity<Object>(map,status);
    }
    
    public static ResponseEntity<Object> generateResponseError(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            return new ResponseEntity<Object>(map,status);
    }
    
}
