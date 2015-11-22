/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.jclient.controler;

/**
 *
 * @author Luig Rocha
 */
public class Detalle {
    private String codigopro;
    private String codigofac;
    private String nombrepro;
    private String costo;
    private String cantidad;

    public String getCodigopro() {
        return codigopro;
    }

    public void setCodigopro(String codigopro) {
        this.codigopro = codigopro;
    }

    public String getCodigofac() {
        return codigofac;
    }

    public void setCodigofac(String codigofac) {
        this.codigofac = codigofac;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Detalle(String codigopro, String codigofac, String nombrepro, String costo, String cantidad) {
        this.codigopro = codigopro;
        this.codigofac = codigofac;
        this.nombrepro = nombrepro;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Detalle() {
    }
    
    
}
