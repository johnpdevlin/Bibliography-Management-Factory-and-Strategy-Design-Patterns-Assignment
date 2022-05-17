package oopAssignment4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

	public class GUIBibManager extends JFrame {  
	 
		/**
		 * VARIABLES
		 */
		private static final long serialVersionUID = 1L;
		ConcreteBibItemFactory cBibF;
		static Catalogue cat = new Catalogue();
		JFrame f;
		
		/**
		 * TABBED PANE
		 */
	GUIBibManager() throws IOException{  
	    f = new JFrame();  
	    
	    /***
	     * Import Bibliography to File
	     * Ask user for filename 
	     * Writes 
	     */
	    JPanel importBib =new JPanel();  
		    JButton importB = new JButton("Import");     
		    importBib.add(importB);
		    importB.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		    	String readFile = JOptionPane.showInputDialog("Enter File Name to Import: ");
			    try {
					cat.readFromFile(readFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        }          
		      });
	    
	    /***
	     * EXPORT Bibliography to File
	     * Ask user for filename 
	     * Writes 
	     */
	    JPanel exportBib  = new JPanel();  
	    JButton exportB = new JButton("Export");     
	    exportBib.add(exportB);
	    exportB.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 String fileName = JOptionPane.showInputDialog("Enter File Name for export: ");
	        	 try {
					cat.writeToFile(fileName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }          
	      });
	    	
	    
		    /***
		     * To add entry
		     * Gives button options
		     * Upon click calls bibItemFactory Dialogs
		     * To create BibItems of specified type
		     */
	    JPanel addEntry = new JPanel();  	    		
		    JButton book =new JButton("Book");     
		    addEntry.add(book);
		    book.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 cBibF = new ConcreteBibItemFactory(new BookGUIInputStategy());
		        	 cBibF.createBibItem();
		         }          
		      });
		    JButton article = new JButton("Article");     
		    addEntry.add(article);
		    article.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 cBibF = new ConcreteBibItemFactory(new ArticleGUIInputStrategy());
		        	 cBibF.createBibItem();
		         }          
		      });
		    JButton techReport = new JButton("Techinal Report");     
		    addEntry.add(techReport);
		    techReport.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 cBibF = new ConcreteBibItemFactory(new TechnicalReportGUIInputStrategy());
		        	 cBibF.createBibItem();
		         }          
		      });
		    
		    /***
		     * 
		     * To add entry
		     * Gives button options
		     * Upon click calls bibItemFactory Dialogs
		     * To create BibItems of specified type
		     */
		JPanel deleteEntry = new JPanel();  	    		
		    JButton delete =new JButton("DELETE!");     
		    deleteEntry.add(delete);
		    delete.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 String citeKey = JOptionPane.showInputDialog("Enter CiteKey of BibItem to Delete: ");
		        	 if (((AcademicPublication) cat.getEntries()).getCiteKey().contains(citeKey)) {
		        		 cat.delete(citeKey);
		        	 }	 
		         }          
		      });
		   
		    /***
		     * View Entries
		     * Gives button option to Choose format
		     * Shows Entries in order
		     */
	    JPanel viewEntries = new JPanel(); 
	    	JButton harvard = new JButton("Display Harvard"); 
	    	harvard.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			String message = cat.getInstance().displayHarvard();
	    			JTextArea textArea = new JTextArea(message);
	    			JScrollPane scrollPane = new JScrollPane(textArea);  
	    			textArea.setLineWrap(true);  
	    			textArea.setWrapStyleWord(true); 
	    			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
	    			JOptionPane.showMessageDialog(null, scrollPane, "Harvard entries", JOptionPane.YES_NO_OPTION);
	    		}
	    	});
	    	JButton bibTex = new JButton("Display BibTex"); 
	    	bibTex.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			String message = cat.getInstance().displayBibTex();
	    			JTextArea textArea = new JTextArea(message);
	    			JScrollPane scrollPane = new JScrollPane(textArea);  
	    			textArea.setLineWrap(true);  
	    			textArea.setWrapStyleWord(true); 
	    			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
	    			JOptionPane.showMessageDialog(null, scrollPane, "BibTex Entries", JOptionPane.YES_NO_OPTION);
	    		}
	    	});
	    	viewEntries.add(harvard);
	    	viewEntries.add(bibTex);
	    	 
	   
	    	
	    	/***
	    	 * Closes all windows on button click
	    	 */
	    JPanel Quit = new JPanel(); 
		    JButton quitButton = new JButton("Definitely want to Quit!");      
		    quitButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e){
		        	System.exit(0);
		        }
		    });
		    Quit.add(quitButton);
		   
		    /***
	    	 * Creates Tabs and tabbed pane
	    	 */
	    JTabbedPane tp = new JTabbedPane();  
	    tp.setBounds(5, 5, 700, 700);  
	    tp.add("Import Bibtex File",importBib);  
	    tp.add("Export to file",exportBib);  
	    tp.add("Add entry",addEntry);  
	    tp.add("Delete entry",deleteEntry);  
	    tp.add("View entries",viewEntries); 
	    tp.add("Quit",Quit);
	    
	    /***
	     * Sets frame size, layout, close operation etc.
	     */
	    f.add(tp);  
	    f.setSize(750,750);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	    f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}  
		
	
	
	public static void main(String[] args) {  
		
		/***
		 * Runs app
		 */
		
	    try {
			new GUIBibManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}  
