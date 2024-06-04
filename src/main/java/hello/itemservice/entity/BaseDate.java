package hello.itemservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDate extends BaseUser{

    
    @CreatedDate
    @Comment("생성 일시")
    @Column(name = "CREATE_AT")
    private LocalDateTime createAt;
    
    @LastModifiedDate
    @Comment("수정 일시")
    @Column(name = "UPDATE_AT")
    private LocalDateTime updatedDate;
    

}
