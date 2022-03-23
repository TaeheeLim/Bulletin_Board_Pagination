package Practice.MyBoard.controller;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.service.BoardService;
import Practice.MyBoard.service.PagingService;
import Practice.MyBoard.utils.Criteria;
import Practice.MyBoard.utils.PagingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final PagingService pagingService;

    @GetMapping("/boardList")
    public String getBoardList(@ModelAttribute Criteria criteria, Model model){
        PagingUtil paging = pagingService.getPagination(criteria, boardService);
        List<Board> boardList = boardService.getBoardList(criteria);

        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);

        log.info("startPage = {}", paging.getStartPage());
        log.info("endPage = {}", paging.getEndPage());

        return "/board/boardList";
    }

    @GetMapping("/addBoard")
    public String boardAddForm() {
        return "/board/boardWrite";
    }

    @PostMapping("/boardWrite")
    public String boardWrite(@ModelAttribute Board board, RedirectAttributes redirect){
        log.info("board = {}", board.toString());
        int result = boardService.insertBoard(board);
        log.info("boardIdx = {}", board.getBoardIdx());

        redirect.addAttribute("boardIdx", board.getBoardIdx());

        return "redirect:/board/boardDetail/{boardIdx}";
    }

    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam int boardIdx,
                              @ModelAttribute Criteria cri,
                              Model model){

        Board board = boardService.boardDetail(boardIdx);
        log.info("board = {}", board.toString());
        model.addAttribute("board", board);
        PagingUtil paging = new PagingUtil();
        paging.setCri(cri);
        model.addAttribute("page", cri.getPage());
        model.addAttribute("paging", paging);

        return "/board/boardDetail";
    }

}
