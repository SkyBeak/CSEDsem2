import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader
{
	String csvFile = "C:/Users/alexb/Documents/Uni/CM10251/csv.csv";
	String line = "";
	String csvSplit = ",";
	
	public CSVReader()
	{
		read();
	}
	
	public void read()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null)
			{
				String[] fields = line.split(csvSplit);
				System.out.println("ID: " + fields[0]);
				System.out.println("Name: " + fields[1]);
				System.out.println("Gender: " + fields[2]);
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
	
	public void write()
	{
		
	}
	
	public static void main(String[] args)
	{
		new CSVReader();
	}
}
