package com.example.cpserver.general.exception_handler;

import com.example.cpserver.controller.dto.Message;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ArgumentNotValidExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Message methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return new Message(fieldErrorsString(fieldErrors));
    }

    private String fieldErrorsString(Collection<FieldError> fieldErrors) {
        StringBuilder message = new StringBuilder("Тело запроса не прошло валидацию: [");
        for (FieldError e : fieldErrors) {
            message.append(e.getField())
                    .append(" = ")
                    .append(e.getRejectedValue())
                    .append(" (")
                    .append(e.getDefaultMessage())
                    .append("), ");
        }
        message.delete(message.length() - 2, message.length());
        message.append("]");
        return message.toString();
    }
}
