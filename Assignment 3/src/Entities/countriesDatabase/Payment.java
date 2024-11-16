package Entities.countriesDatabase;

import java.util.Date;

/**
 *
 * @author pablo
 */
public class Payment {
    public int id;
    public Client client;
    public Date payment_day;
    public float amount;
    public String method;

    public Payment(int id, Client client, Date payment_day, float amount, String method) {
        this.id = id;
        this.client = client;
        this.payment_day = payment_day;
        this.amount = amount;
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getPayment_day() {
        return payment_day;
    }

    public void setPayment_day(Date payment_day) {
        this.payment_day = payment_day;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Payment" + "\n\t Id -> " + id + "\n\t Client -> " + client + "\n\t Payment Day -> " + payment_day + "\n\t Amount -> " + amount + "\n\t Method -> " + method + '}';
    }
    
    
    
}
