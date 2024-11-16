package Entities.countriesDatabase;

import java.util.Date;

/**
 *
 * @author pablo
 */
public class Appointment {
    public int id;
    public Client client;
    public Employee employee;
    public Date date_hour;
    public int length;
    public String type;

    public Appointment(int id, Client client, Employee employee, Date date_hour, int length, String type) {
        this.id = id;
        this.client = client;
        this.employee = employee;
        this.date_hour = date_hour;
        this.length = length;
        this.type = type;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(Date date_hour) {
        this.date_hour = date_hour;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Appointment" + "\n\t Id ->" + id + "\n\t Client ->" + client + "\n\t Employee -> " + employee + "\n\t Date and Hour -> " + date_hour + "\n\t Length -> " + length + "\n\t Type ->" + type;
    }
    
    
    
}
