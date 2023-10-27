package com.example.on.fontend.controllers;

import com.example.on.Services.LoaiXeService;
import com.example.on.models.LoaiXe;
import com.example.on.models.Xe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/loaiXeServlet")
public class LoaiXeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoaiXeService loaiXeService = new LoaiXeService();
        List<LoaiXe> loaiXeList =loaiXeService.getAllLoaiXe();
        req.setAttribute("loaiXeList", loaiXeList);
        req.getRequestDispatcher("/LoaiXe.jsp").forward(req, resp);
    }
}
