import java.io.*;
import java.util.ArrayList;

/**
 * A class that reads from .csv files.
 * @author ajb258
 * @version 1.0
 * @release N/A
 */

public class CSVReader
{
	String csvFile = "src/entries.csv";
	String line = "";
	String csvSplit = ",";
	
	/**
	 * Constructor. Calls the read() method.
	 */
	
	public CSVReader()
	{
		//read(csvFile);
	}
	
	/**
	 * Method that reads from a .csv file, and displays the contents in the console.
	 */
	
	public ArrayList<Entry> readEntries(String toRead)
	{
		
		ArrayList<Entry> allEntries = new ArrayList<Entry>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(toRead));
			int iteration = 0;
			while ((line = br.readLine()) != null)
			{
				// If statement prevents headers of csv file from being displayed.
				if (iteration == 0)
				{
					iteration++;
				}
				else
				{
					String[] fields = line.split(csvSplit);
					int entryType = Integer.parseInt(fields[0]);
					int entryUser = Integer.parseInt(fields[1]);
					Entry currentEntry = new Entry(entryType,entryUser,fields[2],fields[3]);
					allEntries.add(currentEntry);	
				}	
			}
			
			br.close();
			return allEntries;
			
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Entry> SearchFor(String searchTerm){
		ArrayList<Entry> allFound = new ArrayList<Entry>();
		
		return allFound;
	}
	
	public static void main(String[] args)
	{
		new CSVReader();
	}
}
