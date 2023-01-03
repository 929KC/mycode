package com.kc.web.servlet;

import com.kc.web.dao.VoteMapper;
import com.kc.web.dao.impl.VoteImpl;
import com.kc.web.model.Vote;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toview")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        VoteMapper vote = new VoteImpl();
        List<Vote> votes = vote.getVotes();
        int sumNumb = vote.getSumNumb();
        double[] arr = getPercentage(votes, sumNumb);
        double[] width = getWidth(votes, sumNumb);
        WebContext webContext = new WebContext(request, response, getServletContext());
        webContext.setVariable("votes", votes);
        webContext.setVariable("sumnumbs", sumNumb);
        webContext.setVariable("arr",arr);
        webContext.setVariable("width",width);
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        engine.process("view", webContext, response.getWriter());
    }

    private double[] getPercentage(List<Vote> list, int sumNumb) {
        double  [] arr = new double[5];
        int count = 0;
        for (Vote vote : list) {
            double num =  (vote.numb*100)/sumNumb;
            arr[count++] =  num;
        }
        return arr;
    }

    private double[] getWidth(List<Vote> list, int sumNumb) {
        double  [] arr = new double[5];
        int count = 0;
        for (Vote vote : list) {
            double num =  (vote.numb*200)/sumNumb;
            arr[count++] =  num;
        }
        return arr;
    }
}
