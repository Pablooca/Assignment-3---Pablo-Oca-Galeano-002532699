package Entities.centralDatabase;

import java.util.Date;

/**
 *
 * @author pablo
 */
public class Shipment {
    public int id;
    public String address;
    public Date date;
    public String trackingNumber;
    public Date deliveryDate;

    public Shipment(int id, String address, Date date, String trackingNumber, Date deliveryDate) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.trackingNumber = trackingNumber;
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Shipment" + "\n\t Id -> " + id + "\n\t Address -> " + address + "\n\t Date " + date + "\n\t TrackingNumber -> " + trackingNumber + "\n\t DeliveryDate -> " + deliveryDate;
    }
    
    
    
}
