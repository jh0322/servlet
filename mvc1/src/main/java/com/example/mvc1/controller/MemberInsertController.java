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
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 파라미터 수집(VO)
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        MemberVO vo = new MemberVO(id, password, name, age, email, phone);

        //Model 연동부분
        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberInsert(vo);
        if (cnt > 0) {
            //가입성공
            response.sendRedirect("/memberList.do");
        } else {
            //가입실패 -> 예외객체를 만들어서 WAS에게 던지자.
            throw new ServletException("not insert");
        }

    }
}
