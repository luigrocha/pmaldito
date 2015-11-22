/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.pmaldito.jclient.controler;

import com.espe.distribuidas.pmaldito.originador.Originador;
import com.espe.distribuidas.pmaldito.pcs.Mensaje;
import com.espe.distribuidas.pmaldito.pcs.MensajeRQ;
import com.espe.distribuidas.pmaldito.seguridad.AutenticacionRQ;

/**
 *
 * @author Luig Rocha
 */
public class SendRQ {
    public String construirMs(Usuario usu){
        AutenticacionRQ aurq=new AutenticacionRQ();
        aurq.setUsuario(usu.getUsuario());
        aurq.setClave(usu.getClave());
        MensajeRQ rq=new MensajeRQ(Originador.getOriginador(Originador.CLIENTE), Mensaje.AUTENTIC_USER);
        rq.setCuerpo(aurq);
        return rq.asTexto();
    }
    
}
