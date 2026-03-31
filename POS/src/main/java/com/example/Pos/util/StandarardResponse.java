package com.example.Pos.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandarardResponse {

    private int code;
    private String message;
    private Object data;
}
