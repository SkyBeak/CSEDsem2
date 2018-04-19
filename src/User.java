public class User {

    //height in cm
    private int height;
    private int age;
    private int weight;
    private String sex;
    private String targetTime;
    private int targetWeight;


    public User(){
        this.height = 0;
        this.age = 0;
        this.sex = "";
        this.weight = 0;
        this.targetTime = "";
        this.targetWeight = 0;
    }

    public User(int h, int a, int w, String s, String t, int targetWeight){
        this.height = h;
        this.age = a;
        this.sex = s;
        this.weight = w;
        this.targetTime = t;
        this.targetWeight = targetWeight;
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

}
