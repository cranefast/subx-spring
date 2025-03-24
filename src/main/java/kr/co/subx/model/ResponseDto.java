package kr.co.subx.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Schema(description = "페이지 응답 DTO")
public class ResponseDto<T> {

    @Schema(description = "응답 데이터 목록")
    private List<T> content;

    @Schema(description = "현재 페이지 번호")
    private int page;

    @Schema(description = "페이지 크기")
    private int size;

    @Schema(description = "전체 데이터 개수")
    private long totalElements;

    @Schema(description = "전체 페이지 수")
    private int totalPages;

    @Schema(description = "첫 페이지 여부")
    private boolean first;

    @Schema(description = "마지막 페이지 여부")
    private boolean last;

    public ResponseDto(Page<T> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.first = page.isFirst();
        this.last = page.isLast();
    }

}
