package kr.co.subx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.subx.model.ReviewDto;
import kr.co.subx.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
@Tag(name = "Review Api", description = "후기 API ")
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping
    @Operation(summary = "후기 등록/수정")
    public ResponseEntity<ReviewDto> saveReview(@RequestBody ReviewDto params) {
        return ResponseEntity.ok(reviewService.save(params));
    }

    @GetMapping
    @Operation(summary = "후기 리스트")
    public ResponseEntity<List<ReviewDto>> reviews() {
        return ResponseEntity.ok(reviewService.reviews());
    }
}
