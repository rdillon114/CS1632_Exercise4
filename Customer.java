
/**
 *
 * @author Richard Dillon
 */
public class Customer {
    private String firstName;
    private String lastName;
    private int customerID;
    
    public Customer(int ID, String first, String last) {
        customerID = ID;
        firstName = first;
        lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCustomerID() {
        return customerID;
    }
}
