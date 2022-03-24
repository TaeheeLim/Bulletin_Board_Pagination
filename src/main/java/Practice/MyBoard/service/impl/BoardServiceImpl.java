package Practice.MyBoard.service.impl;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.mapper.BoardMapper;
import Practice.MyBoard.service.BoardService;
import Practice.MyBoard.utils.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<Board> getBoardList(Criteria criteria) {
        log.info(criteria.toString());
        return boardMapper.getBoardList(criteria);
    }

    @Override
    public int getNumberOfPost(Criteria criteria) {
        return boardMapper.getNumberOfPost(criteria);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateBoard(Board board) {
        return boardMapper.updateBoard(board);
    }

    @Override
    public int increaseCount(int boardIdx) {
        return boardMapper.increaseCount(boardIdx);
    }


}
