package com.example.on.repositories;

import com.example.on.models.Xe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class XeRepository {
    private EntityManager em ;
    private EntityTransaction trs;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public XeRepository(){
        em = Persistence.createEntityManagerFactory("triet").createEntityManager();
        trs = em.getTransaction();
    }
    public List<Xe> getAllXe(){
        return em.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }
    public List<Xe> getXeByLoaiXe(String loai){
        TypedQuery<Xe> query = em.createQuery("select x from Xe x where x.loaiXe=:loai", Xe.class);
        query.setParameter("loai", loai);
        return query.getResultList();
    }
    public void insertXe(Xe xe){
        try {
            trs.begin();
            em.persist(xe);
            trs.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Optional<Xe> findById(Long id){
        TypedQuery<Xe> query = em.createQuery("select x from Xe x where x.id=:id", Xe.class);
        query.setParameter("id", id);
        Xe xe = query.getSingleResult();
        return xe == null ? Optional.empty() :Optional.of(xe);

    }
}
