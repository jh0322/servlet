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
import java.util.ArrayList;

@Slf4j
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 클라이언트의 요청을 받기(memberList.do)
        // 2. 회원전체 리스트 가져오기(Model 연동)
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.memberList();
        // 3. 회원전체리스트를 HTML로 만들어서 응답하기
        // - 응답되는 데이터안에 한글이 있는경우 -> 인코딩
        response.setContentType("text/html; charset=utf-8"); // MIME-TYPE
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<table class='table'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>번호</th>");
        out.println("<th>아이디</th>");
        out.println("<th>비밀번호</th>");
        out.println("<th>이름</th>");
        out.println("<th>나이</th>");
        out.println("<th>이메일</th>");
        out.println("<th>전화번호</th>");
        out.println("<th>삭제</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for (MemberVO memberVO : list) {
            out.println("<tr>");
            out.println("<td>" + memberVO.getNum() + "</td>");
            out.println("<td><a href='/memberContent.do?num="+memberVO.getNum()+"'>" + memberVO.getId() + "</td>");
            out.println("<td>" + memberVO.getPassword() + "</td>");
            out.println("<td>" + memberVO.getName() + "</td>");
            out.println("<td>" + memberVO.getAge() + "</td>");
            out.println("<td>" + memberVO.getEmail() + "</td>");
            out.println("<td>" + memberVO.getPhone() + "</td>");
            out.println("<th><a href='/memberDelete.do?num="+ memberVO.getNum() + "'>삭제</a></th>");
            out.println("</tr>");
        }
        out.println("<td colspan='8' align='right'>");
        out.println("<a href='member/memberRegister.html'>회원가입</a>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
