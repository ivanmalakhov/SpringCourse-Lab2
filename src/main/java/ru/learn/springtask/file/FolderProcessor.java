package ru.learn.springtask.file;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import ru.learn.springtask.log.LogTransformation;

@Component
//@DependsOn("properties")
@Slf4j
public class FolderProcessor implements Reader {
    @Getter
    private final List<FileProcessor> files = new ArrayList<>();
    @Value("${reader.path}")
    private String folderName;

    @Override
    public String toString() {
        return "FolderProcessor{" +
                "files=" + files +
                ", folderName='" + folderName + '\'' +
                '}';
    }

    @Autowired
    Class format;
    @Override
    @LogTransformation
    public FolderProcessor get() {
        try (Stream<Path> stream = Files.walk(Paths.get(folderName)).filter(Files::isRegularFile)) {
            stream.forEach(file -> files.add(new FileProcessor(file).apply(format)));
        } catch (IOException e) {
            log.error("Ошибка при работе с каталогом", e);
        }
        return this;
    }
}
