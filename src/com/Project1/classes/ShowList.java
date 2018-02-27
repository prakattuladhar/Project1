package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;

/**
 * @version 1.0
 * 
 * This class represents a schedule of shows for the theater
 * 
 * @author Colin Quinn
 *
 */
public class ShowList implements Serializable, Iterable<Show> {
	private static final long serialVersionUID = 1L;
	// Allows searching for start date in O(log(n)) time
	private TreeMap<Show, Integer> map = new TreeMap<Show, Integer>( new SortByStartDate() );
    /**
     * Adds a show to the list of shows
     * Fails if there are conflicting dates, or if the client of the show not in
     * client list
     * @param show		show to be added
     * @return true if show dates available, false if not
     * @exception ShowConflictException if date range is not free
     */
    public boolean add(Show show, ClientList list){

    	if (list.getClient( show.getClientId() ) == null) {
    		throw new RuntimeException("Add failed: No client exists for ID: " + show.getClientId() );
    	}
    	
    	boolean available = true;
    	// Holds potentially conflicting shows
    	Show[] conflictingShows = {null, null};
    	
    	/*
    	 * Check that show starts after previous show ends
    	 * floorKey returns show with greatest start time <= show's start time
    	 */
    	Show previous = map.floorKey(show);
    	if (
    		previous == null ||					// Is there a previous show?
    		(show.getStartDate().compareTo( previous.getEndDate() ) > 0)
    	) {
    		;	// No conflict around start
    	} else {
    		conflictingShows[0] = previous;
    		available = false;
    	}
    	/*
    	 * Check that show ends before next show starts
    	 * ceilingKey returns show with lowest start time >= show's start time
    	 */
    	Show next = map.ceilingKey(show);
    	if (
    		next == null ||						// Is there a next show?
    		(show.getEndDate().compareTo( next.getStartDate() ) < 0)
    	) {
    		;	// No conflict around end
    	} else {
    		conflictingShows[1] = next;
    		available = false;
    	}
    	// Show which shows conflict with added show
    	if (available == false) {
    		throw new ShowConflictException(conflictingShows);
    	}
    	
    	map.put(show, show.getClientId() );
    	
        return available;
    }
    /**
     * Check if client has at least one show scheduled
     * @param clientId		Id of client to be checked
     * @return	true if client has at least one show, false if no shows
     */
    public boolean ClientHasShow(int clientId) {
    	return map.containsValue(clientId);
    }
    /**
     * @version 1.0
     * Allows map of shows to be sorted by start date
     * @author Colin Quinn
     */
    private class SortByStartDate implements Comparator<Show>, Serializable {
    	private static final long serialVersionUID = 1L;
    	public int compare(Show a, Show b) {
    		return a.getStartDate().compareTo( b.getStartDate() );
    	}
    }
    /**
     * @version 1.0
     * Allows map of shows to be sorted by end date
     * @author Colin Quinn
     */
    private class SortByEndDate implements Comparator<Show>, Serializable {
    	private static final long serialVersionUID = 1L;
    	public int compare(Show a, Show b) {
    		return a.getEndDate().compareTo( b.getEndDate() );
    	}
    }
    /**
     * Gets iterator for shows
     * @return Iterator<Show>
     */
    @Override
    public Iterator<Show> iterator() {
    	return map.keySet().iterator();
    }
}
