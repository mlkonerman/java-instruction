package business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class MovieCollection {
    private List<Movie> movieCollection;
    
    public MovieCollection() {
        movieCollection = new ArrayList<>();
        movieCollection.add(new Movie("Avengers Infinity War", 2018, 4.0));
		movieCollection.add(new Movie("Star Wars Episode 5 - Empire Strikes Back", 1980, 5.0));
		movieCollection.add(new Movie("Sixteen Candles", 1984, 4.5));
		movieCollection.add(new Movie("Happy Gilmore", 1996, 4.3));
		movieCollection.add(new Movie("The Jerk", 1979, 3.9));
		movieCollection.add(new Movie("Superbad", 2007, 3.9));
		movieCollection.add(new Movie("Back to the Future Part III", 1990, 2.1));
		movieCollection.add(new Movie("Entourage", 2015, 1.5));
    }
    
    public List<Movie> getMovies() {
        return movieCollection;
    }
    public void add(Movie m) {
    //add Movie object to internal list	
    }
    
    public List<Movie> filterMovies(Predicate<Movie> condition) {
    	List<Movie> filteredMovies = new ArrayList<>();
    	for (Movie m : movieCollection) {
    		if (condition.test(m)) {
    			filteredMovies.add(m);
    		}
    	}
    	return filteredMovies;
    }
    public double getLowestRating() {
    	double minRating = movieCollection.stream()
    			.map(i -> i.getRating())
    			.reduce(0.0, (a, b) -> Math.min(a, b));
    	System.out.println("Lowest rating: "+minRating);
    	return minRating;
    }
    
    public double getHighestRating() {
    	double maxRating = movieCollection.stream()
    			.map(i -> i.getRating())
    			.reduce(0.0, (a, b) -> Math.max(a, b));
    	System.out.println("Highest rating: "+maxRating);
		return maxRating;
    	
    }
    
    public double getAverageRating() {
    	int numberMovies = movieCollection.size();
    	double avgRating = movieCollection.stream()
    			.map(i -> i.getRating())
    			.reduce(0.0, (sum, a) -> sum+a/numberMovies);
    	System.out.println("Average rating: "+avgRating);
		return avgRating;
    	
    }
    public int getSize() {
    	int numberMovies = movieCollection.size();
    	return numberMovies;
    }

}