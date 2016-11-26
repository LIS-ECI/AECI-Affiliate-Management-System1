/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import edu.eci.pdsw.samples.mail.Email;
import edu.eci.pdsw.samples.mail.EmailConfiguration;
import edu.eci.pdsw.samples.mail.EmailSender;
import edu.eci.pdsw.samples.mail.SimpleEmail;
import edu.eci.pdsw.samples.mail.SimpleEmailSender;
import javax.mail.MessagingException;

/**
 *
 * @author Grupo 3 Pdsw
 */
public class Correo {
    
    String from;
    String to;
    String subject;
    String message;
    
    /**
    * Constructor Clase Correo
    */
    public Correo(){
        from = "me@gmail.com";
        to = "test@gmail.com";
        subject = "test";
        message = "test";
    }
    
    
    /**
    *  Metodo que sirve para enviar un correo
    */
    public void enviarCorreo(){
        Email email = new SimpleEmail(from, to, subject, message);
        EmailSender sender = new SimpleEmailSender(new EmailConfiguration());
        try {
            sender.send(email);
            System.out.println("Sent message successfully!");
        } 
        catch (MessagingException e) {
            System.err.println("Message not sent!");
            e.printStackTrace();
        }
    }
    
    public void setMessage(String mensaje){
        this.message = mensaje;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public void setSubject(String asunto){
        this.subject = asunto;
    }
    
    public String getSubject(){
        return this.subject;
    }
    
    public void setTo(String para){
        this.to = para;
    }
    
    public String getTo(){
        return this.to;
    }
    
}
