/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TAN
 */
@Entity
@Table(name = "diem")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mahv")
    private int mahv;
    @Column(name = "makh")
    private String makh;
    @Column(name = "mamon")
    private String mamon;
    @Column(name = "diemlt")
    private float diemlt;
    @Column(name = "diemth")
    private float diemth;

    public Score(int id, int mahv, String makh, String mamon, float diemlt, float diemth) {
        this.id = id;
        this.mahv = mahv;
        this.makh = makh;
        this.mamon = mamon;
        this.diemlt = diemlt;
        this.diemth = diemth;
    }

    public Score() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMahv() {
        return mahv;
    }

    public void setMahv(int mahv) {
        this.mahv = mahv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public float getDiemlt() {
        return diemlt;
    }

    public void setDiemlt(float diemlt) {
        this.diemlt = diemlt;
    }

    public float getDiemth() {
        return diemth;
    }

    public void setDiemth(float diemth) {
        this.diemth = diemth;
    }

}
