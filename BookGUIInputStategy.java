package oopAssignment4;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookGUIInputStategy implements GUIItemInputStrategy {
	
	private Catalogue cat;
	
	public BookGUIInputStategy() {
		// TODO Auto-generated constructor stub
	}

	public BibItem createBibItemFromInput(){
		/***
		 * Gets input through dialog and passes to BibItem constructor
		 */
		JTextField title = new JTextField();
		JTextField author = new JTextField();
		JTextField yearT = new JTextField();
		JTextField publisher = new JTextField();
		Object[] message = {
		    "Title:", title,
		    "Author: \n * format (Surname, Firstname) \n Use 'and' to denote multiple authors (SN, FN and SN, FN etc.", author, 
		    "Year:", yearT, 
		    "Publisher:", publisher
		};
	
		int option = JOptionPane.showConfirmDialog(null, message, "Enter Details", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
		    if (title.getText().equals(null) || author.getText().equals(null) || yearT.getText().equals(null) || publisher.getText().equals(null)) {
		    	this.createBibItemFromInput();
		    } else {
		        System.out.println("Success!");
		    }
		} else {
		    System.out.println("Cancelled");
		}
	
	//	
		Integer year = Integer.parseInt(yearT.getText());
		BibItem ab = new AcademicBook(author.getText(), title.getText(), year, publisher.getText());
		cat.getInstance().add(year, (AcademicBook)ab); // add to catalogue
		return ab;	
	}
	

}
