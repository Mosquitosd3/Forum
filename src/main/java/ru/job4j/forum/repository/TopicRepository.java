package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
