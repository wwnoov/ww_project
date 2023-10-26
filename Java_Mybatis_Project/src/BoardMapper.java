import java.util.ArrayList;

public interface BoardMapper {
    public ArrayList<BoardVO> getBoard();
    public void insertBoard(BoardVO boardVO);
    public ArrayList<BoardVO> readBoard(int bno);
    public void updateBoard(BoardVO boardVO);
    public void deleteBoard(int bno);
    public void clearBoard();
}
