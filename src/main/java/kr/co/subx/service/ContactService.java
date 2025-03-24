package kr.co.subx.service;

import kr.co.subx.common.enums.Status;
import kr.co.subx.entity.Contact;
import kr.co.subx.model.ContactDto;
import kr.co.subx.model.ResponseDto;
import kr.co.subx.model.parameter.BaseParameter;
import kr.co.subx.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    /**
     * 문의 등록/수정
     * @param params
     * @return
     */
    public ContactDto save(ContactDto params) {
        if (params.getContactNo() == null || params.getContactNo() == 0L) {
            params.init();
        }

        Contact contact = modelMapper.map(params, Contact.class);

        Contact data = contactRepository.save(contact);
        log.info("data {}", data);
        return modelMapper.map(data, ContactDto.class);
    }

    /**
     * 문의 리스트
     * @param params
     * @return
     */
    public ResponseDto<ContactDto> contacts(BaseParameter params) {
        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), Sort.by("contactNo").descending());
        return new ResponseDto<>(contactRepository.findAll(pageable).map(ContactDto::new));
    }

}
