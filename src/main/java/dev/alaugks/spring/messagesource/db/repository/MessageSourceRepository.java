package dev.alaugks.spring.messagesource.db.repository;

import dev.alaugks.spring.messagesource.db.entity.MessageSource;

import org.springframework.data.repository.CrudRepository;

public interface MessageSourceRepository extends CrudRepository<MessageSource, Integer> {
}
