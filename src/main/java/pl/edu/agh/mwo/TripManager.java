package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

	public Map<String, Trip> find(String keyword) {
		
		Map<String, Trip>  findedTrips = new HashMap<String, Trip>();
		
		for  (String name : tripList.keySet()) {
			if (name.contains(keyword)) {
				findedTrips.put(name, tripList.get(name));
			}
		}
		return findedTrips;
	}
	
}
