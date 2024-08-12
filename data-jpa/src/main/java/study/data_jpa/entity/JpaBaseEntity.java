package study.data_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {

    @Column(updatable = false) //해당 컬럼에 대해 수정 불가능하도록 하는 옵션
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @PrePersist //엔티티가 처음 생성되어 저장되기 전에 특정 필드를 초기화하거나, 로그를 남기고 싶을 때 사용
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    @PreUpdate //엔티티가 수정되기 전에 특정 필드를 업데이트하거나, 변경 전 데이터를 백업하고 싶을 때 사용
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
