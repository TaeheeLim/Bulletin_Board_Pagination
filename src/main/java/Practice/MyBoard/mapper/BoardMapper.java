package Practice.MyBoard.mapper;

import Practice.MyBoard.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList();
}
