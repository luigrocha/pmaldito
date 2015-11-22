package com.espe.distribuidas.pmaldito.jclient;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TelnetNotificationHandler;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;

public class TelnetClientExample implements Runnable, TelnetNotificationHandler{
    static TelnetClient tc = null;
    public static void main(String[] args) throws Exception
    {
        String remoteip = "localhost";
        int remoteport = 4420;
        tc = new TelnetClient();

        TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler("VT100", false, false, true, false);
        EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true, false);
        SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true, true, true);
        try{
            tc.addOptionHandler(ttopt);
            tc.addOptionHandler(echoopt);
            tc.addOptionHandler(gaopt);
        }
        catch (InvalidTelnetOptionException e){
            System.err.println("Error registering option handlers: " + e.getMessage());
        }

        while (true){
            boolean end_loop = false;
            try
            {
                tc.connect(remoteip, remoteport);
                Thread reader = new Thread (new TelnetClientExample());
                tc.registerNotifHandler(new TelnetClientExample());
                System.out.println("INICIALIZACION DEL CLIENTE");
                reader.start();
                OutputStream outstr = tc.getOutputStream();
                byte[] buff = new byte[1024];
                System.err.println("buff:"+buff);
                int ret_read = 0;
                System.err.println("ret_read:"+ret_read);
                do{
                    try{
                        ret_read = System.in.read(buff);
                        System.err.println("ret_read:"+ret_read);
                        if(ret_read > 0){
                                try {
                                        outstr.write(buff, 0 , ret_read);
                                        outstr.flush();
                                        
                                }
                                catch (IOException e) {
                                        end_loop = true;
                                }
                            }
                    }
                    catch (IOException e){
                        System.err.println("se cerro las conecciones:" + e.getMessage());
                        end_loop = true;
                    }
                }
                while((ret_read > 0) && (end_loop == false));
                try{
                    tc.disconnect();
                }
                catch (IOException e){
                          System.err.println("Excepcion Al conectar:" + e.getMessage());
                }
            }
            catch (IOException e){
                    System.err.println("No se pudo conectar:" + e.getMessage());
                    System.exit(1);
            }
        }
    }
    @Override
    public void receivedNegotiation(int negotiation_code, int option_code)
    {
        String command = null;
        if(negotiation_code == TelnetNotificationHandler.RECEIVED_DO)
        {
            command = "DO";
        }
        else if(negotiation_code == TelnetNotificationHandler.RECEIVED_DONT)
        {
            command = "DONT";
        }
        else if(negotiation_code == TelnetNotificationHandler.RECEIVED_WILL)
        {
            command = "WILL";
        }
        else if(negotiation_code == TelnetNotificationHandler.RECEIVED_WONT)
        {
            command = "WONT";
        }
        System.out.println("Received " + command + " for option code " + option_code);
   }
    @Override
    public void run(){
        InputStream instr = tc.getInputStream();
        
        try{
            byte[] buff = new byte[1024];
            int ret_read = 0;
            do{
                ret_read = instr.read(buff);
                if(ret_read > 0){
                    System.out.print(new String(buff, 0, ret_read));
                }
            }
            while (ret_read >= 0);
        }
        catch (IOException e){
            System.err.println("Exception mientras se conecto al socket:" + e.getMessage());
        }
        try{
            tc.disconnect();
        }
        catch (IOException e){
            System.err.println("Exception while closing telnet:" + e.getMessage());
        }
    }   
}