package ru.learn.springtask.data.checkers;

import org.springframework.beans.factory.annotation.Value;
import ru.learn.springtask.data.DataFormat;

import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Проверка типа приложения
 */
public class CheckApplicationType  implements Consumer<DataFormat> {
    @Value("${fixer.applicationType.pattern}")
    private String applicationPattern;
    @Value("${fixer.applicationType.changeValue}")
    private String changeValue;

    @Override
    public void accept(DataFormat dataFormat) {
        var pattern = Pattern.compile(applicationPattern);
        if (!pattern.matcher(dataFormat.getApplication()).matches()) dataFormat.setApplication(changeValue + dataFormat.getApplication());
    }
}
