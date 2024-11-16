package Entities.centralDatabase;

/**
 *
 * @author pablo
 */
public class Product {
    public int id;
    public float price;
    public String description;
    public Warehouse warehouse;
    public Product_category category;
    public Supplier supplier;

    public Product(int id, float price, String description, Warehouse warehouse, Product_category category, Supplier supplier) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.warehouse = warehouse;
        this.category = category;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product_category getCategory() {
        return category;
    }

    public void setCategory(Product_category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product" + "\n\t Id -> " + id + "\n\t Price ->" + price + "\n\t Description -> " + description + "\n\t Warehouse ->" + warehouse + "\n\t Category ->" + category + "\n\t Supplier -> " + supplier;
    }
    
    
    
}
