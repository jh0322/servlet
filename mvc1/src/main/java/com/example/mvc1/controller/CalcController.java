package com.example.mvc1.controller;

import com.example.mvc1.model.MyCalc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet("/calc.do")
// Controller 역할
public class CalcController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1.클라이언트에서 넘어오는 폼 파라미터를 받기(파라미터 수집, su1, su2)
        int su1 = Integer.parseInt(request.getParameter("su1"));
        int su2 = Integer.parseInt(request.getParameter("su2"));

        //su1~su2=?
//        //비즈니스로직->Model로 분리하기
//        int sum=0;
//        for(int i=su1; i<=su2; i++) {
//            sum+=i;
//        }
        MyCalc myCalc = new MyCalc();
        int sum = myCalc.hap(su1, su2);

        //응답하는 부분(프리젠테이션로직=View=JSP)
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>TOTAL</td>");
        out.println("<td>");
        out.println(sum);
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}
