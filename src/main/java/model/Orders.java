package model;

public class Orders {
    /**
     * Declararea atributelor ce modeleaza o comanda.
     */
    private int ordersID;
    private int clientID;
    private int productID;
    private int quantity;

    /**
     * Constructor cu 3 parametrii.
     *
     * @param clientID
     * @param productID
     * @param quantity
     */
    public Orders(int clientID, int productID, int quantity) {
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    /**
     * Constructor cu 4 parametrii, inclusiv ID-ul.
     *
     * @param orderID
     * @param clientID
     * @param productID
     * @param quantity
     */
    public Orders(int orderID, int clientID, int productID, int quantity) {
        this.ordersID = orderID;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(int ordersID) {
        this.ordersID = ordersID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
