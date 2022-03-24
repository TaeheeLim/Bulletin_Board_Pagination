package Practice.MyBoard.controller;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.service.BoardService;
import Practice.MyBoard.service.PagingService;
import Practice.MyBoard.utils.Criteria;
import Practice.MyBoard.utils.PagingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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

        log.info("boardList.criteria = {}", criteria.toString());

        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);

        return "/board/boardList";
    }

    @GetMapping("/addBoard")
    public String boardAddForm() {
        return "/board/boardWrite";
    }

    @PostMapping("/boardWrite")
    public String boardWrite(@ModelAttribute Board board, RedirectAttributes redirect){
        int result = boardService.insertBoard(board);

        redirect.addAttribute("boardIdx", board.getBoardIdx());
        if(result != 0){
            return "redirect:/board/boardDetail";
        } else {
            throw new IllegalArgumentException();
        }
    }

    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam int boardIdx,
                              @ModelAttribute Criteria cri,
                              Model model){
        boardService.increaseCount(boardIdx);
        Board board = boardService.boardDetail(boardIdx);

        PagingUtil paging = new PagingUtil();
        paging.setCri(cri);

        model.addAttribute("board", board);
        model.addAttribute("page", cri.getPage());
        model.addAttribute("paging", paging);

        return "/board/boardDetail";
    }

    @GetMapping("/boardDelete")
    public String boardDelete(@ModelAttribute Criteria cri,
                              @RequestParam int boardIdx,
                              RedirectAttributes redirectAttributes) {
        boardService.deleteBoard(boardIdx);

        redirectAttributes.addAttribute("page", cri.getPage());
        redirectAttributes.addAttribute("perPageNum", cri.getPerPageNum());

        return "redirect:/board/boardList";
    }

    @PostMapping("/boardUpdate")
    public String boardUpdate(@ModelAttribute Board board,
                              @ModelAttribute Criteria cri,
                              RedirectAttributes redirectAttributes) {
        log.info("updateContent = {}", board.toString());
        log.info("Criteria = {}", cri.toString());

        redirectAttributes.addAttribute("boardIdx", board.getBoardIdx());
        redirectAttributes.addAttribute("page", cri.getPage());

        if (boardService.updateBoard(board) > 0) {
            return "redirect:/board/boardDetail";
        } else {
            throw new IllegalArgumentException();
        }
    }

}
