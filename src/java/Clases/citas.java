/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Controlador.Citas;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author cruzf
 */
public class citas {
    Connection con = null;
    Statement st;
    ResultSet rs;
    CallableStatement call;
    private ArrayList<Usuario>paciente=new ArrayList<Usuario>();
    Usuario usua;
    public ArrayList<Usuario>listapac(String id){
        ArrayList<Usuario>paciente1=new ArrayList<Usuario>();
        try{
            
            System.out.println("hola");
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select paciente.nombre_p, paciente.apellido_p, paciente.usuario_p, paciente.correo_p, paciente.e_cronica, paciente.telefono_p, paciente.seguridad_social, paciente.nac_p from paciente inner join paciente_citas on paciente.id_paciente=paciente_citas.id_paciente inner join medico_citas on medico_citas.id_cita=paciente_citas.id_cita inner join medico on medico.id_medico=medico_citas.id_medico where medico.usuario_m='"+id+"';");
            while(rs.next()){
                System.out.println("no señor");
                usua = new Usuario(rs.getString("nombre_p"),rs.getString("apellido_p"),rs.getString("correo_p"),"paciente",rs.getString("telefono_p"),rs.getString("e_cronica"),rs.getString("seguridad_social"),rs.getString("nac_p"),rs.getString("usuario_p"),"",2);
                paciente.add(usua);
            }
            String pac="";
            for(int i=0;i<paciente.size();i++){
                if(!paciente.get(i).getUsu().equals(pac)){
                    paciente1.add(paciente.get(i));
                }
                pac=paciente.get(i).getUsu();
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        if(paciente.isEmpty()){
            usua = new Usuario("-","-","-","-","-","-","-","-","-","-",0);
            paciente1.add(usua);
        }
        return paciente1;
    }
    public ArrayList<Usuario>listamed(String id){
        ArrayList<Usuario>paciente1=new ArrayList<Usuario>();
        try{
            System.out.println("hola");
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select medico.nombre_m, medico.apellido_m, medico.usuario_m, medico.correo_m, medico.especialidad, medico.telefono_m,medico.nac_m,medico.certificado from medico inner join medico_citas on medico.id_medico=medico_citas.id_medico inner join paciente_citas on paciente_citas.id_cita=medico_citas.id_cita inner join paciente on paciente.id_paciente=paciente_citas.id_paciente where paciente.usuario_p='"+id+"';");
            while(rs.next()){
                System.out.println("no señor");
                usua = new Usuario(rs.getString("nombre_m"),rs.getString("apellido_m"),rs.getString("correo_m"),"medico",rs.getString("telefono_m"),"","",rs.getString("nac_m"),rs.getString("usuario_m"),"",2);
                String especialidad=rs.getString("especialidad");
                byte[] certificado=rs.getBytes("certificado");
                usua.setEspecialidad(especialidad);
                usua.setCertificado(certificado);
                paciente.add(usua);
                System.out.println(paciente.get(0).getApellido());
            }
            String pac="";
            for(int i=0;i<paciente.size();i++){
                System.out.println("2"+paciente.get(i).getUsu());
                if(!paciente.get(i).getUsu().equals(pac)){
                    System.out.println("1"+pac);
                    paciente1.add(paciente.get(i));
                    System.out.println(paciente1.size());
                }
                pac=paciente.get(i).getUsu();
                System.out.println("3"+ pac);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        if(paciente.isEmpty()){
            usua = new Usuario("-","-","-","-","-","-","-","-","-","-",0);
            usua.setEspecialidad("-");
            usua.setCertificado(null);
            paciente1.add(usua);
        }
        return paciente1;
    }
    public void completar(String id_cita){
        try {
            con = Conexion.conectar();
            st=con.createStatement();
            st.executeUpdate("Update citas set estado='Completada' where id_cita="+id_cita+";");
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void aceptar(String id_cita){
        try {
            con = Conexion.conectar();
            st=con.createStatement();
            st.executeUpdate("Update citas set estado='Confirmada' where id_cita="+id_cita+";");
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void eliminar(String id_cita){
        try {
            con = Conexion.conectar();
            st=con.createStatement();
            st.executeUpdate("delete from citas where id_cita="+id_cita+";");
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void mandarcorreo(String ocasion, String correo_e, String correo_r, String usua){
        try{
            
                        Properties props = new Properties();
                        props.setProperty("mail.smtp.host", "smtp.gmail.com");
                        props.setProperty("mail.smtp.starttls.enable", "true");
                        props.setProperty("mail.smtp.port", "587");
                        props.setProperty("mail.smtp.auth", "true");
                        Session session = Session.getDefaultInstance(props);
                        
                        String correoRemitente= "kuxttalinc2@gmail.com";
                        String contraRemitente= "kuxttalinc123";
                        String correoReceptor= correo_r;
                        String asunto="";
                        String mensaje="";
                        if(ocasion.equals("cancela_c")){
                            System.out.println("jajaja");
                            asunto="Paciente : "+usua+" canceló su cita";
                            mensaje="EL paciente con correo "+correo_e+" canceló su cita con usted, favor de comunicarse con el para más información";
                        }
                        else if(ocasion.equals("cancela_m")){
                            System.out.println("medico");
                            asunto="Medico : "+usua+" canceló su cita";
                            mensaje="EL medico con correo "+correo_e+" canceló o rechazó su cita con usted, favor de comunicarse con el para más información";
                        }
                        else if(ocasion.equals("rechazo_m")){
                            asunto="Medico : "+usua+" rechazó su solicitud de cita";
                            mensaje="EL medico con correo "+correo_e+" rechazó su cita con usted, favor de comunicarse con el para más información";
                        }
                        MimeMessage message= new MimeMessage(session);
                        message.setFrom(new InternetAddress(correoRemitente));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                        message.setSubject(asunto);
                        message.setText(mensaje);

                        Transport t = session.getTransport("smtp");
                        t.connect(correoRemitente, contraRemitente);
                        t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                        t.close();

                    } catch (AddressException ex) {
                        
                    } catch (MessagingException ex) {
                        
                    }
    }
    public ArrayList<ArrayList<String>>medicos(){
        ArrayList<ArrayList<String>>listado=new ArrayList<ArrayList<String>>();
        
        try {
            String[][] esp={{"Neumólogo","Neumologo","Neumología","Neumologia"},{"Cardiólogo","Cardiologo","Cardiología","Cardiologia"},{"Gastroenterólogo","Gastroenterologo","Gastroenterología","Gastroenterologia"},
                {"Pediatra","Pediatría","Pediatria","pediatra"},{"General","general","Genrenal","genrenal"},{"Oncólogo","Oncología","Oncologo","Oncologia"},{"Traumatologia","Traumatología","Traumatólogo","Traumatologo"},
                {"Ginecólogo","Ginecologo","Ginecología","Ginecologia"},{"Internista","internista","interno","Interno"},{"Oftalmología","Oftalmólogo","Oftalmologia","Oftalmologo"}};
            con= Conexion.conectar();
            st=con.createStatement();
            for(int i=0;i<esp.length;i++){
                ArrayList<String>medicos=new ArrayList<>();
                rs=st.executeQuery("select nombre_m, apellido_m, usuario_m from medico where especialidad='"+esp[i][0]+"' or especialidad='"+esp[i][1]+"' or especialidad='"+esp[i][2]+"' or especialidad='"+esp[i][3]+"';");
                while(rs.next()){
                    //System.out.println(rs.getString("nombre_m"));
                    String nombre= rs.getString("nombre_m") + " "+ rs.getString("apellido_m");
                    medicos.add(nombre);
                   // System.out.println(nombre);
                }
                //System.out.println(medicos);
                //String[] nom=medicos.toArray(new String[medicos.size()]);
                //System.out.println("1"+nom[i]);
                listado.add(medicos);
                
                //System.out.println((listado.get(i)).get(0));
            }
            //System.out.println(listado.size());
            //System.out.println(listado.get(1).get(0));
            //System.out.println(listado.get(0).size());
            return listado;
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void nueva(String espe,String doctor,String fecha, String hora, String urgencia, String usu){
        try {
            String[] espec=new String[4];
            String[][] esp={{"Neumólogo","Neumologo","Neumología","Neumologia"},{"Cardiólogo","Cardiologo","Cardiología","Cardiologia"},{"Gastroenterólogo","Gastroenterologo","Gastroenterología","Gastroenterologia"},
                {"Pediatra","Pediatría","Pediatria","pediatra"},{"General","general","Genrenal","genrenal"},{"Oncólogo","Oncología","Oncologo","Oncologia"},{"Traumatologia","Traumatología","Traumatólogo","Traumatologo"},
                {"Ginecólogo","Ginecologo","Ginecología","Ginecologia"},{"Internista","internista","interno","Interno"},{"Oftalmología","Oftalmólogo","Oftalmologia","Oftalmologo"}};
            for(int i=0;i<esp.length;i++){
                for(int j=0;j<esp[i].length;j++){
                    System.out.println(espe+" "+esp[i][j]);
                    if(espe.equals(esp[i][j])){
                        espec=esp[i];
                    }
                }
            }
            System.out.println(espec[3]);
            int resultado;
            int id=0;
            String[] nombre= doctor.split(" ");
            int id_med=0;
            int id_cit=0;
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call nueva_cit(?,?,?)}");
            call.setString(1, fecha);
            call.setString(2, hora);
            call.setString(3, urgencia);
            resultado= call.executeUpdate();
            if(resultado!=0){
                String mensaje= "Hola " + doctor+ " ,soy "+ usu+" ,necesito una cita en la fecha "+fecha+ "a las"+hora;
                call= con.prepareCall("{call registro_chat(?)}");
                call.setString(1, mensaje);
                resultado= call.executeUpdate();
                resultado=0;
                System.out.println("logrado");
                Conexion.desconectar();
                rs=st.executeQuery("select id_paciente from paciente where usuario_p='"+usu+"';");
                while(rs.next())
                    id=rs.getInt("id_paciente");
                System.out.println(id);
                rs=st.executeQuery("select id_medico from medico where (nombre_m='"+nombre[0]+"' and especialidad='"+espec[0]+"' and apellido_m='"+nombre[1]+"') or (nombre_m='"+nombre[0]+"' and especialidad='"+espec[1]+"' and apellido_m='"+nombre[1]+"') or (nombre_m='"+nombre[0]+"' and especialidad='"+espec[2]+"' and apellido_m='"+nombre[1]+"') or (nombre_m='"+nombre[0]+"' and especialidad='"+espec[3]+"' and apellido_m='"+nombre[1]+"');");
                while(rs.next())
                    id_med=rs.getInt("id_medico");
                System.out.println(id_med);
                rs=st.executeQuery("select id_cita from citas where fecha_registro='"+fecha+"' and urgencia='"+urgencia+"' and horario='"+hora+"' and estado='En_espera';");
                while(rs.next())
                    id_cit=rs.getInt("id_cita");
                System.out.println(id_cit);
                call = con.prepareCall("{call pac_cit(?,?)}");
                call.setInt(1, id);
                call.setInt(2, id_cit);
                resultado= call.executeUpdate();
                if(resultado!=0){
                    System.out.println("laslas");
                    call = con.prepareCall("{call med_cit(?,?)}");
                    call.setInt(1, id_med);
                    call.setInt(2, id_cit);
                    resultado=call.executeUpdate();
                    if(resultado!=0){
                        int id_chat=0;
                        rs=st.executeQuery("select id_mensaje from mensajes where mensaje='"+mensaje+"';");
                        while(rs.next())
                            id_chat=rs.getInt("id_mensaje");
                        call = con.prepareCall("{call med_chat(?,?)}");
                        call.setInt(1, id_med);
                        call.setInt(2, id_chat);
                        call.executeUpdate();
                        call = con.prepareCall("{call pac_chat(?,?)}");
                        call.setInt(1, id);
                        call.setInt(2, id_chat);
                        call.executeUpdate();
                    }
                }
            }   
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Documento> listardoc(String usua){
        try {
            ArrayList<Documento>doc=new ArrayList<Documento>();
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select medico.usuario_m, documentos.nombre_documento, documentos.id_documento from medico inner join documento_medico on medico.id_medico=documento_medico.id_medico inner join documentos on documentos.id_documento=documento_medico.id_documento inner join documento_paciente on documentos.id_documento=documento_paciente.id_documento inner join paciente on paciente.id_paciente=documento_paciente.id_paciente where paciente.usuario_p='"+usua+"';");
            while(rs.next()){
                Documento doci= new Documento();
                System.out.println("si señor");
                System.out.println(rs.getString("nombre_documento"));
                doci.setDoctor(rs.getString("usuario_m"));
                doci.setNombre(rs.getString("nombre_documento"));
                doci.setUsua(usua);
                doci.setDoc(rs.getInt("id_documento"));
                System.out.println(doci.getNombre());
                doc.add(doci);
            }
            //System.out.println(doc.get(1).getNombre());
            return doc;
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<Documento> listardoc1(String usua){
        try {
            ArrayList<Documento>doc=new ArrayList<Documento>();
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select paciente.usuario_p, documentos.nombre_documento, documentos.id_documento from paciente inner join documento_paciente on paciente.id_paciente=documento_paciente.id_paciente inner join documentos on documentos.id_documento=documento_paciente.id_documento inner join documento_medico on documentos.id_documento=documento_medico.id_documento inner join medico on medico.id_medico=documento_medico.id_medico where medico.usuario_m='"+usua+"';");
            while(rs.next()){
                Documento doci= new Documento();
                System.out.println("si señor");
                System.out.println(rs.getString("nombre_documento"));
                doci.setDoctor(rs.getString("usuario_p"));
                doci.setNombre(rs.getString("nombre_documento"));
                doci.setUsua(usua);
                doci.setDoc(rs.getInt("id_documento"));
                System.out.println(doci.getNombre());
                doc.add(doci);
            }
            //System.out.println(doc.get(1).getNombre());
            return doc;
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Receta> listarRec(String usua){
        try {
            ArrayList<Receta>doc=new ArrayList<Receta>();
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select paciente.usuario_p, receta.fecha_emision, receta.id_receta from paciente inner join paciente_receta on paciente.id_paciente=paciente_receta.id_paciente inner join receta on receta.id_receta=paciente_receta.id_receta inner join medico_receta on receta.id_receta=medico_receta.id_receta inner join medico on medico.id_medico=medico_receta.id_medico where medico.usuario_m='"+usua+"';");
            while(rs.next()){
                Receta doci= new Receta();
                System.out.println("si señor");
                System.out.println(rs.getString("fecha_emision"));
                doci.setDoctor(rs.getString("usuario_p"));
                doci.setFecha(rs.getString("fecha_emision"));
                doci.setUsua(usua);
                doci.setDoc(rs.getInt("id_receta"));
                System.out.println(doci.getFecha());
                doc.add(doci);
            }
            //System.out.println(doc.get(1).getNombre());
            return doc;
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<Receta> listarRec1(String usua){
        try {
            ArrayList<Receta>doc=new ArrayList<Receta>();
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select medico.usuario_m, receta.fecha_emision, receta.id_receta from paciente inner join paciente_receta on paciente.id_paciente=paciente_receta.id_paciente inner join receta on receta.id_receta=paciente_receta.id_receta inner join medico_receta on receta.id_receta=medico_receta.id_receta inner join medico on medico.id_medico=medico_receta.id_medico where paciente.usuario_p='"+usua+"';");
            while(rs.next()){
                Receta doci= new Receta();
                System.out.println("si señor");
                System.out.println(rs.getString("fecha_emision"));
                doci.setDoctor(rs.getString("usuario_m"));
                doci.setFecha(rs.getString("fecha_emision"));
                doci.setUsua(usua);
                doci.setDoc(rs.getInt("id_receta"));
                System.out.println(doci.getFecha());
                doc.add(doci);
            }
            //System.out.println(doc.get(1).getNombre());
            return doc;
        } catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<UsChat>listarcont(String usua){
        ArrayList<UsChat>doc=new ArrayList<UsChat>();
        ArrayList<UsChat>doc1=new ArrayList<UsChat>();
        try{
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select medico.usuario_m, medico.id_medico from paciente inner join mensaje_paciente on paciente.id_paciente=mensaje_paciente.id_paciente inner join mensajes on mensajes.id_mensaje=mensaje_paciente.id_mensaje inner join mensaje_medico on mensaje_medico.id_mensaje=mensajes.id_mensaje inner join medico on medico.id_medico=mensaje_medico.id_medico where paciente.usuario_p='"+usua+"';");
            while(rs.next()){
                UsChat doci= new UsChat();
                System.out.println("si señor");
                doci.setUsu(rs.getString("usuario_m"));
                doci.setId(rs.getInt("id_medico"));
                doc.add(doci);
            }
            String pac="";
            for(int i=0;i<doc.size();i++){
                if(!doc.get(i).getUsu().equals(pac)){
                    doc1.add(doc.get(i));
                }
                pac=doc.get(i).getUsu();
            }
            //System.out.println(doc.get(1).getNombre());
            return doc1;
        }catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<UsChat>listarcont1(String usua){
        ArrayList<UsChat>doc=new ArrayList<UsChat>();
        ArrayList<UsChat>doc1=new ArrayList<UsChat>();
        try{
            con= Conexion.conectar();
            st=con.createStatement();
            rs=st.executeQuery("select paciente.usuario_p, paciente.id_paciente from paciente inner join mensaje_paciente on paciente.id_paciente=mensaje_paciente.id_paciente inner join mensajes on mensajes.id_mensaje=mensaje_paciente.id_mensaje inner join mensaje_medico on mensaje_medico.id_mensaje=mensajes.id_mensaje inner join medico on medico.id_medico=mensaje_medico.id_medico where medico.usuario_m='"+usua+"';");
            while(rs.next()){
                UsChat doci= new UsChat();
                System.out.println("si señor");
                doci.setUsu(rs.getString("usuario_p"));
                doci.setId(rs.getInt("id_paciente"));
                doc.add(doci);
            }
            String pac="";
            for(int i=0;i<doc.size();i++){
                if(!doc.get(i).getUsu().equals(pac)){
                    System.out.println("1"+pac);
                    doc1.add(doc.get(i));
                    System.out.println(doc1.size());
                }
                pac=doc.get(i).getUsu();
                System.out.println("3"+ pac);
            }
            //System.out.println(doc.get(1).getNombre());
            return doc1;
        }catch (SQLException ex) {
            Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
