package business;

import dataAccess.ProductDAO;
import model.Product;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {
    /**
     * Se declara un obiect de tip ProductDAO pentru a avea acces la metodele
     * din ProductDAO si AbstractDAO.
     */
    ProductDAO productDAO = new ProductDAO();

    /**
     * Metoda pentru a gasi un produs dupa ID-ul lui.
     *
     * @param id
     * @return
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            JOptionPane.showMessageDialog(null, "Produs inexistent!");
            throw new NoSuchElementException("The product with productID =" + id + " was not found!");
        }
        return product;
    }

    /**
     * Metoda pentru a insera un produs in baza de date.
     *
     * @param product
     * @return
     */
    public Product insertProduct(Product product) {
        return productDAO.insert(product);
    }

    /**
     * Metoda pentru a sterge un produs din baza de date pe baza ID-ului sau.
     *
     * @param productID
     */
    public void deleteProduct(int productID) {
        productDAO.delete(productID);
    }

    /**
     * Metoda pentru a lua toate produsele din baza de date.
     * Sunt create obiecte de tip Product, puse intr-o lista si returnate.
     *
     * @return
     */
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    /**
     * Metoda pentru a actualiza datele despre un produs din baza de date.
     *
     * @param product
     * @return
     */
    public Product updateProduct(Product product) {
        return productDAO.update(product, product.getProductID());
    }
}
