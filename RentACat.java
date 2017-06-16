
import java.util.Scanner;

/**
 *
 * @author Richard Dillon
 */
public class RentACat {
    public static Cat[] cats = new Cat[3];
    public static Customer[] custs = new Customer[3];
    public static void main(String[] args) {
        new RentACat();
        int input = 0;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Option [1,2,3,4] > ");
            try {
                input = in.nextInt();
                if(input == 1) {//list cats.
                    System.out.println("Cats for Rent");
                    boolean result = listCats();
                    if(result == false) {
                        System.out.println("There are no cats to rent at this time.");
                    }
                }
                else if(input == 2) {//rent a cat.
                    System.out.print("Customer ID > ");
                    int custID = in.nextInt();
                    Customer cust = getCustomer(custID);

                    if(cust != null) {
                        System.out.print("Rent which cat? > ");
                        int catID = in.nextInt();
                        Cat cat = getCat(catID);

                        if(cat != null) {
                            if(rent(cat, cust)) {
                                System.out.println(cat.getName() + " has been rented to Customer " + cust.getFirstName() + " " + cust.getLastName() + ".");
                            }
                            else {
                                System.out.println("Sorry, " + cat.getName() + " is not here!");
                            }
                        }
                        else {
                            System.out.println("Invalid cat ID.");
                        }
                    }
                    else {
                        System.out.println("That customer doesn't exist!");
                    }
                }
                else if(input == 3) {//return a cat.
                    System.out.print("Return which cat? > ");
                    int catID = in.nextInt();
                    Cat cat = getCat(catID);
                    Customer cust = getCustomer(cat.getCustomerID());
                    if(cat != null) {
                        if(returnCat(cat)) {
                            System.out.println(cust.getFirstName() + " " + cust.getLastName() + " paid $" + cat.getCost() + ".");
                            System.out.println("Welcome back, " + cat.getName() + "!");
                        }
                        else {
                            System.out.println("Cat has not been rented out.");
                        }
                    }
                    else {
                        System.out.println("Invalid cat ID.");
                    }
                }
                else if(input == 4) {//exit.
                    break;
                }
                else {
                    System.out.println("Invalid input.");
                }
            }
            catch(Exception ex) {
                System.out.println("Invalid input.");
                in.nextLine();
            }
        }

        System.out.println("Closing up shop for the day!");
        
    }
    
    public RentACat() {
        cats[0] = new Cat(1, 100.0, "Fruity");
        cats[1] = new Cat(2, 200.0, "Loopy");
        cats[2] = new Cat(3, 250.0, "Pebbles");
        custs[0] = new Customer(201, "John", "Cena");
        custs[1] = new Customer(202, "Richard", "Dillon");
        custs[2] = new Customer(203, "Bill", "Laboon");
    }
    
    /**
     * This method searches the custs array for a certain Customer, given a customerID.
     * @param custID - the ID of the customer that needs to be found.
     * @return the Customer with the associated customerID, or null if not found.
     */
    public static Customer getCustomer(int custID) {
        for (Customer cust1 : custs) {
            if(cust1.getCustomerID() == custID) {
                return cust1;
            }
        }
        return null;
    }
    
    /**
     * This method searches the cats array for a certain cat, given a catID.
     * @param catID - the ID of the cat that needs to be found.
     * @return the Cat with the associated catID, or null if not found.
     */
    public static Cat getCat(int catID) {
        for (Cat cat : cats) {
            if(cat.getCatID() == catID) {
                return cat;
            }
        }
        return null;
    }
    
    /**
     * This method lists all cats that are in the cats array.
     * @return true if there are cats to print out.  False if there are no cats available.
     */
    private static boolean listCats() {
        try {
            boolean anyCats = false;
            for (Cat cat : cats) {
                if(!cat.isRented()) {
                    anyCats = true;
                    System.out.println(cat.toString());
                }
            }
            if(!anyCats) {
                return false;
            }
            else
                return true;
        }
        catch(Exception ex) {
            return false;
        }
    }
    
    /**
     * Attempts to rent the cat using the rentCat method in the Cat class.
     * @param cat - the cat that the customer would like to rent
     * @param cust - the customer that wants to rent the cat.
     * @return true if the cat is not currently being rented.  false if the cat is currently being rented.
     */
    private static boolean rent(Cat cat, Customer cust) {
        return cat.rentCat(cust.getCustomerID());
    }
    
    /**
     * Attempts to return the cat using the returnCat method in the Cat class.
     * @param cat - the cat that is being returned.
     * @return true if the cat is currently being rented, and can be returned. false if the cat isn't being rented, and therefore can't be returned.
     */
    private static boolean returnCat(Cat cat) {
        return cat.returnCat();
    }
}
