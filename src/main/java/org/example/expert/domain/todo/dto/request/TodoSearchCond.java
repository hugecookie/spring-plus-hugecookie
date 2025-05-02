package org.example.expert.domain.todo.dto.request;

import java.time.LocalDateTime;

public record TodoSearchCond(
        String keyword,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String nickname
) {}
