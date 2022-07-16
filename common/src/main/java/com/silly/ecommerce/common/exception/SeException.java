package com.silly.ecommerce.common.exception;

import com.silly.ecommerce.common.response.ResultResponse;
import lombok.Getter;

@Getter
public class SeException extends RuntimeException {

    private final Integer status;
    private final String message;

    public SeException(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultResponse convertToResponse() {
        return new ResultResponse(status, message);
    }

    public ResultResponse toResponseWithResult(Object result) {
        return new ResultResponse(status, message, result);
    }
}
