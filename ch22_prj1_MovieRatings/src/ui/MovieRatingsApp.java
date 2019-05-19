package ui;

import java.time.LocalDate;
import java.util.List;

import business.Movie;
import business.MovieCollection;
import util.Console;

public class MovieRatingsApp {

	/*
	 * This app depends on the classes Movie and MovieCollection,
	 * which you have to write.  This main method gives you 
	 * some sample movies to use to add to your collection.
	 * Feel free to add some of your favorites to this list!
	 * Sean Blessing - May 2019
	 */
	public static void main(String[] args) {
		//initialize stuff
		MovieCollection mc = new MovieCollection();
		
		System.out.println("Welcome to the Movie Ratings application!\n");
		
		displayMenu();
		int choice = 0;
		while (choice!=6) {
			choice = Console.getInt("Choose a menu option:  ");
			List<Movie> filteredMovies;
			switch (choice) {
				case 1:		// Enter a movie
					int nbr = Console.getInt("How many movies do you want to enter?  ");
					for (int i = 1; i <= nbr; i++) {
						Console.println("Movie # "+i);
						Console.println("===========");
						String title = Console.getRequiredString("Enter title:  ");
						int year = Console.getInt("Enter year:  ", 1900, LocalDate.now().getYear());
						double rating = Console.getDouble("Enter rating:  ", 1.0, 5.0);
						Movie m = new Movie(title, year, rating);
						mc.add(m);
					}
					break;
				case 2:		// View top rated movies
					filteredMovies = mc.filterMovies(m -> m.getRating()>=4.0);
					System.out.println("Movies rated 4.0 or higher");
					System.out.println("==========================");
					filteredMovies.stream().forEach(System.out::println);
					break;
				case 3:		// View most recent movies (movies released within last 10 years)
					int yearRange = LocalDate.now().getYear() - 10;
					filteredMovies = mc.filterMovies(m -> m.getYear()>=yearRange);
					Console.println("Movies released in last 10 years");
					Console.println("================================");
					filteredMovies.stream().forEach(System.out::println);
					break;
				case 4:
					Console.println("All movies");
					Console.println("==========");
					mc.getMovies().stream().forEach(System.out::println);
					break;
				case 5:		// View ratings
					System.out.println("Movie rating data");
					System.out.println("=================");
					System.out.println("# of movies:  "+mc.getSize());
					Console.println("lowest rating:  "+mc.getLowestRating());
					Console.println("highest rating:  "+mc.getHighestRating());
					Console.println("average rating:  "+mc.getAverageRating());
					break;
				case 6:
					Console.println("Goodbye!");
					break;
			}
		
		}
		

	}

	public static void displayMenu() {
        System.out.println("-----------------------");
        System.out.println("What do you want to do?");
        System.out.println("-----------------------");
        System.out.println("1 - Enter a movie");
        System.out.println("2 - View top rated movies");
        System.out.println("3 - View most recent movies");
        System.out.println("4 - View all movies");
        System.out.println("5 - View ratings");
        System.out.println("6 - Quit application");
        
        System.out.println();;
	}
	
}
