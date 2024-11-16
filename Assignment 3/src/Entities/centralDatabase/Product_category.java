package Entities.centralDatabase;

/**
 *
 * @author pablo
 */
public class Product_category {
    public int id;
    public String name;
    public String description;

    /*
        This constructor is used when the database is read.
    */
    public Product_category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product_category" + "\n\t Id -> " + id + "\n\t Name -> " + name + "\n\t Description ->" + description;
    }
    
    
    
}
