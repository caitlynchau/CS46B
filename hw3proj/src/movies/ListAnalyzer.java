package movies;

/**
 * 
 * @author Caitlyn Chau
 * CS 46B HW 3
 *
 * ListAnalyzer creates 100000 fake movies in ListFilmArchive and prints a 
 * message ever 1000 insertions
 *
 */
public class ListAnalyzer {

	/**
	 * Main method to test add method's time performance 
	 * @param args - argument
	 */
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (int i = 0; i < 100000; i++) {
			archive.add(new Movie("Movie" + i, 2017));
			if (i % 1000 == 0)
				System.out.println(i);
		}
		System.out.println("DONE");
	}

}
