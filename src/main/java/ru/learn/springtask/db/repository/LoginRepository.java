package ru.learn.springtask.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.learn.springtask.db.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login,Long> {
}
