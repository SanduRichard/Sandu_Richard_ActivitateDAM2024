package com.example.semi10;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "masina_table")
public class Masina {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String marca;
    private String model;
    private int anFabricatie;
    private boolean esteDisponibila;

    public Masina(String marca, String model, int anFabricatie, boolean esteDisponibila) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.esteDisponibila = esteDisponibila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public boolean isEsteDisponibila() {
        return esteDisponibila;
    }

    public void setEsteDisponibila(boolean esteDisponibila) {
        this.esteDisponibila = esteDisponibila;
    }
}
