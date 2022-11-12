package vehiclepricecalculatorapp;

import java.util.ArrayList;

import fileoperations.FileIO;
import vehiclepricecalculator.classes.*;

public class VehiclePriceApp {
	public static void main (String[] args){
		ArrayList<Vehicle> arr = FileIO.getAllSalesAsArrayList();
		for(Vehicle vehicle : arr) {
			System.out.println(vehicle);
		}
	}
}