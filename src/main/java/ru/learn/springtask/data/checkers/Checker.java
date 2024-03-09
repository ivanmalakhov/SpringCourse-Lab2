package ru.learn.springtask.data.checkers;

import ru.learn.springtask.data.DataFormat;

public interface Checker {
    DataFormat check(DataFormat checkedData);
}
