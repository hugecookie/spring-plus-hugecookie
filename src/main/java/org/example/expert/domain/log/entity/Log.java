package org.example.expert.domain.log.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "log")
public class Log extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long todoId;
    private Long targetUserId;
    private boolean success;
    private String errorMessage;

    public Log(Long userId, Long todoId, Long targetUserId, boolean success, String errorMessage) {
        this.userId = userId;
        this.todoId = todoId;
        this.targetUserId = targetUserId;
        this.success = success;
        this.errorMessage = errorMessage;
    }
}
