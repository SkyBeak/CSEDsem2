public class Meal {
    private String name;
    private int calories;

    public Meal(String n, int c){
        this.name = n;
        this.calories = c;
    }

    public String getName(){
        return this.name;
    }

    public int getCalories(){
        return this.calories;
    }
}
