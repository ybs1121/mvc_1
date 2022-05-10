package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.member.Member;
import hello.servlet.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class MemberListControllerV2 implements ControllerV2 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members",members);
        String viewPath = "/WEB-INF/views/members.jsp";

        return new MyView(viewPath);
    }
}
