package com.espe.distribuidas.pmaldito.jclient.controler;

import com.espe.distribuidas.pmaldito.jclient.LoginView;
import com.espe.distribuidas.pmaldito.pcs.Mensaje;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
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
        comunicacion = new Socket(ClienteSocket.IP,4228);
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
            System.out.println("Respuesta desde Cliente: ");
            String RS=input.readUTF();
            if(Mensaje.validaHash(RS)){
            if("OK".equals(RS.substring(85))){
                JOptionPane.showMessageDialog(null,"Se conecto correctamente");
                return true;       
            }
            else{System.err.println(""+RS);
            JOptionPane.showMessageDialog(null,"Usuario y/o contreseña incorrectos");    
            return false;
            }
            }
            else{System.err.println(""+RS);
            JOptionPane.showMessageDialog(null,"Usuario y/o contreseña incorrectos intente nuevamente");    
            return false;
            }
        } catch (IOException ex) {
            System.out.println("Error...." + ex);
        }
        return false;
        
    }
    
}
