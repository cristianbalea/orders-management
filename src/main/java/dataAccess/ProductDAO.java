package dataAccess;

import model.Product;
import connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends AbstractDAO<Product> {
    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM product where productID = ?";
    private final static String findAllStatementString = "SELECT * from product";

    /**
     * Metoda pentru gasirea unui produs din baza de date, dupa ID-ul lui.
     *
     * @param productID
     * @return
     */
    @Override
    public Product findById(int productID) {
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, productID);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("productName");
            int price = rs.getInt("productPrice");
            int stock = rs.getInt("productStock");
            toReturn = new Product(productID, name, price, stock);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Metoda pentru luarea tuturor obiectelor de tip Product din baza de date.
     *
     * @return
     */
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;

        try {
            findAllStatement = dbConnection.prepareStatement(findAllStatementString);
            rs = findAllStatement.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }
}
