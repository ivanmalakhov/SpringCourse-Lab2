package ru.learn.springtask.data.impl;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.learn.springtask.data.DataFormat;

import java.time.LocalDateTime;

/**
 * Описание формата данных для CSV
 */
@Component
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CsvFormat implements DataFormat {
    @CsvBindByPosition(position = 0)
    String userName;
    @CsvBindByPosition(position = 1)
    public String fio;
    @CsvBindByPosition(position = 2)
    @CsvDate(value = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime accessDate;
    @CsvBindByPosition(position = 3)
    String application;
    boolean error = false;

}
