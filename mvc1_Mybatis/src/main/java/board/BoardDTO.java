package board;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class BoardDTO {
  // 멤버 변수 선언
  private String idx;
  private String name;
  private String title;
  private String content;
  private LocalDate postdate;
  private String ofile;
  private String sfile;
  private int downcount;
  private String pass;
  private int visitcount;

}