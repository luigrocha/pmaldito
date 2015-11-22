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
    private static final  String IP = "192.168.1.101";
    DataInputStream input = null;
    DataOutputStream output = null;
    Socket comunicacion = null;
    LoginView v;
    
    public void Cliente(LoginView v){
        this.v = v;
    }
    
    public void conexio() throws IOException{
        comunicacion = new Socket(ClienteSocket.IP,4228);//4228
        input = new DataInputStream(comunicacion.getInputStream());
        output = new DataOutputStream(comunicacion.getOutputStream());
        //String trama = input.readUTF();
    }
    
    public void flujo(String trama){
        try {
            System.out.println("Mensaje desde Cliente: "+trama);
            output.writeUTF(trama);
        } catch (IOException ex) {
            System.out.println("Error...." + ex);
        }
    }
    public boolean flujoRS(){
        try {
           
            System.out.println("Mensaje desde Cliente: ");
            String trama=input.readUTF();
            if(Mensaje.validaHash(trama)){
               if("OK".equals(trama.substring(85))){
            JOptionPane.showMessageDialog(null, "Ingreso Correcto");
            return true;
               } 
           }   
        }catch (IOException ex) {
            System.out.println("Error...." + ex);
            JOptionPane.showMessageDialog(null, "Ingreso Incorrecto, intente nuevamente");
            return false;
        }
        return false;
    }
    
}
