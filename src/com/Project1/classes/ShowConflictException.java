package com.Project1.classes;

public class ShowConflictException extends RuntimeException {
	public Show[] conflictingShows;
	
	public ShowConflictException(Show[] shows) {
		conflictingShows = shows;
	}
}
