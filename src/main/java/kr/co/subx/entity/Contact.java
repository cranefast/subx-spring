package kr.co.subx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import kr.co.subx.common.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_no")
    private Long contactNo;

    @Column(nullable = false, length = 64)
    private String company;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 128)
    private String email;

    @Column(nullable = false, length = 32)
    private String phone;

    private String message;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    // 기본값 설정 추가
    @PrePersist
    public void prePersist() {
        if (ObjectUtils.isEmpty(this.status)) {
            this.status = Status.ACTIVE;
        }
        if (ObjectUtils.isEmpty(this.regDate)) {
            this.regDate = LocalDateTime.now();
        }
    }
}
