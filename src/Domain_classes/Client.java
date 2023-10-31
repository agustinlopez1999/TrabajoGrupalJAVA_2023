package Domain_classes;

public class Client {
    private int number;
    private String Name;

    public Client() {
    }
    public Client(int number, String name) {
        this.number = number;
        Name = name;
    }
    //Getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return Name;
    }

    //Setters

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "number=" + number +
                ", Name='" + Name + '\'' +
                '}';
    }
}
