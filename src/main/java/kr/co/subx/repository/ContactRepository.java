package kr.co.subx.repository;

import kr.co.subx.entity.Contact;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Log> {

    Optional<Contact> findByContactNo(Long contactNo);

}
