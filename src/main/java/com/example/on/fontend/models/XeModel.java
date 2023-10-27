package com.example.on.fontend.models;

import com.example.on.Services.XeService;
import com.example.on.models.LoaiXe;
import com.example.on.models.Xe;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;

public class XeModel {
    private XeService xeService = new XeService();
    public List<Xe> getAllXe(){
        return xeService.getAll();
    }
    public List<Xe> findXeByLoaiXe(String tenLoai){
        return xeService.findXeByLoaiXe(tenLoai);
    }

    public void insertXe(Xe xe){
        xeService.insertXe(xe);
    }
}
