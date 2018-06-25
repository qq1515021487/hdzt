package com.bnuz.commons.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bnuz.commons.result.ArgumentInvalidResult;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //设置参数出错的时候返回异常
    @ExceptionHandler(value={MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public Result methodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception {
        //按需重新封装需要返回的错误信息
        List<ArgumentInvalidResult> invalidArguments = new ArrayList<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
            invalidArgument.setDefaultMessage(error.getDefaultMessage());
            invalidArgument.setField(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArguments.add(invalidArgument);
            return Result.fail("参数不合规范", ErrorCode.ENTITY_PARAM_ERROR, invalidArgument);
        }

        return Result.fail("参数不合规范", ErrorCode.ENTITY_PARAM_ERROR, invalidArguments);
    }

    @ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail("系统出现了一点小错误", ErrorCode.BAD_REQUEST);
    }
}
