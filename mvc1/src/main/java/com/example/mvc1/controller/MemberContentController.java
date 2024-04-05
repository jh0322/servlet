package com.example.mvc1.controller;

import com.example.mvc1.model.MemberDAO;
import com.example.mvc1.model.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='/memberUpdate.do' method='post'>");
        out.println("<table class='table table-bordered'>");
        if (vo != null) {
            out.println("<input type='hidden' name='num' value='"+vo.getNum()+"'");
            out.println("<tr>");
            out.println("<td colspan='2'>"+ vo.getName() +" 회원의 상세보기</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>번호</td>");
            out.println("<td>"+vo.getNum()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>아이디</td>");
            out.println("<td>"+vo.getId()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>비밀번호</td>");
            out.println("<td>"+vo.getPassword()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>이름</td>");
            out.println("<td>"+vo.getName()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>나이</td>");
            out.println("<td><input type='text' name='age' value='"+vo.getAge()+"'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>이메일</td>");
            out.println("<td><input type='text' name='email' value='"+vo.getEmail()+"'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>전화번호</td>");
            out.println("<td><input type='text' name='phone' value='"+vo.getPhone()+"'></td>");
            out.println("</tr>");
        } else {
            out.println("<tr>");
            out.println("<td>일치하는 회원이 없습니다.</td>");
            out.println("</tr>");
        }
        out.println("<tr>");
        out.println("<td colspan='2' align='center'>");
        out.println("<input type='submit' value='수정하기' class='btn btn-primary'>");
        out.println("<input type='reset' value='취소' class='btn btn-danger'>");
        out.println("<a href='/memberList.do'>리스트</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
