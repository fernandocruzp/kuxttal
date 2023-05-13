/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/**
 *
 * @author cruzf
 */
public class procesoker {
    
    Encript encripta=new Encript();
    procesos procesa= new procesos();
    public String autentificador(String id,Date t3,String clave) throws Exception{
        String autentifica= id+","+t3;
        Key llave=encripta.crearClave(clave);
        byte[] autentificacif=encripta.encriptar(autentifica, llave);
        String autentificafin=procesa.grupobyteahexa(autentificacif);
        return autentificafin;
    }
    public String generaticket(String clavectg, String Idc, String Idtgs, Date t2, String clave) throws Exception{
        String ticket=""; 
        ticket=clavectg+","+Idc+","+Idtgs+","+String.valueOf(t2);
        Encript encripta=new Encript();
        Key llave= encripta.crearClave(clave);
        byte[] ticketcif= encripta.encriptar(ticket, llave);
        String ticketfin=procesa.grupobyteahexa(ticketcif);
        return ticketfin;
    }
    
    public String abrirticket(String clave, String ticket) throws Exception{
        Key llave= encripta.crearClave(clave);
        byte[] ticketori= procesa.arreglobytes(ticket);
        byte[] ticketor=encripta.desencriptar(ticketori,llave);
        String ticketor1=new String(ticketor);
        return ticketor1;
    }
    public String encriptaenvio(String clave, String ticket) throws Exception{
        Key llave= encripta.crearClave(clave);
        return procesa.grupobyteahexa(encripta.encriptar(ticket,llave));
    }
    public String getHash(String txt) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("SHA1");
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
