package com.callmepeace.lockorrock.global;

import com.callmepeace.lockorrock.common.ResponseCode;
import com.callmepeace.lockorrock.common.ResponseDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        IllegalArgumentException.class
    })
    public ResponseEntity<?> handleBindException(Exception e) {
        log.error("Bad request exception occurred: {}", e.getMessage(), e);
        log.error("Stack Trace: {}", e.getStackTrace(), e);

        if (e instanceof MethodArgumentNotValidException) {
            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getFieldErrors();
            List<String> fields = fieldErrors.stream()
                .map(FieldError::getField)
                .toList();
            return ResponseEntity
                .badRequest()
                .body(ResponseDto.failure(ResponseCode.BAD_REQUEST, fields));
        }

        return ResponseEntity
            .badRequest()
            .body(ResponseDto.failure(ResponseCode.BAD_REQUEST, null));
    }

    @ExceptionHandler({
        NoHandlerFoundException.class
    })
    public ResponseEntity<?> handleNotFoundException(Exception e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<?> handleHttpMediaTypeException(Exception e) {
        return ResponseEntity
            .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
            .body(ResponseDto.failure(ResponseCode.UNSUPPORTED_MEDIA_TYPE, null));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotAllowedException(Exception e) {
        return ResponseEntity
            .status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(ResponseDto.failure(ResponseCode.METHOD_NOT_ALLOWED, null));
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<?> handleConflict(BusinessException e) {
        log.error("RuntimeException", e);
        return ResponseEntity
            .ok()
            .body(ResponseDto.failure(e.getErrorCode(), null));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
        log.error("Stack Trace: {}", e.getStackTrace(), e);

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResponseDto.failure(ResponseCode.INTERNAL_SERVER_ERROR, null));
    }
}
