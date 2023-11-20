package mvcboard;

import fileupload.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import utils.JSFunction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WriteController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("./Write.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1.파일 업로드 처리
    // 업로드 디레곹리의 물리적 경로 확인
    String saveDirectory = req.getServletContext().getRealPath("/Uploads");

    //파일 업로드
    String originalFileName = "";
    try {
      originalFileName = FileUtil.uploadFile(req, saveDirectory);
    } catch (Exception e) {
      // 파일 업로드 실패
      JSFunction.alertLocation(resp, "파일 업로드 오류입니다.", "../mvcboard/write.do");
      return;
    }
    // 2.파일 업로드외 처리
    //폼값을 DTO에 저장
    MVCBoardDTO dto = new MVCBoardDTO();
    dto.setName(req.getParameter("name"));
    dto.setTitle(req.getParameter("title"));
    dto.setContent(req.getParameter("content"));
    dto.setPass(req.getParameter("pass"));

    // 원본 파일명과 저장된 파일 이름 설정
    if (originalFileName != "") {
      // 첨부 파일이 있을 경우 파일명 변경
      String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);

      dto.setOfile(originalFileName); // 원래파일이름
      dto.setSfile(savedFileName); //서버에 저장된 파일이름
    }
    //DAO를 통해 DB에 게시 내용 저장
    MVCBoardDAO dao = new MVCBoardDAO();
    int result = dao.insertWrite(dto);
    dao.close();

    // 성공 or 실패
    if (result == 1) {
      resp.sendRedirect("../mvcboard/list.do");
    } else { //글쓰기 실패
      JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.", "../mvcboard/write.do");
    }
  }
}