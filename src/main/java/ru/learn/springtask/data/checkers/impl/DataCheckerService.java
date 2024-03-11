package ru.learn.springtask.data.checkers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learn.springtask.data.DataFormat;
import ru.learn.springtask.data.checkers.Checker;

import java.util.List;
import java.util.function.Consumer;

@Service
public class DataCheckerService implements Checker {
    @Autowired
    List<Consumer<DataFormat>> dataFixer;

    @Override
    public DataFormat check(DataFormat checkedData) {
        dataFixer.forEach(consumer -> consumer.accept(checkedData));
        return checkedData;
    }
}
