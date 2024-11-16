package Entities.centralDatabase;

/**
 *
 * @author pablo
 */
public class Supplier {
    public int id;
    public String name;
    public String country;
    public String phoneNumber;
    public String email;
    public String paymentType;

    public Supplier(int id, String name, String country, String phoneNumber, String email, String paymentType) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.paymentType = paymentType;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Supplier" + "\n\t Id -> " + id + "\n\t Name -> " + name + "\n\t Country -> " + country + "\n\t Phone Number -> " + phoneNumber + "\n\t Email -> " + email + "\n\t Payment Type -> " + paymentType;
    }
    
    
    
}
