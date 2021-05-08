package model;

public class BookModel {
	
	private String author;
	private String title;
	private String genre;
	private String description;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BookModel [author=" + author + ", title=" + title + ", genre=" + genre + ", description=" + description
				+ "]";
	}
	
	

}
