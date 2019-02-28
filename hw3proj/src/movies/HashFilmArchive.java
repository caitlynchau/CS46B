package movies;

import java.util.HashSet;
import java.util.ArrayList;

/**
 * 
 * @author Caitlyn Chau
 * CS 46B HW 3
 * 
 * HashFilmArchive is a HashSet<Movie> object that implements the FilmArchive.
 * It sorts out duplicates but has an arbitrary order. 
 *
 */
public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

	/**
	 * getSorted method returns this object (HashSet<Movie>) as an ArrayList.
	 * The elements in this object will not have any duplicates, but the order
	 * will be arbitrary. 
	 */
	public ArrayList<Movie> getSorted() {
		return new ArrayList<Movie>(this);
	}

	/**
	 * Do not need to create add() method because the superclass, HashSet<Movie>
	 * already contains add() method which "adds the specified element to this
	 * set if it is not already present" (Java API).
	 */
	
	
	
	/**
	 * Main method tests HashSet's order
	 * @param args - argument
	 */
	public static void main(String[]args){
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m : Movie.getTestMovies()){
			archive.add(m); 
		}
		for (Movie m: archive){
			System.out.println(m);
		}
		System.out.println("******************");
		for (Movie m : archive.getSorted()){
			System.out.println(m);
		}
	}

}
