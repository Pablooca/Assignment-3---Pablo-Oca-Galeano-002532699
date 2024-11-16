package Entities.centralDatabase;

/**
 *
 * @author pablo
 */
public class Warehouse {
    public int id;
    public String location;

    public Warehouse(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Warehouse\n" + "\n\tID ->" + id + "\n\tLocation -> " + location;
    }

    
    
}
