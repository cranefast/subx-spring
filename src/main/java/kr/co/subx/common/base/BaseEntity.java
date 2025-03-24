package kr.co.subx.common.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(name = "reg_date")
    protected LocalDateTime regDate;

    @CreatedDate
    @Column(name = "upt_date")
    protected LocalDateTime uptDate;


}
