package ru.learn.springtask.db;

import ru.learn.springtask.data.DataFormat;

public interface SaveData {
    /** Сохранение данных
     *
     * @param savedData - строка сохраняемых данных
     */
    void save(DataFormat savedData);
}
