package com.decagon.fintechpaymentapisqd11a.exceptions;

import com.decagon.fintechpaymentapisqd11a.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleUserAlreadyExistsException(final UserAlreadyExistException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("User already exists");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }
}
