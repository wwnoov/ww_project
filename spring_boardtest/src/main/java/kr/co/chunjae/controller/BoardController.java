package kr.co.chunjae.controller;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.CommentDTO;
import kr.co.chunjae.dto.PageDTO;
import kr.co.chunjae.service.BoardService;
import kr.co.chunjae.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    // 생성자를 통한 BoardService와 CommentService의 의존성 주입
    private final BoardService boardService;
    private final CommentService commentService;

    // 새로운 게시글을 생성폼 메서드
    @GetMapping("/save")
    public String saveForm(Model model){
        model.addAttribute("boardDTO", new BoardDTO());
        return "save";
    }

    // 새로운 게시글을 저장하는 메서드
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute BoardDTO boardDTO, BindingResult bindingResult) {
        // 제출된 boardDTO의 유효성 검사
        if (bindingResult.hasErrors()) {
            // 유효성 검사에 실패하면 오류 메시지와 함께 저장 폼으로 돌아갑니다.
            return "save";
        }
        // BoardService를 사용하여 게시글을 저장합니다.
        int saveResult = boardService.save(boardDTO);
        if (saveResult > 0) {
            // 저장이 성공하면 게시판 목록 페이지로 리다이렉트합니다.
            return "redirect:/board/paging";
        } else {
            // 저장에 실패하면 저장 폼으로 돌아갑니다.
            return "save";
        }
    }

    // 모든 게시글 목록 메서드
/*    @GetMapping("/list")
    public String findAll(Model model) {
        // BoardService를 사용하여 모든 게시글을 가져옵니다.
        List<BoardDTO> boardDTOList = boardService.findAll();
        // 뷰에서 렌더링하기 위해 모델에 게시글 목록을 추가합니다.
        model.addAttribute("boardList", boardDTOList);
        // 뷰 이름을 반환합니다.
        return "list";
    }*/

    // 특정 게시글의 상세보기 메서드
    @GetMapping
    public String findById(@RequestParam("id") Long id,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           Model model) {
        // 주어진 id로 식별된 게시글의 조회수를 업데이트합니다.
        boardService.updateHits(id);
        // BoardService를 사용하여 특정 게시글을 가져옵니다.
        BoardDTO boardDTO = boardService.findById(id);
        // 뷰에서 렌더링하기 위해 모델에 게시글 및 관련 정보를 추가합니다.
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);
        // 게시글에 대한 댓글 목록을 검색하여 모델에 추가합니다.
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
        // 댓글 목록에 대한 정보를 로깅합니다.
        log.info(commentDTOList);
        // 뷰 이름을 반환합니다.
        return "detail";
    }

    // 특정 게시글을 삭제하는 메서드
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        // BoardService를 사용하여 주어진 id로 식별된 게시글을 삭제합니다.
        boardService.delete(id);
        // 삭제 후 게시판 목록 페이지로 리다이렉트합니다.
        return "redirect:/board/paging";
    }

    // 특정 게시글을 수정폼 메서드
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        // BoardService를 사용하여 주어진 id로 식별된 게시글을 가져옵니다.
        BoardDTO boardDTO = boardService.findById(id);
        // 뷰에서 렌더링하기 위해 모델에 게시글을 추가합니다.
        model.addAttribute("boardDTO", boardDTO);
        // 뷰 이름을 반환합니다.
        return "update";
    }

    // 게시글을 수정 메서드
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute BoardDTO boardDTO, BindingResult bindingResult, Model model) {
        // 제출된 boardDTO의 유효성 검사
        if (bindingResult.hasErrors()) {
            // 유효성 검사에 실패하면 상세 뷰로 돌아갑니다.
            return "detail";
        }
        // BoardService를 사용하여 게시글을 업데이트합니다.
        boardService.update(boardDTO);
        // 업데이트된 게시글을 가져와 모델에 추가하여 상세 뷰에서 렌더링합니다.
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        // 뷰 이름을 반환합니다.
        return "detail";
    }

    // 페이징 메서드
    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        // BoardService를 사용하여 지정된 페이지의 게시글 목록을 가져옵니다.
        List<BoardDTO> pagingList = boardService.pagingList(page);
        // BoardService를 사용하여 페이징 정보를 가져옵니다.
        PageDTO pageDTO = boardService.pagingParam(page);
         // 페이징된 목록 및 페이징 정보를 뷰에서 렌더링하기 위해 모델에 추가합니다.
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        // 뷰 이름을 반환합니다.
        return "paging";
    }
}
