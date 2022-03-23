package Practice.MyBoard.service.impl;

import Practice.MyBoard.service.BoardService;
import Practice.MyBoard.service.PagingService;
import Practice.MyBoard.utils.Criteria;
import Practice.MyBoard.utils.PagingUtil;
import org.springframework.stereotype.Service;

@Service
public class PagingServiceImpl implements PagingService {

    @Override
    public PagingUtil getPagination(Criteria criteria, BoardService boardService) {
        PagingUtil paging = new PagingUtil();
        paging.setCri(criteria);
        paging.setTotalCount(boardService.getNumberOfPost());

        return paging;
    }
}
