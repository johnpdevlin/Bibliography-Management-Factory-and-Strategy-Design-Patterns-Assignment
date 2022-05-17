package oopAssignment4;

import javax.swing.JTextField;

public class AcademicArticle extends AcademicPublication {

	private String doi;
	private String journal;
	
	public AcademicArticle(String author, String title, int year, String journal, String doi) {
		super(author, title, year);
		// TODO Auto-generated constructor stub
		this.journal = journal;
		this.doi = doi;
		this.citeKey = this.getCiteKey();
	}

	/**
	 * @return the doi
	 */
	public String getDoi() {
		return doi;
	}

	/**
	 * @param doi the doi to set
	 */
	public void setDoi(String doi) {
		this.doi = doi;
	}

	/**
	 * @param journal the journal to set
	 */
	public void setJournal(String journal) {
		this.journal = journal;
	}

	
	/**
	 * @return the journal
	 */
	public String getJournal() {
		return journal;
	}

	public String getAbrYear() {
		int i = this.getYear();
		String number = String.valueOf(i);
		String[] tokens = number.split("");
		String abrYear = tokens[2]+tokens[3];
		
		return abrYear;
	}
	
	/**
	 * 
	 * @param url
	 * Checks correct construction of doi
	 * Checks that it isn't null, that the first part
	 * @return
	 */
	
	@SuppressWarnings("unused")
	public boolean validate(String doi) {
		String[] tokens = doi.split("/");
		
		if (doi == null) {
			return false;
		}
		
		else if (tokens.length != 2 || tokens[0].length() != 7 || tokens[0].charAt(2) != '.' || tokens[1] == null) {
			/*** checks that there is a '/' and '.' +
			 that the first part's length is correct and second part is not null **/
			return false;
		}
		
		else if (tokens[0].contains(" ") || tokens[1].contains(" ")) {
			// Checks for white spaces
			return false;
		}
		
		else {		
			for (int i=0; i < tokens[0].length(); i++) {
			// Checks that chars are digits
			if (i == 2) {
				// skips '.'
				i++;
			}
			
			Boolean check = Character.isDigit(tokens[0].charAt(i));
			if (check == false) {
				return false;
				}
			}
			
		}
		return true;
	}
	
	public String getCiteKey() {
		String citeKey = new String(this.getAuthorLN() + this.getAbrYear() + this.getJournal());
		return citeKey;
	}

	public String displayHarvard() {
		// TODO Auto-generated method stub
		String harvard = this.getAuthor()+". ("+this.getYear()+"). '"+this.getTitle()+"'. "+this.getJournal()+". "+this.getDoi()+".";
		return harvard;
	}

	public String displayBibTex() {
		// TODO Auto-generated method stub
		String bibTex = "@article{"+this.getCiteKey()+", author='"+this.getAuthor()+"', title='"+this.getTitle()+"', year='"+this.getYear()+"', journal='"+this.getJournal()+"', doi='"+this.getDoi()+"'}";
		return bibTex;
	}

	public boolean validate(JTextField doiT) {
	String[] tokens = doi.split("/");
		
		if (doi == null) {
			return false;
		}
		
		else if (tokens.length != 2 || tokens[0].length() != 7 || tokens[0].charAt(2) != '.' || tokens[1] == null) {
			/*** checks that there is a '/' and '.' +
			 that the first part's length is correct and second part is not null **/
			return false;
		}
		
		else if (tokens[0].contains(" ") || tokens[1].contains(" ")) {
			// Checks for white spaces
			return false;
		}
		
		else {		
			for (int i=0; i < tokens[0].length(); i++) {
			// Checks that chars are digits
			if (i == 2) {
				// skips '.'
				i++;
			}
			
			Boolean check = Character.isDigit(tokens[0].charAt(i));
			if (check == false) {
				return false;
				}
			}
			
		}
		return true;
	}
	}
	


