package kr.co.subx.service;

import kr.co.subx.common.enums.Status;
import kr.co.subx.entity.Contact;
import kr.co.subx.model.ContactDto;
import kr.co.subx.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactDto save(ContactDto params) {
        if (params.getContactNo() == 0) {
            params.setContactNo(null);
        }
        Contact contact = modelMapper.map(params, Contact.class);

        if (params.getContactNo() != null) {
            contact.setDefaultStatus();
        }

        Contact data = contactRepository.save(contact);
        return modelMapper.map(data, ContactDto.class);
    }



}
