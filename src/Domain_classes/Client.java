package Domain_classes;

public class Client {
    private int number;
    private String Name;
    private String LastName;
    private String Bussines;

    public Client() {
    }
    public Client(int number, String name, String lastName) {
        this.number = number;
        Name = name;
        LastName = lastName;
    }

    public Client(int number, String bussines) {
        this.number = number;
        Bussines = bussines;
    }
    //Getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getBussines() {
        return Bussines;
    }

    //Setters

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setBussines(String bussines) {
        Bussines = bussines;
    }

    @Override
    public String toString() {
        return "Client{" +
                "number=" + number +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Bussines='" + Bussines + '\'' +
                '}';
    }
}
