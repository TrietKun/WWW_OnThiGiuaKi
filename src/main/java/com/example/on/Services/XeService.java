package com.example.on.Services;

import com.example.on.models.Xe;
import com.example.on.repositories.XeRepository;

import java.util.ArrayList;
import java.util.List;

public class XeService {
    private XeRepository xeRepository;
    public XeService(){
        xeRepository = new XeRepository();
    }
    public List<Xe> getAll (){
        return xeRepository.getAllXe();
    }
    public List<Xe> getXeByLoaiXe(String loai){
        return xeRepository.getXeByLoaiXe(loai);
    }
    public void insertXe(Xe xe){
        xeRepository.insertXe(xe);
    }
    public List<Xe> findXeByLoaiXe(String tenLoai){
        LoaiXeService loaiXeService = new LoaiXeService();
        List<Xe> xes = getAll();
        List<Xe> listXe = new ArrayList<>();
        for (Xe xe:xes){
            if(xe.getLoaiXe().getTenLoai().equals(tenLoai)){
                listXe.add(xe);
            }
        }
        return listXe;
    }

}
