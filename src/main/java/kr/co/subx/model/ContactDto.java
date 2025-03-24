package kr.co.subx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import kr.co.subx.common.enums.Status;
import kr.co.subx.entity.Contact;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "문의 Dto")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContactDto {

    @Schema(description = "문의 번호")
    private Long contactNo;

    @Schema(description = "회사명")
    @NotEmpty(message = "회사명")
    private String company;

    @Schema(description = "담당자")
    @NotEmpty(message = "담당자")
    private String name;

    @Schema(description = "이메일")
    private String email;

    @Schema(description = "연락처")
    @NotEmpty(message = "연락처")
    private String phone;

    @Schema(description = "문의 내용")
    private String message;

    @Schema(description = "상태 값")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)   // Response 포함
    @Schema(description = "등록일")
    private LocalDateTime regDate;


    // Contact 엔티티 받는 생성자 추가
    public ContactDto(Contact contact) {
        this.contactNo = contact.getContactNo();
        this.company = contact.getCompany();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
        this.message = contact.getMessage();
        this.regDate = contact.getRegDate();
    }

    /**
     * 기본값 세팅
     */
    @JsonIgnore
    public void init() {
        this.contactNo = null;
        this.status = Status.ACTIVE;
    }
}
