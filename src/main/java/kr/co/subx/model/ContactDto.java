package kr.co.subx.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ContactDto {

    private Long contactNo;
    @NotEmpty(message = "회사명")
    private String company;
    @NotEmpty(message = "담당자")
    private String name;
    private String email;
    @NotEmpty(message = "연락처")
    private String phone;
    private String message;
    private LocalDateTime regDate;

}
