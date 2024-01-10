
package Classes;



public class Case {
    
    // DATA FROM FORM
    private int type;
    private int language;
    private int exercise_number;
    private int days;
    // GENERATED DATA
    private int client;
    public float price;

    
    // CONSTRUCTORS
    public Case(int type, int language, int exercise_number, int days) {
        this.type = type;
        this.language = language;
        this.exercise_number = exercise_number;
        this.days = days;
    }

    public Case() {
    }
    
    // SETTERS
    public void setClient(int client) {
        this.client = client;
    }
    
    public void setType(int type) {
        this.type = type;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setExercise_number(int exercise_number) {
        this.exercise_number = exercise_number;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // GETTERS
    public int getClient(){
        return client;
    }
    
    public int getType() {
        return type;
    }

    public int getLanguage() {
        return language;
    }

    public int getExercise_number() {
        return exercise_number;
    }

    public int getDays() {
        return days;
    }

    public float getPrice() {
        return price;
    }

    // ToString
    @Override
    public String toString() {
        return "Case{" + "type=" + type + ", language=" + language + ", exercise_number=" + exercise_number + ", days=" + days + ", client=" + client + ", price=" + price + '}';
    }
    
    
}
