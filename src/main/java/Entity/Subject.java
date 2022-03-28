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
@Table(name = "mon")
public class Subject implements Serializable {

    @Id
    @Column(name = "mamon")
    private String mamon;
    @Column(name = "tenmon")
    private String tenmon;

    public Subject(String mamon, String tenmon) {
        this.mamon = mamon;
        this.tenmon = tenmon;
    }

    public Subject() {
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

}
