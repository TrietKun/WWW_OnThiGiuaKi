package com.example.on.models;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Xe")
@NamedQueries(
        @NamedQuery(name = "Xe.findAll", query = "select xe from Xe xe")
)
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenXe")
    private String tenXe;
    @Column(name = "gia")
    private double gia;
    @Column(name = "namSanXuat")
    private Date namSX;
    @ManyToOne
    @JoinColumn(name = "loaiXe")
    private LoaiXe loaiXe;

    public Xe(String tenXe, double gia, Date namSX, LoaiXe loaiXe) {
        this.tenXe = tenXe;
        this.gia = gia;
        this.namSX = namSX;
        this.loaiXe = loaiXe;
    }

    public Xe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNamSX() {
        return namSX;
    }

    public void setNamSX(Date namSX) {
        this.namSX = namSX;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "id=" + id +
                ", tenXe='" + tenXe + '\'' +
                ", gia=" + gia +
                ", namSX=" + namSX +
                ", loaiXe=" + loaiXe +
                '}';
    }
}
