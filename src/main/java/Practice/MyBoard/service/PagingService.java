package Practice.MyBoard.service;

import Practice.MyBoard.utils.Criteria;
import Practice.MyBoard.utils.PagingUtil;

public interface PagingService {
    PagingUtil getPagination(Criteria criteria, BoardService boardService);

}
