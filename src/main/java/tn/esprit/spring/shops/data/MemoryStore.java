package tn.esprit.spring.shops.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.maps.model.LatLng;
import com.project0.esprit.entity.Delivery_Man;





/**
 * An in memory store which stores all the data in an array list. Provide a
 * different implementation if you want data persistence.
 * 
 * @author ranjan
 *
 */
public class MemoryStore implements Store<Delivery_Man, LatLng> {

	/**
	 * logger
	 */
	private static final Logger LOG = Logger.getLogger(MemoryStore.class.getName());

	/**
	 * the list for storing data
	 */
	private final List<Delivery_Man> data = new ArrayList<>();

	/**
	 * get the shop nearest to a geocode
	 */
	@Override
	public Delivery_Man get(LatLng geocode) {
		Delivery_Man nearestShop = findNearest(geocode);
		return nearestShop;
	}

	/**
	 * get all the registered shops
	 */
	@Override
	public List<Delivery_Man> getAll() {
		return data;
	}

	/**
	 * register a shop
	 */
	@Override
	public Delivery_Man add(Delivery_Man item) {
		data.add(item);
		return item;
	}

	/**
	 * Find the shop nearest to this geocode
	 * 
	 * @param geocode
	 * @return
	 */
	public Delivery_Man findNearest(LatLng geocode) {
		// customer latitude and longitude
		double lat1 = geocode.lat;
		double lon1 = geocode.lng;
		// hold the nearest distance found till now
		double nearestDist = -1;
		// hold the reference to the nearest shop found till now
		Delivery_Man nearestShop = null;
		for (Delivery_Man shop : data) {
			// latitude and longitude of the shop to compare
			double lat2 = shop.getShop1().getShopLatitude();
			double lon2 = shop.getShop1().getShopLongitude();
			// distance to the shop in comparison
			double dist = Util.haversine(lat1, lon1, lat2, lon2);
			// if the shop in comparison is nearer than the previous shop or if
			// it is the first shop
			if (dist < nearestDist || nearestDist == -1) {
				nearestShop = shop;
				nearestDist = dist;
				LOG.log(Level.INFO, " Shop " + nearestShop.getShop1().getShopName() + " found at " + nearestDist + " KM");
			}
		}
		return nearestShop;
	}

}
