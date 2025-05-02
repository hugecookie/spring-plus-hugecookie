package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.dto.request.TodoSearchCond;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoQueryRepository {
    Page<TodoSearchResponse> searchTodos(TodoSearchCond cond, Pageable pageable);
}
