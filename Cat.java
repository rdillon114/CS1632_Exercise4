
/**
 *
 * @author Richard Dillon
 */
public class Cat {
    private String name;
    private double cost;
    private int catID;
    private boolean rented; //is the cat currently being rented?
    private int customerID; //id of the customer being rented this cat.
    
    public Cat(int catID, double cost, String name) {
        this.catID = catID;
        this.cost = cost;
        this.name = name;
        rented = false;
    }
    
    public boolean rentCat(int customerID) {
        if(rented == true) {
            return false;
        }
        else {
            rented = true;
            this.customerID = customerID;
            return true;
        }
        
    }
    
    public boolean returnCat() {
        if(rented == false) {
            return false;
        }
        else {
            rented = false;
            this.customerID = 0;
            return true;
        }
    }
    
    @Override
    public String toString() {
        return "ID " + catID + ". " + name + ": $" + cost + " / day";
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCatID() {
        return catID;
    }

    public boolean isRented() {
        return rented;
    }

    public int getCustomerID() {
        return customerID;
    }
    
    
}
