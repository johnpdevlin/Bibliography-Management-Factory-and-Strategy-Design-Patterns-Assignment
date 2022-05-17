package oopAssignment4;

public abstract class AcademicPublication implements BibItem {

	private String author;
	private String title;
	protected String citeKey;
	private int year;
	
	public AcademicPublication(String author, String title, int year) {
		// TODO Auto-generated constructor stub
		this.author = author;
		this.title = title;
		this.year = year;
		this.citeKey = this.getCiteKey();
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthorLN() {
		String s = this.getAuthor();
		String[] tokens = s.split(",");
		return tokens[0];
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the citeKey
	 */
	public abstract String getCiteKey();
	public abstract String displayHarvard();
	public abstract String displayBibTex();
}
