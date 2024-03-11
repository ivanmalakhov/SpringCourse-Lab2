package ru.learn.springtask.file;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.learn.springtask.log.LogTransformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

@Slf4j
public class FileProcessor implements Function<Class, FileProcessor> {
    @Getter
    private List<Object> contents;
    private final Path filepath;
    public FileProcessor(Path filepath) {
        this.filepath = filepath;
    }
    @Override
    public String toString() {
        return "FileReader{" +
                "logData=" + "logData" +
                ", filepath=" + filepath +
                '}';
    }

    @Override
    @LogTransformation
    public FileProcessor apply(Class aClass) {
        try {
            this.contents = new CsvToBeanBuilder(Files.newBufferedReader(filepath))
                    .withType(aClass)
                    .withSeparator(',')
                    .build()
                    .parse();
        } catch (IOException e) {
            log.error("Ошибка при разборе файла", e);
        }
        return this;
    }
}
