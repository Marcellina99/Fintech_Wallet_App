package com.decagon.fintechpaymentapisqd11a.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String name;
    private String emailAddress;
    private String message;
    private String subject;

    @Override
    public String toString() {

        return "UserDto [name=" + name + ", address = " + emailAddress + ", message = " + message + ", subject = " + subject + "]";
    }
}