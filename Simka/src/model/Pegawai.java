/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nuril
 */
public class Pegawai {
    private Integer Nip;
    private Instalasi instalasi;
    private String Nama_Pegawai;
    private String Alamat;
    private String No_hp;
    private String Email;

    public Integer getNip() {
        return Nip;
    }

    public void setNip(Integer Nip) {
        this.Nip = Nip;
    }

    public Instalasi getInstalasi() {
        return instalasi;
    }

    public void setInstalasi(Instalasi instalasi) {
        this.instalasi = instalasi;
    }

    public String getNama_Pegawai() {
        return Nama_Pegawai;
    }

    public void setNama_Pegawai(String Nama_Pegawai) {
        this.Nama_Pegawai = Nama_Pegawai;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getNo_hp() {
        return No_hp;
    }

    public void setNo_hp(String No_hp) {
        this.No_hp = No_hp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }  
}
