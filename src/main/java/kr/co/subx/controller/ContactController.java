package kr.co.subx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.subx.model.ContactDto;
import kr.co.subx.model.ResponseDto;
import kr.co.subx.model.parameter.BaseParameter;
import kr.co.subx.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@Tag(name = "Contact Api", description = "문의 API ")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    @Operation(summary = "문의 등록")
    public ResponseEntity<?> save(@Valid @RequestBody ContactDto params) {
        return ResponseEntity.ok(contactService.save(params));
    }

    @PutMapping
    @Operation(summary = "문의 수정")
    public ResponseEntity<?> update(@RequestBody ContactDto params) {
        return ResponseEntity.ok(contactService.save(params));
    }

    @GetMapping
    @Operation(summary = "문의 리스트")
    public ResponseEntity<ResponseDto<ContactDto>> contacts(BaseParameter params) {
        return ResponseEntity.ok(contactService.contacts(params));
    }
}
