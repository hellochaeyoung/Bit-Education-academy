package dto;

import java.io.Serializable;

// Public Domain Software
public class PdsDto implements Serializable {

    private int seq;
    private String id;
    private String title;
    private String content;
    private String fileName; // abc.txt
    private String newFileName; // 342353.txt
    private int readCount;
    private int downCount;
    private String regDate;

    public PdsDto() {

    }

    public PdsDto(int seq, String id, String title, String content, String fileName, String newFileName, int readCount, int downCount, String regDate) {
        this.seq = seq;
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.newFileName = newFileName;
        this.readCount = readCount;
        this.downCount = downCount;
        this.regDate = regDate;
    }


    public PdsDto(String id, String title, String content, String fileName, String newFileName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.newFileName = newFileName;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "PdsDto{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", newFileName='" + newFileName + '\'' +
                ", readCount=" + readCount +
                ", downCount=" + downCount +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
