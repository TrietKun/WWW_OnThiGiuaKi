package com.example.on.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LoaiXe")
@NamedQueries(
        @NamedQuery(name = "LoaiXe.findAll", query = "select lx from LoaiXe lx")
)
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenLoai")
    private String tenLoai;
    @OneToMany
    private List<Xe> listXe;

    public LoaiXe(String tenLoai, List<Xe> listXe) {
        this.tenLoai = tenLoai;
        this.listXe = listXe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<Xe> getListXe() {
        return listXe;
    }

    public void setListXe(List<Xe> listXe) {
        this.listXe = listXe;
    }

    public LoaiXe() {
    }

    @Override
    public String toString() {
        return "LoaiXe{" +
                "id=" + id +
                ", tenLoai='" + tenLoai + '\'' +
                ", listXe=" + listXe +
                '}';
    }
}
