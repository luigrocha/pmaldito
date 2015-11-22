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
public class Factura {
    private String codigo;
    private String codigocli;
    private String fecha;
    private String total;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigocli() {
        return codigocli;
    }

    public void setCodigocli(String codigocli) {
        this.codigocli = codigocli;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Factura(String codigo, String codigocli, String fecha, String total) {
        this.codigo = codigo;
        this.codigocli = codigocli;
        this.fecha = fecha;
        this.total = total;
    }

    public Factura() {
    }
    
}
