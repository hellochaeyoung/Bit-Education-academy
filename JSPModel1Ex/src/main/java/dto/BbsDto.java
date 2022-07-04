package dto;

import java.io.Serializable;

// BBS : Bulletin Board System
public class BbsDto implements Serializable {

    private int seq; // sequence
    private String id; // 작성자

    private int ref; // 그룹번호
    private int step; // 행번호
    private int depth; // 깊이

    private String title;
    private String content;
    private String wdate;

    private int del;
    private int readCount;

    public BbsDto() {
    }

    public BbsDto(int seq, String id, int ref, int step, int depth, String title, String content, String wdate, int del, int readCount) {
        this.seq = seq;
        this.id = id;
        this.ref = ref;
        this.step = step;
        this.depth = depth;
        this.title = title;
        this.content = content;
        this.wdate = wdate;
        this.del = del;
        this.readCount = readCount;
    }

    // 나머지 변수들은 서버에서 처리, 이 세 개만 input값으로 사용자가 입력하기 때문
    public BbsDto(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
}
