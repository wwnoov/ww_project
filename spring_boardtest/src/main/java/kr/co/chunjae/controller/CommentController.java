package kr.co.chunjae.controller;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.CommentDTO;
import kr.co.chunjae.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO) {
        commentService.save(commentDTO);
        // 해당 게시글에 작성된 댓글 리스트를 가져옴
        List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
        return commentDTOList;
    }

    @GetMapping
    public String findByCommnetId(@RequestParam("id") Long id,
                           Model model) {
        CommentDTO commentDTO = commentService.findByComment(id);
        model.addAttribute("comment", commentDTO);
        return "cdetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        commentService.delete(id);
        return "redirect:/board/paging";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        CommentDTO commentDTO = commentService.findByComment(id);
        model.addAttribute("comment", commentDTO);
        return "cupdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Valid CommentDTO commentDTO, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cdetail";
        }
        commentService.update(commentDTO);
        CommentDTO dto = commentService.findByComment(commentDTO.getId());
        model.addAttribute("comment", dto);
        return "cdetail";
    }


}