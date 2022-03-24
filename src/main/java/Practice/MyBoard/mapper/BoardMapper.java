package Practice.MyBoard.mapper;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList(Map<String, Object> map);

    int getNumberOfPost();

    int insertBoard(Board board);

    Board boardDetail(@Param("boardIdx")int boardIdx);

    int deleteBoard(int boardIdx);

    int updateBoard(Board board);

    int increaseCount(int boardIdx);
}
