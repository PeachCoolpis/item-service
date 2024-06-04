package hello.itemservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseUser {
    
    @Comment("등록자")
    @CreatedBy
    @Column(name = "createName")
    private String createName;
    
    
    @Comment("수정자")
    @LastModifiedBy
    @Column(name = "updateName")
    private String updateName;
    
}
