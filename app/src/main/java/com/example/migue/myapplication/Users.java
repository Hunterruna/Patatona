package com.example.migue.myapplication;

/**
 * Created by migue on 13/08/2017.
 */
public class Users {
    String nom;
    String pas;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public Users(String nom, String pas) {
        this.nom = nom;
        this.pas = pas;
    }

    public Users() {
    }
}
