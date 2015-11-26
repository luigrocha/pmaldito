/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.jclient.controler;

import com.espe.distribuidas.pmaldito.jclient.LoginView;
import com.espe.distribuidas.pmaldito.pcs.Mensaje;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ClienteSocket {

    private static final String IP = "localhost";
    DataInputStream input = null;
    DataOutputStream output = null;
    Socket comunicacion = null;
    LoginView v;

    public void Cliente(LoginView v) {
        this.v = v;
    }

    public void conexio() throws IOException {
        comunicacion = new Socket(ClienteSocket.IP, 4228);//4228
        input = new DataInputStream(comunicacion.getInputStream());
        output = new DataOutputStream(comunicacion.getOutputStream());
        //String trama = input.readUTF();
    }

    public void flujo(String trama) {
        try {
            System.out.println("Mensaje desde Cliente: " + trama);
            output.writeUTF(trama);

        } catch (IOException ex) {
            System.out.println("Error...." + ex);
        }
    }

    public boolean flujoRS() {
        try {

            System.out.println("Mensaje desde Servidor: ");
            String trama = input.readUTF();
            System.out.println("Mensaje desde Servidor: " + trama);
            if (Mensaje.validaHash(trama)) {
                if ("OK".equals(trama.substring(85))) {
                    JOptionPane.showMessageDialog(null, "Ingreso Correcto");
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println("Error...." + ex);
            JOptionPane.showMessageDialog(null, "Ingreso Incorrecto, intente nuevamente");
            return false;
        }
        return false;
    }

    public String[] flujoRSc() {
        try {
            System.out.println("Mensaje desde INFOCLIENTE:");
            output.flush();
            String trama = input.readUTF();
            System.out.println("INFO CLIENTE...." + trama);
            if (Mensaje.validaHash(trama)) {
                System.out.println("INFO CLIENTE...." + trama.substring(85, 88));
                if ("BAD".equals(trama.substring(85, 88))) {
                    JOptionPane.showMessageDialog(null, "No exite Cliente");
                }
                System.out.println("AQUI...." + trama.substring(85, 88));
                if ("OKO".equals(trama.substring(85, 88))) {
                    // if("OKO".equals(trama.substring(85,88))){
                    String[] arr1 = trama.split("OKO_");
                    String[] arr2 = arr1[1].split("-");
                    for (int i = 0; i < arr2.length; i++) {
                        System.out.println(arr2[i]);
                    }
                    JOptionPane.showMessageDialog(null, "Se encotro el registro!");
                    return arr2;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay registros, ingrese un nuevo cliente!");
            }
        } catch (IOException ex) {
            System.out.println("Error...." + ex);
            JOptionPane.showMessageDialog(null, "Ingreso Incorrecto, intente nuevamente");
            return null;
        }
        return null;
    }

    public String[] flujoRSp() {
        try {
            System.out.println("Mensaje desde INFOPRODUCTO:");
            output.flush();
            String trama = input.readUTF();
            System.out.println("INFO INFOPRODUCTO...." + trama);
            //if(Mensaje.validaHash(trama)){
            System.out.println("INFO INFOPRODUCTO...." + trama.substring(85, 88));

            if ("BAD".equals(trama.substring(85, 88))) {
                JOptionPane.showMessageDialog(null, "No exite producto");
            }
            if ("OKO".equals(trama.substring(85, 88))) {
                String[] arr1 = trama.split("OKO_");
                String[] arr2 = arr1[1].split("-");
                for (int i = 0; i < arr2.length; i++) {
                    System.out.println(arr2[i]);
                }
                JOptionPane.showMessageDialog(null, "Se recibio producto");
                return arr2;
            }
            //}   
        } catch (IOException ex) {
            System.out.println("Error...." + ex);
            JOptionPane.showMessageDialog(null, "Ingreso Incorrecto, intente nuevamente");
            return null;
        }
        return null;
    }

    public String[] flujoRSf() {
        try {
            System.out.println("Mensaje desde INFOFACTURA:");
            output.flush();
            String trama = input.readUTF();
            System.out.println("INFOFACTURA...." + trama);
            if (Mensaje.validaHash(trama)) {
                System.out.println("INFOFACTURA...." + trama.substring(85, 88));
                if ("BAD".equals(trama.substring(85, 88))) {
                    JOptionPane.showMessageDialog(null, "No exite factura");
                }
                System.out.println("AQUI...." + trama.substring(85, 88));
                if ("OKO".equals(trama.substring(85, 88))) {
                    // if("OKO".equals(trama.substring(85,88))){
                    String[] arr1 = trama.split("OKO_");
                    String[] arr2 = arr1[1].split("-");
                    for (int i = 0; i < arr2.length; i++) {
                        System.out.println(arr2[i]);
                    }
                    JOptionPane.showMessageDialog(null, "Se encotro el registro!");
                    return arr2;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay registros, ingrese un nuevo cliente!");
            }
        } catch (IOException ex) {
            System.out.println("Error...." + ex);
            JOptionPane.showMessageDialog(null, "Ingreso Incorrecto, intente nuevamente");
            return null;
        }
        return null;
    }

}
