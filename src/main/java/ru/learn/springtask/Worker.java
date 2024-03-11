package ru.learn.springtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.learn.springtask.data.DataFormat;
import ru.learn.springtask.data.checkers.Checker;
import ru.learn.springtask.db.SaveData;
import ru.learn.springtask.file.FolderProcessor;

@Slf4j
@Component
public class Worker {

    @Autowired
    FolderProcessor folderReader;
    @Autowired
    SaveData saveData;
    @Autowired
    Checker dataCheckerService;
    public void make(){
    log.info("Запущен Make");
        folderReader.get();
        folderReader.getFiles().forEach(fileProcessor ->
                fileProcessor.getContents().forEach(content -> {
                    var csvData = (DataFormat) content;
                    log.info("Данные вычитанные из файла: {}",csvData.toString());
                    var checkedContent = dataCheckerService.check(csvData);
                    log.info("Проверенные и модифицированные данные: {}", checkedContent);
                    saveData.save(checkedContent);
                }));

    }

}
