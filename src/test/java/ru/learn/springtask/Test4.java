package ru.learn.springtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.learn.springtask.data.DataFormat;
import ru.learn.springtask.data.checkers.impl.DataCheckerService;
import ru.learn.springtask.data.impl.CsvFormat;
import ru.learn.springtask.db.SaveData;
import ru.learn.springtask.db.impl.SaveDataToH2;
import ru.learn.springtask.file.FolderProcessor;
@SpringBootApplication
public class Test4 {
    @Test
    public void readFolderTest(){
        ApplicationContext context = SpringApplication.run(SpringTaskApplication.class);
        FolderProcessor folderReader = context.getBean("folderProcessor", FolderProcessor.class).get();
        SaveDataToH2 saveData = context.getBean("saveDataToH2", SaveDataToH2.class);
        DataCheckerService dataCheckerService = context.getBean("dataCheckerService", DataCheckerService.class);

        folderReader.getFiles().forEach(fileProcessor -> fileProcessor.getContents().forEach(content  -> {
            var csvData = (DataFormat) content;
            System.out.println(csvData.toString());
            var checkedContent = dataCheckerService.check(csvData);
            System.out.println(checkedContent.toString());
            saveData.save(checkedContent);
        }));
    }

}
