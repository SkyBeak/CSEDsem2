import java.io.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CSVWriter	{

    FileWriter entryWriter;
    FileWriter userWriter;

    public CSVWriter(){

    }

    public void addEntry(int type, int calories){
        try {
            entryWriter = new FileWriter(new File("src/entries.csv"),true);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
            Calendar c = Calendar.getInstance();
            String date = sdf.format(c.getTime());
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
    public void addUser(String name, int height, String age, String sex, int weight, int targetWeight){
        try{
            userWriter = new FileWriter(new File("src/users.csv"), true);
            userWriter.write("\n"+ name + "," + sex + "," + height + "," + weight + "," + age + "," +targetWeight);
            System.out.println("New user written to file");
            userWriter.close();
        } catch (IOException e) {
            System.err.println("Unable to write to file");
            System.exit(1);
        }
    }
    
    public void addWeight(int weight){
        try{
            userWriter = new FileWriter(new File("src/weight.csv"), true);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
            Calendar c = Calendar.getInstance();
            String date = sdf.format(c.getTime());
            userWriter.write(weight + "," + date);
            System.out.println("New weight written to file");
            userWriter.close();
        } catch (IOException e) {
            System.err.println("Unable to write to file");
            System.exit(1);
        }
    }

}
