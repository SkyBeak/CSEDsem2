import java.io.*;
import java.util.ArrayList;


public class UI	{
	
	CSVReader entryReader;
	
	public static void main(String[] args){
		UI textInterface = new UI();
	}
	/**
	 * constructor, currently just sets up an entry reader and runs any test methods.
	 */
	public UI(){

		entryReader  = new CSVReader();
		//printAllEntries();
		printSearchResults("xxxx", "1");
		
	}
	
	//test method to check the CSVReader code actually works
	private void printAllEntries(){
		ArrayList<Entry> allEntries = entryReader.readEntries("src/entries.csv");
		for(int i = 0; i<allEntries.size();i++){
			allEntries.get(i).print();
		}
	}
	//test method to check CSVReader search works
	private void printSearchResults(String field, String value){
		ArrayList<Entry> results = searchFor(field,value);
		for(int i = 0; i<results.size();i++){
			results.get(i).print();
		}
	}
	
	/**
	 * 
	 * @param field: the name of the field to be searched for
	 * @param value: a string representing the value of the field to be searched for
	 * @return: an ArrayList of entries retrieved from the csv file containing the correct field values.
	 */
	private ArrayList<Entry> searchFor(String field, String value){
		ArrayList<Entry> found = entryReader.SearchFor(field.toUpperCase(), value);
		return found;
	}
	
	
}