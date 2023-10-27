package com.example.on.fontend.controllers;

import com.example.on.Services.XeService;
import com.example.on.fontend.models.LoaiXeModel;
import com.example.on.fontend.models.XeModel;
import com.example.on.models.LoaiXe;
import com.example.on.models.Xe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet("/xeServlet")
public class XeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            if (action.equals("getAllXe")) {
                XeService xeService = new XeService();
                List<Xe> xeList = xeService.getAll();
                req.setAttribute("xeList", xeList);
            } else if (action.equals("loai")) {
                String loai = req.getParameter("loai");

                XeService xeService = new XeService();
                List<Xe> xeListByLoai = xeService.getXeByLoaiXe(loai);
                req.setAttribute("xeList", xeListByLoai);
            }
        }

        req.getRequestDispatcher("/Xe.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("addCar")){
            XeModel xeModel = new XeModel();
            String ten = req.getParameter("tenXe");
            double gia = Double.parseDouble(req.getParameter("giaXe"));
            Date namSX = new Date();
            LoaiXeModel loaiXeModel = new LoaiXeModel();
            Optional<LoaiXe> op = loaiXeModel.findByTenLoai(req.getParameter("loaixe"));
            LoaiXe loaiXe = op.get();
            Xe xe = new Xe(ten,gia,namSX,loaiXe);
            xeModel.insertXe(xe);
            resp.sendRedirect("Xe.jsp");

        }
    }
}
