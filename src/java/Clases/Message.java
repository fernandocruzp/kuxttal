/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alumno
 */
public class Message {
    private String envia;
    private String to;
    private String content;

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFrom() {
        return envia;
    }

    public void setFrom(String from) {
        this.envia = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
