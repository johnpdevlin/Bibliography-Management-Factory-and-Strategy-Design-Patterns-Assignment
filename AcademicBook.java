package oopAssignment4;

public class AcademicBook extends AcademicPublication {
	
	private String publisher;
	
	public AcademicBook(String author, String title, int year, String publisher) {
		super(author, title, year);
		// TODO Auto-generated constructor stub
		this.publisher = publisher;
		this.citeKey = this.getCiteKey();
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean check(String input) {
		if (input == null) {
			return false;
		}
		
		return true;
	}

	/**
	 * @return the citeKey
	 */
	public String getCiteKey() {
		String citeKey = new String(this.getAuthorLN() + this.getYear());
		return citeKey;
	}

	@Override
	public String displayHarvard() {
		String harvard = this.getAuthor()+". ("+this.getYear()+"). '"+this.getTitle()+"'. "+this.getPublisher()+".";
		return harvard;
	}

	@Override
	public String displayBibTex() {
		// TODO Auto-generated method stub
		String bibTex = "@book{"+this.getCiteKey()+", author='"+this.getAuthor()+"', title='"+this.getTitle()+"', year='"+this.getYear()+"', publisher='"+this.getPublisher()+"'}";
		return bibTex;
	}

	
			
}
