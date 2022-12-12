package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

import furniturefactory.adt.Pair;
import furniturefactory.classes.*;
import furniturefactory.dataclasses.FurnitureData;
import furniturefactory.dataclasses.FurnitureID;
import furniturefactory.dataclasses.FurnitureParts;
import furniturefactory.dataclasses.MaterialData;
import furniturefactory.dataclasses.MaterialID;
import furniturefactory.dataclasses.RawMaterialProperties;
import furniturefactory.interfaces.*;

public class FileIO {

	private FileIO() {// To prevent any initialization of FileIO
	}

	private static final String LINE_SEPERATOR = "\r?\n";

	public static RawMaterialProperties getRawMaterialPropertiesFromFile(String path) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, LINE_SEPERATOR);
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
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, LINE_SEPERATOR);
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		FurnitureParts result = new FurnitureParts();
		int tokenCount = newLineTokenizer.countTokens();
		for (int i = 0; i < tokenCount; i++) {
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			FurnitureID id = FurnitureID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
			List<Pair<MaterialID, Integer>> requirementPairs = new ArrayList<>();

			while (inLineTokenizer.hasMoreTokens()) {

				MaterialID materialID = MaterialID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
				int count = Integer.parseInt(inLineTokenizer.nextToken());
				Pair<MaterialID, Integer> materialWithCount = new Pair<>(materialID, count);
				requirementPairs.add(materialWithCount);
			}

			FurnitureData newData = new FurnitureData(id, requirementPairs);
			result.addPropertiesRow(newData);
		}

		return result;
	}

	public static IVendor getVendorFromFile(String path, RawMaterialProperties MaterialData) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, LINE_SEPERATOR);
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		IVendor result = new Vendor();
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

	public static List<Pair<FurnitureID, Integer>>[] getFurnituresToCraft(String path) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, LINE_SEPERATOR);
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		int tokenCount = newLineTokenizer.countTokens();
		List<Pair<FurnitureID, Integer>>[] result = new ArrayList[tokenCount];
		for (int i = 0; i < tokenCount; i++) {
			List<Pair<FurnitureID, Integer>> dayList = new ArrayList<>();
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			inLineTokenizer.nextToken();// to skip day integer
			while (inLineTokenizer.hasMoreTokens()) {
				FurnitureID id = FurnitureID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
				int count = Integer.parseInt(inLineTokenizer.nextToken());
				Pair<FurnitureID, Integer> furnitureCountPair = new Pair<>(id, count);
				dayList.add(furnitureCountPair);
			}
			result[i] = dayList;
		}
		return result;
	}

	public static List<Pair<MaterialID, Integer>>[] getMaterialsToBuy(String path) {

		String fileContent = readFileAsString(path);

		// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, LINE_SEPERATOR);
		// This tokenizer's responsibility is gathering next data in one object's line
		// Since every line will be different so each inLineTokenizer needs to
		// initialize in the loop
		StringTokenizer inLineTokenizer;

		int tokenCount = newLineTokenizer.countTokens();
		List<Pair<MaterialID, Integer>>[] result = new ArrayList[tokenCount];
		for (int i = 0; i < tokenCount; i++) {
			List<Pair<MaterialID, Integer>> dayList = new ArrayList<>();
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			inLineTokenizer.nextToken();// to skip day integer
			while (inLineTokenizer.hasMoreTokens()) {
				MaterialID id = MaterialID.valueOf(inLineTokenizer.nextToken().toUpperCase(Locale.ROOT));
				int count = Integer.parseInt(inLineTokenizer.nextToken());
				Pair<MaterialID, Integer> MaterialCountPair = new Pair<>(id, count);
				dayList.add(MaterialCountPair);
			}
			result[i] = dayList;
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
	 * @param_path path of the file.
	 * @return String Contents of the file.
	 */
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
	/********************************
	 * TODO********************************************* Farklı günler arraylistin
	 * içerisine konur bu günler içerisinde 2 data tutar 1-o gün alıncak materialler
	 * Deque 2-o gün yapılacak işler deque
	 * 
	 * 1'in içerinse pair olacak pairin ilk değeri material id 2. ise count 2'nin
	 * içeriinde pair olacak ilk değeri furniture id 2. ise count
	 * 
	 * her bir gün başlangıcında gidilip o günün pairini getiricek.
	 ************************************************************************/
}
