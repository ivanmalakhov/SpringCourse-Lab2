package ru.learn.springtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.learn.springtask.db.model.User;
import ru.learn.springtask.db.repository.UserRepository;

//@SpringBootTest
@DataJpaTest
public class RepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;        
    
    /**
     *  Тестировавние работы с БД
     */
    //@Test
    public void whenFindByName_thenReturnUser(){
        User newUser = new User(100500, "user555", "PPI");
        entityManager.persist(newUser);
        entityManager.flush();

        User found = userRepository.findByUserName(newUser.getUserName());
        assertEquals(found.getUserName(), newUser.getUserName());
    }
}
