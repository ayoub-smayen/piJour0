package com.project0.esprit.repository;

import java.util.List;


public interface Store<T, M> {

	/**
	 * retrieve an item
	 * 
	 * @return
	 */
	public T get(M searchCriteria);

	/**
	 * retrieve all the items
	 * 
	 * @return
	 */
	default public List<T> getAll() {
		return null;
	}

	/**
	 * add an item
	 * 
	 * @param item
	 */
	public T add(T item);
}