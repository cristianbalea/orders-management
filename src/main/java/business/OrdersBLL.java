package business;

import dataAccess.OrdersDAO;
import model.Orders;

import java.util.List;

public class OrdersBLL {
    /**
     * Se declara un obiect de tip OrdersDAO pentru a avea acces atat la metodele din
     * OrdersDAO cat si din AbstractDAO.
     */
    private OrdersDAO ordersDAO = new OrdersDAO();

    /**
     * Metoda pentru a insera o comanda noua in baza de date.
     *
     * @param product
     * @return
     */
    public Orders insertOrders(Orders product) {
        return ordersDAO.insert(product);
    }

    /**
     * Metoda pentru a lua toate comenzile din baza de date.
     *
     * @return
     */
    public List<Orders> findAllOrders() {
        return ordersDAO.findAll();
    }
}
