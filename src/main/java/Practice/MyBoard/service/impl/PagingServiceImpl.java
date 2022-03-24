package Practice.MyBoard.service.impl;

import Practice.MyBoard.service.BoardService;
import Practice.MyBoard.service.PagingService;
import Practice.MyBoard.utils.Criteria;
import Practice.MyBoard.utils.PagingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PagingServiceImpl implements PagingService {

    @Override
    public PagingUtil getPagination(Criteria criteria, BoardService boardService) {
        PagingUtil paging = new PagingUtil();
        paging.setCri(criteria);
        log.info("개수1 : {}", boardService.getNumberOfPost(criteria));
        paging.setTotalCount(boardService.getNumberOfPost(criteria));


        return paging;
    }
}
