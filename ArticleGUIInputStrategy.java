package oopAssignment4;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ArticleGUIInputStrategy implements GUIItemInputStrategy {

	public ArticleGUIInputStrategy() {
		// TODO Auto-generated constructor stub
	}
	
	Catalogue cat;
	AcademicArticle aa;
	
	public BibItem createBibItemFromInput(){
		/***
		 * Gets input through dialog and passes to BibItem constructor
		 */
		JTextField title = new JTextField();
		JTextField author = new JTextField();
		JTextField yearT = new JTextField();
		JTextField journal = new JTextField();
		JTextField doiT = new JTextField();
		Object[] message = {
		    "Title:", title,
		    "Author: \n * format (Surname, Firstname) \n Use 'and' to denote multiple authors (SN, FN and SN, FN etc.", author, "Year:", yearT, "Journal:", journal, "DOI: \n * in format (00.0000/abc123)"
		    		+"\n [1] 00.0000 may comprise any digits, but must have exactly 2 digits before '.' and 4 after."
		    		+"\n [2] abc123 can be any characters as long as not null or include any white space", doiT  
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Enter Details", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
		    if (title.getText().equals(null) || author.getText().equals(null) || yearT.getText().equals(null) || journal.getText().equals(null) || doiT.getText().equals(null) || aa.validate(doiT) == false) {
		    	this.createBibItemFromInput();
		    } else {
		        System.out.println("Success!");
		    }
		} else {
		    System.out.println("Login canceled");
		}

//		
		Integer year = Integer.parseInt(yearT.getText());
		String doi = "https://www.doi.org/"+doiT.getText();
		BibItem aa = new AcademicArticle(author.getText(), title.getText(), year, journal.getText(), doi);
		cat.getInstance().add(year, (AcademicArticle)aa); // add to catalogue
		return aa;	
	}
	

}
