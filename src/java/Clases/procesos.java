/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author cruzf
 */
public class procesos {
    
    public String byteahexa(byte bit){
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((bit >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((bit & 0xF), 16);
        return new String(hexDigits);
    }
    public String grupobyteahexa(byte[] arreglo){
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < arreglo.length; i++) {
            hexStringBuffer.append(byteahexa(arreglo[i]));
        }
        return hexStringBuffer.toString();
    }
    public byte[] arreglobytes(String palabra){
        if (palabra.length() % 2 == 1) {
        throw new IllegalArgumentException(
          "Invalid hexadecimal String supplied.");
    }
        byte[] bytes = new byte[palabra.length() / 2];
        for (int i = 0; i < palabra.length(); i += 2) {
            bytes[i / 2] = hexaabyte(palabra.substring(i, i + 2));
        }
        return bytes;
    }
    public byte hexaabyte(String palabra){
        int primero = anum(palabra.charAt(0));
        int segundo = anum(palabra.charAt(1));
        return (byte) ((primero << 4) + segundo);
    }
    public int anum(char letra){
        int num = Character.digit(letra, 16);
        if(num == -1) {
            throw new IllegalArgumentException(
          "Invalid Hexadecimal Character: "+ letra);
        }
        return num;
    }
}
