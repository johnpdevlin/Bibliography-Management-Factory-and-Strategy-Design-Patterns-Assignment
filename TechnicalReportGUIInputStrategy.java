package oopAssignment4;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TechnicalReportGUIInputStrategy implements GUIItemInputStrategy {
	
	private Catalogue cat;
	
	public TechnicalReportGUIInputStrategy() {
		// TODO Auto-generated constructor stub
	}

	public BibItem createBibItemFromInput(){
		/***
		 * Gets input through dialog and passes to BibItem constructor
		 */
		JTextField title = new JTextField();
		JTextField author = new JTextField();
		JTextField yearT = new JTextField();
		JTextField ddmmyy = new JTextField();
		JTextField institution = new JTextField();
		Object[] message = {
		    "Title:", title,
		    "Author: \n * format (Surname, Firstname) \n Use 'and' to denote multiple authors (SN, FN and SN, FN etc.", author, 
		    "Year:", yearT, 
		    "Enter date: \n * format dd/mm/yy", ddmmyy,
		    "Institution:", institution
		};
	
		int option = JOptionPane.showConfirmDialog(null, message, "Enter Details", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
		    if (title.getText().equals(null) || author.getText().equals(null) || yearT.getText().equals(null) || ddmmyy.getText().equals(null) || institution.getText().equals(null)) {
		    	this.createBibItemFromInput();
		    } else {
		        System.out.println("Success!");
		    }
		} else {
		    System.out.println("Cancelled");
		}
	
	//	
		Integer year = Integer.parseInt(yearT.getText());
		BibItem atr = new AcademicTechnicalReport(title.getText(), author.getText(),  year, institution.getText(), ddmmyy.getText());
		cat.getInstance().add(year, (AcademicTechnicalReport)atr); // add to catalogue
		return atr;	
	}
	
}
