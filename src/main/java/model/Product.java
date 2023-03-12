package model;

public class Product {
    /**
     * Declararea atributelor ce modeleaza un Produs.
     */
    private int productID;
    private String productName;
    private int productPrice;
    private int productStock;

    /**
     * Constructor cu 3 parametrii.
     *
     * @param name
     * @param price
     * @param stock
     */
    public Product(String name, int price, int stock) {
        this.productName = name;
        this.productPrice = price;
        this.productStock = stock;
    }

    /**
     * Constructor cu 4 parametrii, inclusiv ID-ul.
     *
     * @param productID
     * @param productName
     * @param productPrice
     * @param productStock
     */
    public Product(int productID, String productName, int productPrice, int productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
