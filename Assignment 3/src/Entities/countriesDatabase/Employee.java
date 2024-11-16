package Entities.countriesDatabase;

/**
 *
 * @author pablo
 */
public class Employee {
    public int id;
    public String name;
    public String surname;
    public Gym gym;

    public Employee(int id, String name, String surname, Gym gym) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gym = gym;
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

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "Employee " + "\n\t Id ->" + id + "\n\t Name ->" + name + " " + surname + "\n\t Gym ->" + gym;
    }
    
    
    
}
