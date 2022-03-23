package Practice.MyBoard.service;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.utils.Criteria;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList(Criteria criteria);

    int getNumberOfPost();

    int insertBoard(Board board);

    Board boardDetail(int boardIdx);

    int deleteBoard(int boardidx);
}
