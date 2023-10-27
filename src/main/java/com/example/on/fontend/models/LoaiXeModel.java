package com.example.on.fontend.models;

import com.example.on.Services.LoaiXeService;
import com.example.on.models.LoaiXe;

import java.util.List;
import java.util.Optional;

public class LoaiXeModel {
    private LoaiXeService loaiXeService = new LoaiXeService();
    public List<LoaiXe> getAllLoai(){
        return loaiXeService.getAllLoaiXe();
    }
    public Optional<LoaiXe> findByTenLoai(String tenLoai){
        return loaiXeService.findByTenLoai(tenLoai);
    }
}
