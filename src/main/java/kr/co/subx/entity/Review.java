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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import kr.co.subx.common.base.BaseEntity;
import kr.co.subx.common.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_no")
    private Long reviewNo;

    @Column(nullable = false, length = 64)
    @Comment("회사명")
    private String company;

    @Column(length = 128)
    @Comment("업종")
    private String industry;

    @Column(name = "business_number", length = 128)
    @Comment("사업자번호")
    private String businessNumber;

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private String message;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    @CreatedDate
    @Column(name = "upt_date")
    private LocalDateTime uptDate;

    // 기본값 설정 추가
    @PrePersist
    public void prePersist() {
        if (ObjectUtils.isEmpty(this.status)) {
            setDefaultStatus();
        }
        if (ObjectUtils.isEmpty(this.regDate)) {
            this.regDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.uptDate = LocalDateTime.now();
    }

    public void setDefaultStatus() {
        this.status = Status.ACTIVE;
    }
}
