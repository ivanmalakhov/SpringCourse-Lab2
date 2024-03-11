package ru.learn.springtask.data.checkers;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;
import ru.learn.springtask.data.DataFormat;

import java.util.function.Consumer;

/**
 * Проверка ФИО
 */
@Component
public class CheckFIO implements Consumer<DataFormat>{
    @Override
    public void accept(DataFormat dataFormat) {
        dataFormat.setFio(WordUtils.capitalizeFully(dataFormat.getFio()));
    }
}
