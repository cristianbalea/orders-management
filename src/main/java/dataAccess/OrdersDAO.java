package dataAccess;

import model.Orders;
import connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersDAO extends AbstractDAO<Orders> {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM orders where ordersID = ?";
    private final static String findAllStatementString = "SELECT * from orders";

    /**
     * Metoda pentru gasirea unei comenzi in baza de date, in functie de ID.
     *
     * @param orderID
     * @return
     */
    @Override
    public Orders findById(int orderID) {
        Orders toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, orderID);
            rs = findStatement.executeQuery();
            rs.next();

            int clientID = rs.getInt("clientID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            toReturn = new Orders(orderID, clientID, productID, quantity);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrdersDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Metoda pentru luarea tuturor comenzilor din baza de date.
     *
     * @return
     */
    public List<Orders> findAll() {
        List<Orders> list = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;

        try {
            findAllStatement = dbConnection.prepareStatement(findAllStatementString);
            rs = findAllStatement.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4));
                list.add(o);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrdersDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }
}
