package com.silly.ecommerce.common.response;

import com.silly.ecommerce.common.constants.ResponseStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ResultResponse {

    /****************** HTTP RESPONSE STATUS CODES *********************************/
    public static final int STATUS_VALIDATE_FAILED = 404;

    public static final int STATUS_UNKNOWN_FAILED = 500;

    public static final int STATUS_SUCCESS = 200;

    public static final int STATUS_UNAUTHORIZED = 401;

    public static final int STATUS_FORBIDDEN = 403;

    public static final int STATUS_NOT_SUPPORT = 300;

    public static final int STATUS_TOO_MANY_REQUEST = 309;

    public static final int STATUS_BAD_REQUEST = 400;

    public static final ResultResponse SUCCESS = new ResultResponse(STATUS_SUCCESS, "Api.success");
    public static final ResultResponse FAILED = new ResultResponse(STATUS_UNKNOWN_FAILED, "Api.unknown.error");
    public static final ResultResponse UNAUTHORIZED = new ResultResponse(STATUS_UNAUTHORIZED, "unauthorized");
    public static final ResultResponse FORBIDDEN = new ResultResponse(STATUS_FORBIDDEN, "forbidden");
    public static final ResultResponse VALIDATE_FAILED = new ResultResponse(STATUS_VALIDATE_FAILED, "validate.failure");
    public static final ResultResponse RESOURCE_NOT_FOUND = new ResultResponse(STATUS_VALIDATE_FAILED, "resource.notfound");
    public static final ResultResponse TOO_MANY_REQUEST = new ResultResponse(STATUS_TOO_MANY_REQUEST, "too.many.request");
    public static final ResultResponse BAD_REQUEST = new ResultResponse(STATUS_BAD_REQUEST, "Api.bad.request");


    @NotNull
    private final Integer status;

    @NotNull
    private final String message;
    private final Object result;

    public ResultResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.result = null;
    }

    public ResultResponse(Integer status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    // Create a ResultResponse with a given status
    public static final ResultResponse of(ResponseStatusEnum status) {
        switch (status) {
            case CREATED:
                return new ResultResponse(STATUS_SUCCESS, "created successfully");
            case DELETED:
                return new ResultResponse(STATUS_SUCCESS, "deleted successfully");
            case UPDATED:
                return new ResultResponse(STATUS_SUCCESS, "updated successfully");
            case NOT_FOUND:
                return new ResultResponse(STATUS_BAD_REQUEST, "not found");
            default:
                return new ResultResponse(STATUS_SUCCESS, "", null);
        }
    }

    public ResultResponse withResult(Object result) {
        return new ResultResponse(status, message, result);
    }

    public ResultResponse withMessage(String messageCode) {
        return new ResultResponse(status, messageCode, null);
    }
}
