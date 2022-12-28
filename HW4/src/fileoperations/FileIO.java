package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIO {
	
	private FileIO() {
		
	}

	public static final String NEWLINE_SEPERATOR = "\r?\n";

	public static List<String> getOrdersFromFile(String path) {

		String stringContent = readFileAsString(path);

		StringTokenizer newLineTokenizer = new StringTokenizer(stringContent, NEWLINE_SEPERATOR);

		List<String> result = new ArrayList<>();
		while (newLineTokenizer.hasMoreTokens()) {
			result.add(newLineTokenizer.nextToken());
		}
		return result;
	}

	private static String readFileAsString(String _path) {
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
