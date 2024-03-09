package ru.learn.springtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;
import ru.learn.springtask.db.repository.LoginRepository;
import ru.learn.springtask.db.repository.UserRepository;

@Slf4j
@Component
public class Worker {
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;
    public void make(){
    log.info("Запущен Make");
    }

}
