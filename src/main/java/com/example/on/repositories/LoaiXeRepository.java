package com.example.on.repositories;

import com.example.on.models.LoaiXe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class LoaiXeRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public LoaiXeRepository(){
        em = Persistence.createEntityManagerFactory("triet").createEntityManager();
        trans = em.getTransaction();
    }
    public List<LoaiXe> getAllLoaiXe(){
        return em.createNamedQuery("LoaiXe.findAll", LoaiXe.class).getResultList();
    }
    public Optional<LoaiXe> findByTenLoai(String tenLoai){
        TypedQuery<LoaiXe> query = em.createQuery("select lx from LoaiXe lx where lx.tenLoai=:tenLoai", LoaiXe.class);
        query.setParameter("tenLoai",tenLoai);
        LoaiXe loaiXe = query.getSingleResult();
        return loaiXe == null? Optional.empty() : Optional.of(loaiXe);
    }

}
