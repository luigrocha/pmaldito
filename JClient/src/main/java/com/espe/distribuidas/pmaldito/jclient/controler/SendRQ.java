package com.espe.distribuidas.pmaldito.jclient.controler;
import com.espe.distribuidas.pmaldito.originador.Originador;
import com.espe.distribuidas.pmaldito.pcs.Mensaje;
import com.espe.distribuidas.pmaldito.pcs.MensajeRQ;
import com.espe.distribuidas.pmaldito.seguridad.AutenticacionRQ;
public class SendRQ {
    public String construirMensaje(Login lo, String tipoMensaje) {
        AutenticacionRQ rq = new AutenticacionRQ();
        rq.setUsuario(lo.getUsuario());
        rq.setClave(lo.getClave());
        MensajeRQ msrq = new MensajeRQ(Originador.getOriginador(Originador.CLIENTE), Mensaje.AUTENTIC_USER);
        msrq.setCuerpo(rq);
        return msrq.asTexto();
    }
    public String insertarCliente(Login lo, String tipoMensaje) {
        AutenticacionRQ rq = new AutenticacionRQ();
        rq.setUsuario(lo.getUsuario());
        rq.setClave(lo.getClave());
        MensajeRQ msrq = new MensajeRQ(Originador.getOriginador(Originador.CLIENTE), Mensaje.AUTENTIC_USER);
        msrq.setCuerpo(rq);
        return msrq.asTexto();
    }
    
}
