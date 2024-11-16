package Entities.countriesDatabase;

import java.util.Date;

/**
 *
 * @author pablo
 */
public class Client {
    public int id;
    public String name;
    public String surname;
    public Date birth_date;
    public String city;
    public String phone_number;
    public String email;
    public Date inscription_date;
    public String membership_type;
    public String payment_method;

    public Client(int id, String name, String surname, Date birth_date, String city, String phone_number, String email, Date inscription_date, String membership_type, String payment_method) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.city = city;
        this.phone_number = phone_number;
        this.email = email;
        this.inscription_date = inscription_date;
        this.membership_type = membership_type;
        this.payment_method = payment_method;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInscription_date() {
        return inscription_date;
    }

    public void setInscription_date(Date inscription_date) {
        this.inscription_date = inscription_date;
    }

    public String getMembership_type() {
        return membership_type;
    }

    public void setMembership_type(String membership_type) {
        this.membership_type = membership_type;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return "Client" + "\n\t Id -> " + id + "\n\t Name -> " + name + " " + surname + "\n\t Birth Date -> " + birth_date + "\n\t City -> " + city + "\n\t Phone Number -> " + phone_number + "\n\t Email ->" + email + "\n\t Inscription Date -> " + inscription_date + "\n\t Membership Type ->" + membership_type + "\n\t Payment Method ->" + payment_method;
    }
    
    
    
}
