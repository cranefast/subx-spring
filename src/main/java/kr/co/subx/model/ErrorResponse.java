package kr.co.subx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "오류 Response")
@JsonIgnoreProperties(value = {"convertJson"})
public class ErrorResponse {

    @Schema(description = "오류 코드")
    private String code;
    @Schema(description = "오류 메시지")
    private String message;

    @Hidden
    public String getConvertJson() {
        return "{\"code\": \"" + code + "\", \"message\": \"" + message + "\"}";
    }

}

