import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {

    //height in cm
    private String name;
    private int height;
    private int age;
    private int weight;
    private String sex;
    private int targetWeight;

    private String dob;

    public User(){
        this.name = "";
        this.height = 0;
        this.age = 0;
        this.sex = "";
        this.weight = 0;
        this.targetWeight = 0;
        this.dob = "25/04/2018";
    }

    //make it take date od birth and calculate age
    public User(String n ,int h, String dob, int w, String s){
        this.name = n;
        this.height = h;
        this.sex = s;
        this.weight = w;
        this.dob = dob;

        //cacualtes age from dob
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());
        this.age = ageCalc(dob, date);
    }

    //make it take date od birth and calculate age
    public User(String n, int h, String dob, int w, String s, int targetWeight){
        this.name = n;
        this.height = h;
        this.sex = s;
        this.weight = w;
        this.targetWeight = targetWeight;
        this.dob = dob;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());
        this.age = ageCalc(dob, date);
    }

    public void print(){
        String toPrint = "---------------\n";
        if (sex=="") {
            toPrint += "\nAge:" + this.age + "\nHeight:" + this.height + "\n---------------";
        } else {
            toPrint += "\nAge:" + this.age + "\nHeight:" + this.height + "\n Sex:" + this.sex + "\n---------------";
        }
        System.out.println(toPrint);

    }

    private int ageCalc(String dob, String currentDate){
        int days = Integer.parseInt(currentDate.substring(0,2)) - Integer.parseInt(dob.substring(0,2));
        int months = Integer.parseInt(currentDate.substring(3,5)) - Integer.parseInt(dob.substring(3,5));
        int years = Integer.parseInt(currentDate.substring(6,10)) - Integer.parseInt(dob.substring(6,10));
        return (years*365 + months*30 + days)/365;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int h){
        this.height = h;
    }

    public void setAge(int a){
        this.age = a;
    }

    public void setSex(String s){
        this.sex = s;
    }

    public void setWeight(int w){
        this.weight = w;
    }

    public void setTargetWeight(int w){
        this.targetWeight = w;
    }

    public String getName() {
        return name;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getHeight(){
        return this.height;
    }

    public int getAge(){
        return this.age;
    }

    public String getSex(){
        return this.sex;
    }

    public int getTargetWeight(){
        return this.targetWeight;
    }

    public String getDOB(){
        return this.dob;
    }

    
}
