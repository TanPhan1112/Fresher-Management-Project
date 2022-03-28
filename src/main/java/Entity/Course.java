/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TAN
 */
@Entity
@Table(name = "khoahoc")
public class Course implements Serializable {

    @Id
    @Column(name = "makh")
    private String makh;
    @Column(name = "tenkh")
    private String tenkh;

    public Course(String makh, String tenkh) {
        this.makh = makh;
        this.tenkh = tenkh;
    }

    public Course() {
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

}
