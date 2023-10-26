import java.util.Date;

public class BoardVO {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    // 매개변수에 따른 생성자 생성 (5개)
    public BoardVO(int bno, String btitle, String bcontent, String bwriter, Date bdate) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }
    // 매개변수에 따른 생성자 생성 (4개)
    public BoardVO(int bno, String btitle, String bcontent, String bwriter) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
    // 매개변수에 따른 생성자 생성 (3개)
    public BoardVO(String btitle, String bcontent, String bwriter) {
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
    // 매개변수에 따른 생성자 생성 (1개)
    public BoardVO(int bno) {
        this.bno = bno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
}
