package model;

public class Client {
    /**
     * Declararea atributelor ce modeleaza obiectul de tip Client.
     */
    private int clientID;
    private String clientName;
    private String clientAddress;
    private String clientEmail;

    /**
     * Constructor cu 3 parametrii.
     *
     * @param clientName
     * @param clientAddress
     * @param clientEmail
     */
    public Client(String clientName, String clientAddress, String clientEmail) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
    }

    /**
     * Constructor cu 4 parametrii, inclusiv ID-ul.
     *
     * @param clientId
     * @param clientName
     * @param clientAddress
     * @param clientEmail
     */
    public Client(int clientId, String clientName, String clientAddress, String clientEmail) {
        this.clientID = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
