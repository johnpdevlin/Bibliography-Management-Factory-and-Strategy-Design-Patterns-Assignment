package oopAssignment4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public interface BibFileReader {
	/***
	 * 
	 * @param filename
	 * @throws IOException
	 * Take filename and read to object
	 */

	public default void readFromFile(String filename) throws IOException {
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream s = new ObjectInputStream(in); 
			Catalogue cat = (Catalogue)s.readObject();
			in.close();
			s.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		
	}
	
}
