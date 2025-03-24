package kr.co.subx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.subx.model.ReviewDto;
import kr.co.subx.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
@Tag(name = "Review Api", description = "후기 API ")
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping
    @Operation(summary = "후기 등록")
    public ResponseEntity<?> saveReview(@RequestBody ReviewDto params) {
        return ResponseEntity.ok(reviewService.save(params));
    }
}
