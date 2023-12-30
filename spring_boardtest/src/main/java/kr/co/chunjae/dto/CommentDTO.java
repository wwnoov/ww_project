package kr.co.chunjae.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    @NotEmpty(message = "작성자를 입력해주세요")
    @Size(min = 2, max = 12, message = "작성자는 2~12자 이어야 합니다")
    private String commentWriter;
    @NotEmpty(message = "내용을 입력해주세요")
    private String commentContents;
    private Long boardId;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul") // ajax 날짜 형태 지정
    private Timestamp commentCreatedTime;
}