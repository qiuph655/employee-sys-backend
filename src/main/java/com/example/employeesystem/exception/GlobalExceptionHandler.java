package com.example.employeesystem.exception;

import com.example.employeesystem.common.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R<?> handleNotFound(NotFoundException ex) {
        return R.fail(ex.getErrorCode().getCode(), ex.getMessage());
    }

    // 處理自訂業務異常
//    @ExceptionHandler(BusinessException.class)
//    public R<?> handleBusinessException(BusinessException ex) {
//        return R.fail(ex.getErrorCode().getCode(), ex.getMessage());
//    }

    // 處理其他未預期錯誤
    @ExceptionHandler(Exception.class)
    public R<?> handleException(Exception ex) {
        ex.printStackTrace();
        return R.fail(
                ErrorCode.INTERNAL_SERVER_ERROR.getCode(),
                ErrorCode.INTERNAL_SERVER_ERROR.getMessage()
        );
    }
}
