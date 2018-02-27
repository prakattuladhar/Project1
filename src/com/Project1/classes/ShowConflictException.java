package com.Project1.classes;

/**
 * @version 1.0
 * 
 * This class represents conflicting dates in the show schedule when a show is added
 * ConflictingShows is an array of length 2 that may be publicly accessed
 * If Show[0] != null, there is a conflict with the start date
 * If Show[1] != null, there is a conflict with the end date
 * 
 * @author Colin Quinn
 *
 */
public class ShowConflictException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	// Holds conflicting dates
	public Show[] conflictingShows;
	/**
	 * Creates Exception with array of conflicting shows
	 * @param shows array holding conflicting shows
	 */
	public ShowConflictException(Show[] shows) {
		conflictingShows = shows;
	}
}
