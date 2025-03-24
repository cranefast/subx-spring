package kr.co.subx.service;

import kr.co.subx.common.enums.Status;
import kr.co.subx.entity.Contact;
import kr.co.subx.entity.Review;
import kr.co.subx.model.ContactDto;
import kr.co.subx.model.ReviewDto;
import kr.co.subx.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    /**
     * 후기 등록/수정
     * @param params
     * @return
     */
    public ReviewDto save(ReviewDto params) {
        params.init(); // 초기값 세팅

        Review entity = modelMapper.map(params, Review.class);

        Review data = reviewRepository.save(entity);
        return modelMapper.map(data, ReviewDto.class);
    }
}
