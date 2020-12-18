package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    public void send(Product product){
        System.out.println("sending email: " + product);
    }
}
