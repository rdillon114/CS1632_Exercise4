
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class CatTest {

    // The following two tests should always pass.
    // They don't really check anything.
    
    @Test
    public void testShouldPass() {
	assertEquals(1, 1);
    }

    @Test
    public void testShouldAlsoPass() {
	int x = 1;
	int y = 1;
	int z = x + y;
	assertTrue(z == 2);
    }
    
    //tests whether the getCat method works in RentACat for the first element in the cats array.
    @Test
    public void testGetCatFirst() {
        RentACat rac = new RentACat();
	assertEquals(RentACat.getCat(rac.cats[0].getCatID()), rac.cats[0]);
        System.out.println("passed testGetCatFirst");
    }

    //tests whether the getCat method works in RentACat for the last element in the cats array.
    @Test
    public void testGetCatLast() {
	RentACat rac = new RentACat();
	assertEquals(rac.getCat(rac.cats[rac.cats.length - 1].getCatID()), rac.cats[rac.cats.length - 1]);
        System.out.println("passed testGetCatLast");
    }
    
    
    @Test
    public void testGetCatNegative() {
        RentACat rac = new RentACat();
	assertEquals(rac.getCat(-22), null);
        System.out.println("passed textGetCatNegative");
    }
    
    @Test
    public void testGetCustomerFirst() {
        RentACat rac = new RentACat();
        assertEquals(rac.getCustomer(rac.custs[0].getCustomerID()), rac.custs[0]);
        System.out.println("passed testGetCustomerFirst");
    }
    
    @Test
    public void testGetCustomerLast() {
	RentACat rac = new RentACat();
	assertEquals(rac.getCustomer(rac.custs[rac.custs.length - 1].getCustomerID()), rac.custs[rac.custs.length - 1]);
        System.out.println("passed testGetCustomerLast");
    }
    
    @Test
    public void testRentCatTrue() {
        RentACat rac = Mockito.mock(RentACat.class);
        Cat cat = new Cat(100000, 200.0, "sprinkle");
        assertTrue(cat.rentCat(rac.custs[0].getCustomerID()));
        System.out.println("passed testRentCatTrue");
    }
    
    @Test
    public void testRentCatFalse() {
        RentACat rac = Mockito.mock(RentACat.class);
        Cat cat = new Cat(100000, 200.0, "sprinkle");
        cat.rentCat(rac.custs[0].getCustomerID());
        assertFalse(cat.rentCat(rac.custs[0].getCustomerID()));
        System.out.println("passed testRentCatFalse");
    }
    
    @Test
    public void testReturnCatTrue() {
        RentACat rac = Mockito.mock(RentACat.class);
        Cat cat = new Cat(100000, 200.0, "sprinkle");
        cat.rentCat(rac.custs[0].getCustomerID());
        assertTrue(cat.returnCat());
        System.out.println("passed testReturnCatTrue");
    }
    
    @Test
    public void testReturnCatFalse() {
        RentACat rac = Mockito.mock(RentACat.class);
        Cat cat = new Cat(100000, 200.0, "sprinkle");
        assertFalse(cat.returnCat());
        System.out.println("passed testReturnCatFalse");
    }
/*
    // Test that for a Noogie with a negative # of cats, if we call
    // the negativeCats() method, it will return the correct
    // number of (positive) cats.
    
    @Test
    public void testDoubleNegative() {
	Noogie n = new Noogie(-5);
	assertEquals(5, n.negativeCats());
    }

    // Test adding a positive number of cats.
    
    @Test
    public void testAdd1() {
	Noogie n = new Noogie(0);
	n.addSomeCats(1);
	assertEquals(1, n.getNumCats());
    }

    // Test adding a negative number of cats throws an exception.
    
    @Test
    public void testNegativeAdd() {
	Noogie n = new Noogie(0);
	try {
	    n.addSomeCats(-2);
	    // Note that if fail() is called, result will be "null" and that is
	    // what will be displayed in the TestRunner
	    fail();
	} catch (ArithmeticException aex) {
	    // expected behavior
	}
	// Number of cats should remain 0 (initial value)
	assertEquals(0, n.getNumCats());

    }

    // Test adding cats multiple times.
    
    @Test
    public void testMultipleAdds() {
	Noogie n = new Noogie(0);
	for (int j = 0; j < 10; j++) {
	    n.addSomeCats(5);
	}
	assertEquals(50, n.getNumCats());
    }

    // TESTS USING MOCKITO

    // Assume Badger.java is not our code, so we are not
    // interested in testing it per se.  However, the
    // Noogie class which we are working on depends on
    // it.  So we will double it and "fake" it to avoid
    // depending on it in our tests, as well as saving
    // time.
    
    // Using these doubles will prevent the time-consuming
    // Badger methods from being called.

    // Note that since I used "import static" above, then
    // I do not need to type e.g. "Mockito.mock", but just
    // "mock"

    // Simple double
    // Under ordinary circumstances, no exception should be
    // thrown by the Badger, so we should return 0.
    
    @Test
    public void testBadgerPlay() {
	Badger b = Mockito.mock(Badger.class);
	Noogie n = new Noogie(0);
	int val = n.playWithBadger(b);
	assertEquals(0, val);
    }

    // Force our doubled Badger object to throw an exception whenever
    // .play() is called.  In this case playWithBadger should return 1.

    @Test
    public void testBadgerPlayException() {
	Badger b = Mockito.mock(Badger.class);
	Mockito.when(b.play()).thenThrow(new ArithmeticException());
	Noogie n = new Noogie(0);
	int val = n.playWithBadger(b);
	assertEquals(1, val);
    }

    // Make a true mock to ensure that .play() is called
    // only once in the .playWithBadger() method.
    // Note that I stub before I verify.

    @Test
    public void testBadgerPlayCalled() {
	Noogie n = new Noogie(0);
	Badger b = Mockito.mock(Badger.class);
	Mockito.when(b.play()).thenReturn("");
	n.playWithBadger(b);
	Mockito.verify(b, Mockito.times(1)).play();
	    
    }
    
    // Stub out getNumFlerbos() to give us no flerbos.
    
    @Test
    public void testBadgerSimOneBadgerNoCats() {
    	Noogie n = new Noogie(0);
    	Badger b = Mockito.mock(Badger.class);
    	Mockito.when(b.getNumFlerbos()).thenReturn(0);
    	Badger[] bs = new Badger[1];
    	bs[0] = b;
    	int val = n.simulateBadgers(bs);
    	assertEquals(0, val);	
    }

    // Stub out getNumFlerbos() to give us lots of flerbos.
    // Give the class under test (Noogie) lots of cats.
    
    @Test
    public void testBadgerSimOneBadgerManyCatsManyFlerbos() {
    	Noogie n = new Noogie(100);
    	Badger b = Mockito.mock(Badger.class);
    	Mockito.when(b.getNumFlerbos()).thenReturn(100);
    	Badger[] bs = new Badger[1];
    	bs[0] = b;
    	int val = n.simulateBadgers(bs);
    	assertEquals(200, val);	
    }

    // Combine tests to check many cats, and many badgers, all
    // with many flerbos.
    
    @Test
    public void testBadgerSimManyBadgersManyCatsManyFlerbos() {
    	Noogie n = new Noogie(100);
    	Badger[] bs = new Badger[10];
	for (int j = 0; j < 10; j++) {
	    Badger mb = Mockito.mock(Badger.class);
	    Mockito.when(mb.getNumFlerbos()).thenReturn(100);
	    bs[j] = mb;
	}
    	int val = n.simulateBadgers(bs);
    	assertEquals(1100, val);	
    }
    */

    
}
