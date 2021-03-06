package pl.edu.agh.mwo;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	Trip trip2;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		trip2 = new Trip("nazwa2", "opis2");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
		//fail("chcemy zespuc");
		}
	
	@Test
	public void testFindTrip() throws Exception {
		tripManager.add(trip);
		HashMap<String,Trip> tripList = tripManager.getTrips();
		assertEquals(tripList, tripManager.find(trip.getName()));
	}
	
//	@Test
//	public void testFindTripUnAdded() throws Exception {
//		tripManager.add(trip);
//		assertEquals("Trip not found", tripManager.find(trip2.getName()));
//	}
	
}
