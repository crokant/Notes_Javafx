package com.example.notes_zhavoronkov;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface NoteSaver {
    default NoteData saveNote(String title, String content) {
        String simpleNoDate = title;
        title = title.replace(" ", "_");
        title = title.replaceAll("[<>:\"/\\|?*]", "-");

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss_dd.MM.yy");
        String currentDate = dateFormat.format(new Date());

        String directoryPath = "src/main/directoryJSONfiles";
        String fileName = title + "_" + currentDate + ".json";
        String savePath = directoryPath + File.separator + fileName;

        String simpleFileName = simpleNoDate +" "+ currentDate;
        NoteData noteData = new NoteData(fileName, content, simpleFileName, simpleNoDate);

        try (FileWriter fileWriter = new FileWriter(savePath)) {
            String jsonString = JSON.toJSONString(noteData);
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noteData;
    }
}


