/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Instalasi;
import model.Pegawai;
/**
 *
 * @author Nuril
 */
    public class Transaksi {
    koneksi koneksi;
    ArrayList<Instalasi> arrInstalasi;
    ArrayList<Pegawai> arrPegawai;

    
    public Transaksi() {
        this.koneksi = new koneksi();
        this.arrInstalasi = new ArrayList<>();
        this.arrPegawai = new ArrayList<>();
    }
    
    public ArrayList<Instalasi> getDataInstalasi() throws SQLException {
        this.arrInstalasi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM Instalasi");
        while (rs.next()) {
            Instalasi I = new Instalasi();
            I.setId_instalasi(rs.getInt("ID_INSTALASI"));
            I.setNama_Instalasi(rs.getString("NAMA_INSTALASI"));
            

            this.arrInstalasi.add(I);
        }
        return this.arrInstalasi;
    }
    
    public ArrayList<Pegawai> getDataPegawai() throws SQLException {
        this.arrPegawai.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PEGAWAI JOIN INSTALASI ON INSTALASI.ID_INSTALASI = PEGAWAI.ID_INSTALASI ORDER BY PEGAWAI.NIP ASC");
        while (rs.next()) {
            
            Instalasi I = new Instalasi();
            I.setId_instalasi(rs.getInt("ID_INSTALASI"));
            I.setNama_Instalasi(rs.getString("NAMA_INSTALASI"));
            
            Pegawai p = new Pegawai();
            p.setNip(rs.getInt("NIP"));
            p.setInstalasi(I);
            p.setNama_Pegawai(rs.getString("NAMA_PEGAWAI"));
            p.setAlamat(rs.getString("ALAMAT"));
            p.setNo_hp(rs.getString("NO_HP"));
            p.setEmail(rs.getString("EMAIL"));
            
            this.arrPegawai.add(p);
        }
        return this.arrPegawai;
    }
    
    public void insertPegawai(Pegawai pegawai) throws SQLException{
        try {
            this.koneksi.ManipulasiData("insert into pegawai values ("+"'"+pegawai.getNip()+"','"+ pegawai.getInstalasi().getId_Instalasi()+"', '"+ pegawai.getNama_Pegawai()+"', '"+ pegawai.getAlamat()+"', '"+ pegawai.getNo_hp()+"', '"+ pegawai.getEmail()+"')");
        } catch (Exception ex) {
            System.out.println(ex);
        }   
    }
    
    public void deletePegawai(Pegawai pegawai) throws SQLException{
        try {
            this.koneksi.ManipulasiData("DELETE FROM PEGAWAI WHERE NIP = "+pegawai.getNip());
        } catch (Exception ex) {
            System.out.println(ex);
        } 
    }
    
    public void editPegawai(Pegawai pegawai) throws SQLException{
        this.koneksi.ManipulasiData("UPDATE PEGAWAI SET ID_INSTALASI = '"+pegawai.getInstalasi().getId_Instalasi()+"', NAMA_PEGAWAI = '"+pegawai.getNama_Pegawai()+"', ALAMAT = '"+pegawai.getAlamat()+"', NO_HP = '"+pegawai.getNo_hp()+"', EMAIL = '"+pegawai.getEmail()+"' WHERE NIP = "+pegawai.getNip());
    }
    
 }

    