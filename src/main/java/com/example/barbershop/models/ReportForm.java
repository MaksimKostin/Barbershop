package com.example.barbershop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Table(name = "Reports")
public class ReportForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @NotEmpty(message = "Заполните поле с именем")
    @Size(min = 2, max = 50, message = "Имя должно быть больше 2 и меньше 50 символов")
    private String name;
    @NotEmpty(message = "Заполните поле с email")
    @Email(message = "Невалидный email")
    private String email;
    @NotEmpty(message = "Заполните поле с темой")
    @Size(min = 2, max = 50, message = "Тема должна быть больше 2 и меньше 50 символов")
    private String subject;
    @NotEmpty(message = "Заполните поле с сообщением")
    @Size(min = 2, message = "Сообщение должно быть больше 2 символов")
    private String message;

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
