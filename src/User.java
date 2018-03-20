public class User {

    private int height;
    private int age;
    private String sex;

    public User(){
        this.height = 0;
        this.age = 0;
        this.sex = "";
    }

    public User(int h, int a, String s){
        this.height = h;
        this.age = a;
        this.sex = s;
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
