/**
 * 
 */
package oopAssignment4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author j
 *
 */
public class Catalogue implements BibFileReader, BibFileWriter {

	/***
	 * Singleton class holds sole instance
	 */
	
	private static Catalogue bibCat;
	
	private TreeMap<Integer, AcademicPublication> entries; // TreeMap stops repetitions
	
	protected Catalogue() {
		// implementation allows polymorphism
		this.entries = new TreeMap<Integer, AcademicPublication>(); 
	}
	
	public Catalogue getInstance() {
		if (bibCat == null) bibCat = new Catalogue();
		return bibCat;
	}
	
	public void add(Integer year, AcademicPublication entry) {
		this.entries.put(year, entry);
	}
	
	public void delete(String entry) {
		if (((Map<Integer, AcademicPublication>) bibCat).containsKey(entry)) {
			((Map<Integer, AcademicPublication>) bibCat).remove(entry);
		}
	}
	
	public String displayHarvard() {
		/***
		 * Displays entries as Harvard
		 * Does by adding itteratively to a String
		 */
		String harvard = "";
		 for (Entry<Integer, AcademicPublication> entry : entries.entrySet()) {
			 harvard += ((Catalogue) entry).displayHarvard()+"/n";
		 }
		 return harvard;
	}
	
	public String displayBibTex() {
		/***
		 * Displays entries as BibTex
		 * Does by adding itteratively to a String
		 */
		String bibTex = "";
		 for (Entry<Integer, AcademicPublication> entry : entries.entrySet()) {
			 bibTex += ((Catalogue) entry).displayBibTex()+"/n";
		 }
		 return bibTex;
	}
	
	public Map<Integer, BibItem> getEntries() {
		return Collections.unmodifiableMap(this.entries);
	}
	
	public void writeToFile(String fileName) throws IOException {
		/***
		 * Passed name assigned to outputstream, object  
		 */
		FileOutputStream out;
	try {
		out = new FileOutputStream(fileName);
		ObjectOutputStream s = new ObjectOutputStream(out); 
		s.writeObject(bibCat.displayBibTex());
		out.close(); 
		s.close();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	}

}
