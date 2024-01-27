package kr.co.chunjae.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class BoardDTO {
    private Long id;

    @Size(min = 2, max = 12, message = "작성자는 2~12자 이어야 합니다")
    @NotBlank(message = "작성자를 입력해주세요")
    private String boardWriter;

    @Size(min = 1, max = 12, message = "비밀번호는 1~12자 이어야 합니다")
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String boardPass;
    @NotBlank(message = "제목을 입력해주세요")
    private String boardTitle;
    @NotBlank(message = "내용을 입력해주세요")
    private String boardContents;

    private int boardHits;

    private Timestamp boardCreatedTime;
}