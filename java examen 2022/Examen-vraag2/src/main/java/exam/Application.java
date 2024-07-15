package exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {

		List<Movie> movies = Arrays.asList(
				new Movie("The Shawshank Redemption ", "Frank Darabont", "Morgan Freeman", 1994, Genre.DRAMA),
				new Movie("The Godfather", "Francis Ford Coppola", "Al Pacino", 1972, Genre.CRIME),
				new Movie("Reservoir Dogs", "Quentin Tarantino", "Harvey Keitel", 1992, Genre.ACTION),
				new Movie("The Good, the Bad and the Ugly", "Sergio Leone", "Clint Eastwood", 1966, Genre.ACTION),
				new Movie("The Dark Knight", "Christopher Nolan", "Christian Bale", 2008, Genre.ACTION),
				new Movie("The Godfather: Part II", "Francis Ford Coppola", "Al Pacino", 1974, Genre.CRIME),
				new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", "Elijah Wood", 2003,
						Genre.ADVENTURE),
				new Movie("Pulp Fiction", "Quentin Tarantino", "Samuel L. Jackson", 1994, Genre.DRAMA),
				new Movie("The Good, the Bad and the Ugly", "Sergio Leone", "Clint Eastwood", 1966, Genre.CRIME),
				new Movie("Schindler's List", "Steven Spielberg", "Liam Neeson", 1993, Genre.DRAMA),
				new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", "Elijah Wood", 2001,
						Genre.ADVENTURE),
				new Movie("The Hateful Eight", "Quentin Tarantino", "Samuel L. Jackson", 2015, Genre.CRIME),
				new Movie("Forrest Gump", "Robert Zemeckis", "Tom Hanks", 1994, Genre.DRAMA),
				new Movie("The Godfather: Part II", "Francis Ford Coppola", "Al Pacino", 1974, Genre.CRIME),
				new Movie("The Good, the Bad and the Ugly", "Sergio Leone", "Clint Eastwood", 1966, Genre.ACTION),
				new Movie("From Dusk Till Dawn", "Quentin Tarantino", "George Clooney", 1996, Genre.ACTION),
				new Movie("Knight rising", "Christopher Nolan", "Christian Bale", 2005, Genre.ACTION));

		System.out.println("----------------------");
		System.out.println("Create default sort 1P");
		System.out.println("----------------------");
		createDefaultSort(movies);
		System.out.println();

		System.out.println("-------------------------------------");
		System.out.println("Find All actors with QT and count 1p");
		System.out.println("-------------------------------------");
		findAllActorsWithQT(movies);
		System.out.println();

		System.out.println("--------------------------------");
		System.out.println("Get Action Actors 1990 - 2010 1P");
		System.out.println("--------------------------------");
		getActionActors(movies);
		System.out.println();

		System.out.println("-------------------------");
		System.out.println("Print Genres Each Year 1P");
		System.out.println("-------------------------");
		printGenresEachYear(movies);
		System.out.println();

	}

	// 1 P
	// Zorg ervoor dat de Movie class default eerst op director sorteert en erna op
	// leadActor. ( Dus als er twee directors gelijk zijn zal de sort ook rekening
	// houden met leadActor)
	// Print een gesorteerd resultaat naar de console
	private static void createDefaultSort(List<Movie> movies) {
		movies.stream().sorted((m1, m2) -> m1.getDirector().compareTo(m2.getDirector()))
				.sorted((m1, m2) -> m1.getLeadActor().compareTo(m2.getLeadActor())).forEach(System.out::println);
	}



	// 1P
	// Gebruik Streams & Lambdas
	// Geef alle leadActors die met Quentin Tarantino(director) een film hebben
	// gemaakt.
	// Geef ook hoeveel films ze samen hebben gemaakt en print ze in volgorde af
	// Print je resultaat naar de console
	private static void findAllActorsWithQT(List<Movie> movies) {
		//group by leadactors & director
		movies.stream().filter(m -> m.getDirector().equals("Quentin Tarantino")).collect(Collectors.groupingBy(Movie::getLeadActor, Collectors.groupingBy(Movie::getDirector)))
				.forEach((actor, moviegrouped) -> {
					System.out.println("Actor: " + actor);
					moviegrouped.forEach((director, movielist) -> {
						System.out.println(movielist.size() + " Movies:");
						movielist.forEach(System.out::println);
					});
				});


	}

	// 1 P
	// Gebruik streams & lambdas
	// Geef alle leadActor die in een ACTION film hebben gespeeld tussen 1990 en
	// 2010
	// Print je resultaat naar de console
	private static void getActionActors(List<Movie> movies) {
		movies.stream().filter(m -> m.getGenre() == Genre.ACTION).filter(m -> m.getPublishYear() >= 1990 && m.getPublishYear() <= 2010).forEach(m -> System.out.println(m.getLeadActor()));
	}

	// 1 P
	// Geef per jaar weer hoeveel films er per genre zijn gemaakt.
	// Print dit naar de console
	private static void printGenresEachYear(List<Movie> movies) {
		movies.stream().collect(Collectors.groupingBy(Movie::getPublishYear, Collectors.groupingBy(Movie::getGenre))).
				forEach((year, moviespergenre) -> {
					System.out.println("Year: " + year );
					moviespergenre.forEach((genre, movielist) -> System.out.println(genre + ": " + movielist.size()));
				});
	}

}
