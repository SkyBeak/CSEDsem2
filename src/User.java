public class User {

    private int height;
    private int age;
    private int weight;
    private String targetTime;
    private String gender;
    private String name;
    private int targetWeight;

    public User(){
        this.height = 0;
        this.weight = 0;
        this.age = 0;
        this.gender = "";
        this.name = "";
        this.targetWeight = 0;
        this.targetTime = "";
    }

    public User(String n, String g, int h, int w, int a, int targetWeight, String targetTime){
        setName(n);
        setGender(g);
    	setHeight(h);
        setWeight(w);
        setAge(a);
        setTargetWeight(targetWeight);
        setTargetTime(targetTime);
    }

    /*
     * prints out information about a user
     */
    public void print(){
        String toPrint = "---------------\n";
        if (gender=="") {
            toPrint += "\nAge:" + this.age + "\nHeight:" + this.height + "\n---------------";
        } else {
            toPrint += "\nAge:" + this.age + "\nHeight:" + this.height + "\n gender:" + this.gender + "\n---------------";
        }
        System.out.println(toPrint);

    }
    
    public void saveUser(){
    	
    }
    
    public void setTargetWeight(int t){
    	this.targetWeight = t;
    }

    public void setHeight(int h){
        this.height = h;
    }

    public void setAge(int a){
        this.age = a;
    }

    public void setGender(String g){
        this.gender = g;
    }
    
    public void setName(String n){
    	this.name = n;
    }
    
    public void setWeight(int w){
    	this.weight = w;
    }
    
    public void setTargetTime(String t){
    	this.targetTime = t;
    }


    public int getTarget(){
    	return this.targetWeight;
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

    public String getGender(){
        return this.gender;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public String getTargetTime(){
    	return this.targetTime;
    }

}
