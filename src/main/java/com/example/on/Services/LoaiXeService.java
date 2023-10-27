package com.example.on.Services;

import com.example.on.models.LoaiXe;
import com.example.on.repositories.LoaiXeRepository;

import java.util.List;
import java.util.Optional;

public class LoaiXeService {
    private LoaiXeRepository loaiXeRepository;

    public LoaiXeService() {
        loaiXeRepository = new  LoaiXeRepository();
    }
    public List<LoaiXe> getAllLoaiXe(){
        return loaiXeRepository.getAllLoaiXe();
    }

    public Optional<LoaiXe> findByTenLoai(String tenLoai){
        return loaiXeRepository.findByTenLoai(tenLoai);
    }
}
