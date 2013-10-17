package com.guide.city.servlets;

import com.guide.city.commands.ACommand;
import com.guide.city.requests.GenericRequestProcessor;
import com.guide.city.requests.RequestHelper;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/api"})
public class FrontServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericRequestProcessor processor = new GenericRequestProcessor(request);

        ACommand command = processor.process();

        GenericResponse appResponse = RequestHelper.perform(command);
        ResponseHelper.sendResponse(appResponse, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}