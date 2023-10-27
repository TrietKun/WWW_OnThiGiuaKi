package com.example.on.fontend.controllers;

import com.example.on.Services.XeService;
import com.example.on.models.Xe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/XeTheoLoai")
public class XeTheoLoai extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loai = req.getParameter("loai");
        XeService xeService = new XeService();
        List<Xe> xeList = xeService.getXeByLoaiXe(loai);
        req.setAttribute("xeList", xeList);
        req.getRequestDispatcher("/XeTheoLoai.jsp");
    }
}
