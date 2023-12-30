package kr.co.chunjae.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;
    @NotEmpty(message = "작성자를 입력해주세요")
    @Size(min = 2, max = 12, message = "작성자는 2~12자 이어야 합니다")
    private String boardWriter;
    @NotEmpty(message = "비밀번호를 입력해주세요")
    @Size(min = 1, max = 12, message = "비밀번호는 1~12자 이어야 합니다")
    private String boardPass;
    @NotEmpty(message = "제목을 입력해주세요")
    private String boardTitle;
    @NotEmpty(message = "내용을 입력해주세요")
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedTime;
}