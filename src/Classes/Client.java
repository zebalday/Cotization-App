package Classes;


public class Client {
    
    // DATA
    private int ID;
    private String name;
    private String cellphone;
    private String email;

    // CONSTRUCTORS
    public Client(String name, String cellphone, String email) {
        this.name = name;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Client() {
    }

    // SETTERS
    public void setID(int ID) {
        this.ID = ID;
    }
       
    public void setName(String name) {
        this.name = name;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // GETTERS
    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    // ToString
    @Override
    public String toString() {
        return "Client{" + "ID=" + ID + ", name=" + name + ", cellphone=" + cellphone + ", email=" + email + '}';
    }
    
    
    
}
