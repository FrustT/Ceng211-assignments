package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileIO {
	
	/**
	 * For reading CSV files, gathering line count was important for initializing correct size array.
	 * So, Buffer reading approach has been implemented.
	 * <p>
	 * This class uses a special delimiter "\\A" that indicates file's starting point.
	 * So , this delimiter ensures that we will only get one token from the scanner.
	 * @param _path path of the file.
	 * @return String Contents of the file.
	 */
	private static String readFileAsString(String _path) {
		String content = "";
		
		try {
			Scanner s = new Scanner(new FileReader(_path)).useDelimiter("\\A");	
			content = s.next();
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file you requested has not found.");
			e.printStackTrace();
		
		}
		
		return content;
	}
}
