package movies;

/**
 * 
 * @author Caitlyn Chau 
 * CS 46B HW 3
 *
 * Movie class represents a Movie object with a title and year.
 */
public class Movie implements Comparable<Movie> {
	private String title;
	private int year;

	/**
	 * Movie constructor initializes instance variables with title and year
	 * 
	 * @param title
	 *            - movie title
	 * @param year
	 *            - year movie was released
	 */
	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}

	/**
	 * compareTo method compares the title of movie first, then compares the
	 * year. Movie comparison is done using String compareTo method
	 */
	public int compareTo(Movie that) {
		if (this.title.compareTo(that.title) != 0) { // titles are not same
			return title.compareTo(that.title);
		} else {
			return this.year - that.year;
		}
	}

	/**
	 * getYear method returns movie's year
	 * 
	 * @return year
	 */
	public int getYear() {
		return year;

	}

	/**
	 * getTitle method returns movie's title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * equals method calls compareTo method to ensure deep equality.
	 * 
	 * @param x
	 *            - object
	 */
	public boolean equals(Object x) {
		Movie m = (Movie) x;
		return (this.compareTo(m) == 0);
	}

	/**
	 * Returns movie as String with format: Movie Fight Club (1999)
	 */
	public String toString() {
		return "Movie " + getTitle() + " (" + getYear() + ")";
	}

	/**
	 * getTestMovies creates an array of movies. Two movies have same titles,
	 * but different years. The next two elements have different titles, but
	 * same years. The next two elements have the same name and year. The rest
	 * of the elements are uniquely different from the first five.
	 * 
	 * @return array of movies
	 */
	public static Movie[] getTestMovies() {
		Movie[] movieArr = new Movie[10];
		movieArr[0] = new Movie("Twilight", 1998);
		movieArr[1] = new Movie("Twilight", 2008);
		movieArr[2] = new Movie("Bee Movie", 2007);
		movieArr[3] = new Movie("Harry Potter and the Order of the Pheonix", 2007);
		movieArr[4] = new Movie("Fight Club", 1999);
		movieArr[5] = new Movie("Fight Club", 1999);
		movieArr[6] = new Movie("Shrek", 2001);
		movieArr[7] = new Movie("Inception", 2010);
		movieArr[8] = new Movie("Forrest Gump", 1994);
		movieArr[9] = new Movie("Mean Girls", 2004);

		return movieArr;
	}

	/**
	 * hashCode method creates unique HashCode by adding the title's HashCode +
	 * year
	 */
	public int hashCode() {
		return title.hashCode() + year;
	}
}
