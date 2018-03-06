import java.io.*;
import java.util.ArrayList;


public class UI	{
	
	public static void main(String[] args){
		UI textInterface = new UI();
	}
	
	public UI(){

		printAllEntries();
		
	}
	
	//test method to check the CSVReader code actually works
	private void printAllEntries(){
		CSVReader entryReader = new CSVReader();
		ArrayList<Entry> allEntries = entryReader.readEntries("src/entries.csv");
		for(int i = 0; i<allEntries.size();i++){
			allEntries.get(i).print();
		}
	}
	
	
}