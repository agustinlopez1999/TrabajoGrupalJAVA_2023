package Domain_classes;

/**
 * The Client class represents a client associated with a stand in a fair.
 * It includes attributes such as a client number and a name.
 */
public class Client {
    private int number;
    private String name;

    /**
     * Constructs a Client object with no initial values.
     */
    public Client() {
    }

    /**
     * Constructs a Client object with the specified client number and name.
     *
     * @param number The unique identifier for the client.
     * @param name   The name of the client.
     */
    public Client(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * Retrieves the client number.
     *
     * @return The client number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Retrieves the name of the client.
     *
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the client number.
     *
     * @param number The new client number.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Sets the name of the client.
     *
     * @param name The new name of the client.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the Client object.
     *
     * @return A string containing the client number and name of the client.
     */
    @Override
    public String toString() {
        return "Client{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
