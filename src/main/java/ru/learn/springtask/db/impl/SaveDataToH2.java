package ru.learn.springtask.db.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Service;
import ru.learn.springtask.data.DataFormat;
import ru.learn.springtask.data.impl.CsvFormat;
import ru.learn.springtask.db.SaveData;
import ru.learn.springtask.db.model.Login;
import ru.learn.springtask.db.model.User;
import ru.learn.springtask.db.repository.LoginRepository;
import ru.learn.springtask.db.repository.UserRepository;
import ru.learn.springtask.log.LogTransformation;

import java.io.IOException;

/**
 * Сервис для сохранения данных в базу H2
 */
@Service
@Slf4j
public class SaveDataToH2 implements SaveData {
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    @LogTransformation
    public void save(DataFormat savedData) {
        if (savedData.isError()) {
            log.error("Данные не прошли валидацию и не будут сохранены {}", savedData.toString());
        } else {
            var user = userRepository.findByUserName(savedData.getUserName());

            if (user == null) {
                user = new User();
                user.setUserName(savedData.getUserName());
                user.setFio(savedData.getFio());
            }

            var login = new Login();
            login.setAccessDate(savedData.getAccessDate());
            login.setUser(user);
            login.setApplication(savedData.getApplication());
            userRepository.save(user);
            loginRepository.save(login);
        }
    }
}
