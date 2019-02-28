package movies;

import java.util.ArrayList;

/**
 * @author Caitlyn Chau
 * CS 46B HW 3
 *
 * FilmArchive interface defines two methods- add and getSorted that all 
 * FilmArchive subclasses should implement
 */
public interface FilmArchive {

	/**
	 * Implementations should return an array list whose members are unique
	 * according to deep equality, and sorted according to the criteria in
	 * Movie’s compareTo() method
	 * 
	 * @return ArrayList of Movies sorted by title then year
	 */
	public ArrayList<Movie> getSorted();

	/**
	 * If add() is called where the arg already appears (according to
	 * deep-equality) in the film archive, the method should return false and do
	 * nothing else; if the arg of add() does not yet appear in the archive, it
	 * should be added as described below and the method should return true.
	 * 
	 * @param m - movie
	 * @return true or false
	 */
	public boolean add(Movie m);
}
