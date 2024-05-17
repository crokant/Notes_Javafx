package com.example.notes_zhavoronkov;

public class NoteData{
    public String fileName;
    public String simpleFileName;
    public String content;
    public String simpleNoDate;


    public NoteData(String fileName, String content, String simpleFileName, String simpleNoDate) {
        this.fileName = fileName;
        this.content = content;
        this.simpleFileName = simpleFileName;
        this.simpleNoDate = simpleNoDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getSimpleFileName() {
        return simpleFileName;
    }

    public void setSimpleFileName(String fileName) {
        this.simpleFileName = simpleFileName;
    }
    public String getSimpleNoDate() {return simpleNoDate;}
    public void setSimpleNoDate(String simpleNoDate) {this.simpleNoDate = simpleNoDate;}

}
