/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Nota {

    String id, nota, fecha;
    private Object vClienteFechaSQL;
    private Object fechaSQL;

    public Nota() {
    }

    public Nota(String id, String nota, String fecha) {
        this.id = id;
        this.nota = nota;
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaSQL() throws ParseException {
        Date ahora=new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha=formateador.format(ahora);;
        return fecha;
    }

    public int getAno() {
        String vFechaOK = new SimpleDateFormat("yyyy").format(this.vClienteFechaSQL);
        return Integer.parseInt(vFechaOK);
    }

    public int getMes() {
        String vFechaOK = new SimpleDateFormat("MM").format(this.vClienteFechaSQL);
        return Integer.parseInt(vFechaOK);
    }

    public int getDia() {
        String vFechaOK = new SimpleDateFormat("dd").format(this.vClienteFechaSQL);
        return Integer.parseInt(vFechaOK);
    }
}