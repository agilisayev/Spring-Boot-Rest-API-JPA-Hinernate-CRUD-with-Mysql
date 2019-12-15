package com.demo.springbootjpadocker.api.dto;

import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDto {
    private int code;
    private String technicalMessage;
    private String  userMessage;
    private Calendar timestamp;
}
