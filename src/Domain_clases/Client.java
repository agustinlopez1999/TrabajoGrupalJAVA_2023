package Domain_clases;

public class Client {
    private int number;
    private String Names;
    private String LastName;
    private String Bussines;

    public Client(int number, String name, String lastName) {
        this.number = number;
        Name = name;
        LastName = lastName;
    }

    public Client(int number, String bussines) {
        this.number = number;
        Bussines = bussines;
    }

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
