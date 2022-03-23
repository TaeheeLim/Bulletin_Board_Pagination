package Practice.MyBoard.mapper;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList(@Param("pageStart") int pageStart, @Param("perPageNum") int perPageNum);

    int getNumberOfPost();

    int insertBoard(Board board);

    Board boardDetail(@Param("boardIdx")int boardIdx);

    int deleteBoard(int boardIdx);
}
