package kr.co.subx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.subx.common.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "후기 Dto")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewDto {

    @Schema(description = "후기 번호")
    private Long reviewNo;

    @Schema(description = "회사명")
    private String company;

    @Schema(description = "업종")
    private String industry;

    @Schema(description = "사업자번호")
    private String businessNumber;

    @Schema(description = "내용")
    private String message;

    @Schema(description = "상태")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)   // Response 포함
    private Status status;

    @Schema(description = "등록일")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)   // Response 포함
    private LocalDateTime regDate;

    @Schema(description = "수정일")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)   // Response 포함
    private LocalDateTime uptDate;

    @JsonIgnore
    public void init() {
        if (this.reviewNo == null || this.reviewNo == 0L) {
            this.reviewNo = null;
            this.status = Status.ACTIVE;
        }
    }
}
