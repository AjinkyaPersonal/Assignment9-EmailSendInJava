package org.geekster;


public class Main {

    public static void main(String[] args) {
        System.out.println("The application is supposed to send mails");
        for(int i=0 ; i<2 ; i++){
            HandleMail mailer = new HandleMail();
            mailer.sendMail();
            System.out.println("Mail send successfully ");

        }
    }
}
