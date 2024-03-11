package ru.learn.springtask.data.checkers;

import org.springframework.stereotype.Component;
import ru.learn.springtask.data.DataFormat;

import java.util.function.Consumer;

/**
 * Проверка даты
 */
@Component
public class CheckDate implements Consumer<DataFormat> {
    @Override
    public void accept(DataFormat dataFormat) {
        dataFormat.setError(dataFormat.getAccessDate() == null);
    }
}
