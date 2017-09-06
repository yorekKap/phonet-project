package com.phonet.project.exception.handling;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yuri on 06.09.17.
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
}
