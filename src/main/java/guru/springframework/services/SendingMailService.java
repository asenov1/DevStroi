package guru.springframework.services;

public interface SendingMailService {
    boolean sendMail(String subject, String body);
}

