package Practice.MyBoard.service.impl;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.mapper.BoardMapper;
import Practice.MyBoard.service.BoardService;
import Practice.MyBoard.utils.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<Board> getBoardList(Criteria criteria) {
        int pageStart = criteria.getPageStart();
        int perPageNum = criteria.getPerPageNum();
        log.info("pageStart = {}", pageStart);
        log.info("perPageNum = {}", perPageNum);

        return boardMapper.getBoardList(pageStart, perPageNum);
    }

    @Override
    public int getNumberOfPost() {
        return boardMapper.getNumberOfPost();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBoard(Board board) {
        int result = boardMapper.insertBoard(board);
        log.info("result = {}", result);

        return result;
    }

    @Override
    public Board boardDetail(int boardIdx) {
        return boardMapper.boardDetail(boardIdx);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteBoard(int boardIdx) {
        return boardMapper.deleteBoard(boardIdx);
    }


}
