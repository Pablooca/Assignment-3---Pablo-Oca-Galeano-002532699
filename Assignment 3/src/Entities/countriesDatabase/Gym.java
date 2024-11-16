package Entities.countriesDatabase;

/**
 *
 * @author pablo
 */
public class Gym {
    public int id;
    public String name;
    public String address;
    public String city;
    public String phone_number;
    public String email;
    public String schedule;
    public int max_capacity;

    public Gym(int id, String name, String address, String city, String phone_number, String email, String schedule, int max_capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone_number = phone_number;
        this.email = email;
        this.schedule = schedule;
        this.max_capacity = max_capacity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    @Override
    public String toString() {
        return "Gym" + "\n\tID -> " + id + "\n\tName -> " + name + "\n\tAddress ->" + address
                + "\n\tCity -> " + city + "\n\t Phone Number -> " + phone_number + "\n\tEmail -> " 
                + email + "\n\tSchedule ->" + schedule + "\n\tMax Capacity -> " + max_capacity;
    }
    
    
}
