package ru.learn.springtask.data.checkers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.learn.springtask.data.DataFormat;

import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Проверка типа приложения
 */
@Component
public class CheckApplicationType  implements Consumer<DataFormat> {
    @Value("${check.applicationType.pattern}")
    private String applicationPattern;
    @Value("${check.applicationType.changeValue}")
    private String changeValue;

    @Override
    public void accept(DataFormat dataFormat) {
        var pattern = Pattern.compile(applicationPattern);
        if (!pattern.matcher(dataFormat.getApplication()).matches()) dataFormat.setApplication(changeValue + dataFormat.getApplication());
    }
}
