package kr.co.subx.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_no")
    private Long companyNo;

    private String name;

    @Column(name = "business_number", length = 64)
    @Comment("사업자번호")
    private String businessNumber;

    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    @PrePersist
    public void prePersist() {
        if (ObjectUtils.isEmpty(this.regDate)) {
            this.regDate = LocalDateTime.now();
        }
    }
}
