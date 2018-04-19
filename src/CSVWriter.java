import java.io.*;
import java.time.LocalDateTime;

public class CSVWriter	{
	
	FileWriter entryWriter;
	FileWriter userWriter;
	
	public CSVWriter(){
		
	}
	
	public void addEntry(int type, int calories){
		try {
			entryWriter = new FileWriter(new File("src/entries.csv"),true);
			String date = LocalDateTime.now().toString().substring(0, 10);
			entryWriter.write("\n"+type+","+calories+","+date+",");
			System.out.println("entry written to file");
			entryWriter.close();
		} catch (IOException e) {
			System.err.println("Unable to write to file");
			System.exit(1);
		}
	}
	
	/* adds user to user.csv file
	 * Now not really needed I guess?*/
    	public void addUser(int height, int age, String sex){
        	try{
            		userWriter = new FileWriter(new File("src/users.csv"), true);
            		userWriter.write("\n"+height+","+age+","+sex+",");
            		System.out.println("New user written to file");
            		userWriter.close();
        	} catch (IOException e) {
            		System.err.println("Unable to write to file");
            		System.exit(1);
        }
    }
	
}
