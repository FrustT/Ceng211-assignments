package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *	This class handles file operations needed for the other classes.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class FileIO {
	
	private FileIO() {//To prevent initialisation of this class.
		
	}

	public static final String NEWLINE_SEPERATOR = "\r?\n";
	
	/**
	 * Reads the orders from csv file and puts them in a list of String.
	 * @param path
	 * @return
	 */
	public static List<String> getOrdersFromFile(String path) {

		String stringContent = readFileAsString(path);

		StringTokenizer newLineTokenizer = new StringTokenizer(stringContent, NEWLINE_SEPERATOR);

		List<String> result = new ArrayList<>();
		while (newLineTokenizer.hasMoreTokens()) {
			result.add(newLineTokenizer.nextToken());
		}
		return result;
	}

	private static String readFileAsString(String _path) {//Reads the whole file as a string.
		String content = "";
		try (Scanner s = new Scanner(new FileReader(_path)).useDelimiter("\\A")) {// Try-with-resources automatically
																					// closes the scanner
			content = s.next();

		} catch (FileNotFoundException e) {
			System.out.println("The file you requested has not found.");
			e.printStackTrace();
		}

		return content;
	}
}
