import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class that reads from .csv files.
 * @author ajb258
 * @version 1.0
 * @release N/A
 */

public class CSVReader
{
	String csvFile = "example.csv";
	String line = "";
	String csvSplit = ",";
	
	/**
	 * Constructor. Calls the read() method.
	 */
	
	public CSVReader()
	{
		read();
	}
	
	/**
	 * Method that reads from a .csv file, and displays the contents in the console.
	 */
	
	public void read()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
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
					System.out.println("ID: " + fields[0]);
					System.out.println("Name: " + fields[1]);
					System.out.println("Age: " + fields[2]);
					System.out.println("Gender: " + fields[3] + "\n");
				}	
			}
			
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new CSVReader();
	}
}
