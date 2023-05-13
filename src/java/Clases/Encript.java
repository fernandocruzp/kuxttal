package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author cruzf
 */
public class Encript {
    
    public Key crearClave(String clave) throws Exception{
        // keyGenerator = KeyGenerator.getInstance("AES");
        Key key = new SecretKeySpec(clave.getBytes(),0,16,"AES");
        return key;
    }
    public byte[]encriptar(String texto, Key llave)throws Exception{
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aes.init(Cipher.ENCRYPT_MODE, llave);
        byte[] encriptado = aes.doFinal(texto.getBytes());
        return encriptado;
    }
    public byte[]desencriptar(byte[] texto, Key llave)throws Exception{
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aes.init(Cipher.DECRYPT_MODE, llave);
        byte[] encriptado = aes.doFinal(texto);
        return encriptado;
    }
}