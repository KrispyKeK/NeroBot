package chat.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie(String title)
	{
		this.title = "This particular movie, " + title;
		this.genre = "Action pact: " + genre;
		this.ratingMPAA = "R";
		this.review = "It's a pretty decent movie that is " + review;
		this.length = 120;
		this.releaseDate = LocalDate.of(2007,1,1);
		this.starScore = 7.5;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String desc = "";
		//desc += "Titl: " + title + " Genre: " + genre + " Rating: " + ratingMPAA + " Review: " + review;
		return desc;
	}
}
