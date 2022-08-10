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


    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleEmailAlreadyTakenException(final EmailAlreadyTakenException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("Email Already Taken");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }

    @ExceptionHandler(EmailNotValidException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleEmailNotValidException(final EmailNotValidException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("Email Not Valid");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }


    @ExceptionHandler(TokenNotFoundException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleTokenNotFoundException(final TokenNotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("Token Not Found");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }

    @ExceptionHandler(ConfirmationTokenException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleConfirmationTokenException(final ConfirmationTokenException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("Email Already Confirmed");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }


    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleTokenExpiredException(final TokenExpiredException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("Token Expired");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(final UserNotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setDebugMessage("User Not Found");

        return ResponseEntity.of(Optional.of(errorResponseDto));
    }
}
