package Practice.MyBoard.controller;

import Practice.MyBoard.entity.Board;
import Practice.MyBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    @ResponseBody
    public String getBoardList(){
        List<Board> boardList = boardService.getBoardList();
        log.info("list size={}",boardList.size());
        log.info("boardList = {}", boardList.toString());
        return "hello";
    }
}
