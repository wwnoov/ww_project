package mybatis.mapper;


import board.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


  List<BoardDTO> selectListPage(Map<String, Object> map);
  BoardDTO selectView(String idx);

}