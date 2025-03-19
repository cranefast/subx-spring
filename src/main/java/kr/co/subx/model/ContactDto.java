package kr.co.subx.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactDto {

    private Long contactNo;
    private String company;
    private String name;
    private String email;
    private String phone;
    private String message;
    private LocalDateTime regDate;

}
