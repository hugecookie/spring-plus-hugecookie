package org.example.expert.domain.todo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.dto.request.TodoSearchCond;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.time.LocalDateTime;


import java.util.List;

import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.manager.entity.QManager.manager;
import static org.example.expert.domain.user.entity.QUser.user;
import static org.example.expert.domain.comment.entity.QComment.comment;

@Repository
@RequiredArgsConstructor
public class TodoQueryRepositoryImpl implements TodoQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<TodoSearchResponse> searchTodos(TodoSearchCond cond, Pageable pageable) {

        List<TodoSearchResponse> contents = queryFactory
                .select(Projections.constructor(TodoSearchResponse.class,
                        todo.title,
                        manager.countDistinct(),
                        comment.countDistinct()
                ))
                .from(todo)
                .leftJoin(todo.managers, manager)
                .leftJoin(manager.user, user)
                .leftJoin(todo.comments, comment)
                .where(
                        containsTitle(cond.keyword()),
                        betweenCreatedAt(cond.startDate(), cond.endDate()),
                        containsNickname(cond.nickname())
                )
                .groupBy(todo.id)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(todo.countDistinct())
                .from(todo)
                .leftJoin(todo.managers, manager)
                .leftJoin(manager.user, user)
                .where(
                        containsTitle(cond.keyword()),
                        betweenCreatedAt(cond.startDate(), cond.endDate()),
                        containsNickname(cond.nickname())
                )
                .fetchOne();

        return new PageImpl<>(contents, pageable, total != null ? total : 0L);
    }

    private BooleanExpression containsTitle(String keyword) {
        return keyword != null ? todo.title.containsIgnoreCase(keyword) : null;
    }

    private BooleanExpression betweenCreatedAt(LocalDateTime start, LocalDateTime end) {
        if (start != null && end != null) return todo.createdAt.between(start, end);
        if (start != null) return todo.createdAt.goe(start);
        if (end != null) return todo.createdAt.loe(end);
        return null;
    }

    private BooleanExpression containsNickname(String nickname) {
        return nickname != null ? user.nickname.containsIgnoreCase(nickname) : null;
    }
}
