package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

import furniturefactory.classes.*;

public class FileIO {

	public static RawMaterialProperties getRawMaterialPropertiesFromFile(String path) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, "\r?\n");
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		RawMaterialProperties result = new RawMaterialProperties();
		int tokenCount = newLineTokenizer.countTokens();
		for (int i = 0; i < tokenCount; i++) {
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			MaterialID id = MaterialID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
			int length = Integer.parseInt(inLineTokenizer.nextToken());
			int width = Integer.parseInt(inLineTokenizer.nextToken());
			int height = Integer.parseInt(inLineTokenizer.nextToken());
			int cost = Integer.parseInt(inLineTokenizer.nextToken());

			MaterialData newData = new MaterialData(id, length, width, height, cost);
			result.addPropertiesRow(newData);
		}

		return result;
	}

	public static FurnitureParts getFurniturePartsFromFile(String path) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, "\r?\n");
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		FurnitureParts result = new FurnitureParts();
		int tokenCount = newLineTokenizer.countTokens();
		for (int i = 0; i < tokenCount; i++) {
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			FurnitureID id = FurnitureID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
			List<Pair<MaterialID, Integer>> requirementPairs = new ArrayList<Pair<MaterialID, Integer>>();

			while (inLineTokenizer.hasMoreTokens()) {

				MaterialID materialID = MaterialID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
				int count = Integer.parseInt(inLineTokenizer.nextToken());
				Pair<MaterialID, Integer> materialWithCount = new Pair<MaterialID, Integer>(materialID, count);
				requirementPairs.add(materialWithCount);
			}

			FurnitureData newData = new FurnitureData(id, requirementPairs);
			result.addPropertiesRow(newData);
		}

		return result;
	}

	public static Vendor getVendorFromFile(String path, RawMaterialProperties MaterialData) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, "\r?\n");
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		Vendor result = new Vendor();
		int tokenCount = newLineTokenizer.countTokens();
		for (int i = 0; i < tokenCount; i++) {
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			MaterialID id = MaterialID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
			MaterialData dataOfMaterial = MaterialData.getPropertiesDataFromID(id);
			int quality = Integer.parseInt(inLineTokenizer.nextToken());
			Material newData = new Material(dataOfMaterial, quality);
			result.addMaterial(newData);
		}

		return result;
	}

	/**
	 * For reading CSV files, gathering line count was important for initializing
	 * correct size array. So, Buffer reading approach has been implemented.
	 * <p>
	 * This class uses a special delimiter "\\A" that indicates file's starting
	 * point. So , this delimiter ensures that we will only get one token from the
	 * scanner.
	 * 
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
