package com.Project1.classes;

import java.io.Serializable;
import java.util.*;
import java.time.*;

public class ShowList implements Serializable, Iterable<Show> {
	private static final long serialVersionUID = 1L;
    private TreeMap<Show, Integer> map = new TreeMap<Show, Integer>( new SortByStartDate() );
    /**
     * 
     * @param show
     * @return
     */
    public boolean add(Show show){
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
    	// Show which shows conflict
    	if (available == false) {
    		throw new ShowConflictException(conflictingShows);
    	}
    	
    	map.put(show, null);
    	
        return available;
    }

    private class SortByStartDate implements Comparator<Show> {
    	public int compare(Show a, Show b) {
    		return a.getStartDate().compareTo( b.getStartDate() );
    	}
    }
    
    private class SortByEndDate implements Comparator<Show> {
    	public int compare(Show a, Show b) {
    		return a.getEndDate().compareTo( b.getEndDate() );
    	}
    }
    
    @Override
    public Iterator<Show> iterator() {
    	return map.keySet().iterator();
    }
}
