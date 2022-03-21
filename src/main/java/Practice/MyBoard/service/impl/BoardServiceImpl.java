package Practice.MyBoard.service.impl;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.mapper.BoardMapper;
import Practice.MyBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }
}
