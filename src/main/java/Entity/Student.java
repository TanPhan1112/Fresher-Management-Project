/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author TAN
 */
@Entity
@Table(name = "hocvien")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahv")
    private int mahv;
    @Column(name = "ten")
    private String ten;
    @Column(name = "ngaysinh")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "gioitinh")
    private String gioitinh;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "dt")
    private int dt;
    @Column(name = "email")
    private String email;

    public Student(int mahv, String ten, Date ngaysinh, String gioitinh, String diachi, int dt, String email) {
        this.mahv = mahv;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.dt = dt;
        this.email = email;
    }

    public Student() {
    }

    public int getMahv() {
        return mahv;
    }

    public void setMahv(int mahv) {
        this.mahv = mahv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
