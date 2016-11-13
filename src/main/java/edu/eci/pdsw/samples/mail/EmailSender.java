package edu.eci.pdsw.samples.mail;

import javax.mail.MessagingException;

public interface EmailSender {

    void send(Email email) throws MessagingException;

}
