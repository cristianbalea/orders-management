package dataAccess;

import model.Client;
import connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<Client> {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM client where clientID = ?";
    private final static String findAllStatementString = "SELECT * from client";

    /**
     * Metoda pentru gasirea unui client in functie de ID-ul lui.
     *
     * @param clientID
     * @return
     */
    @Override
    public Client findById(int clientID) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientID);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("clientName");
            String address = rs.getString("clientAddress");
            String email = rs.getString("clientEmail");
            toReturn = new Client(clientID, name, address, email);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Metoda pentru luarea tuturor clientilor din baza de date.
     *
     * @return
     */
    public List<Client> findAll() {
        List<Client> list = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;

        try {
            findAllStatement = dbConnection.prepareStatement(findAllStatementString);
            rs = findAllStatement.executeQuery();
            while (rs.next()) {
                Client c = new Client(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                list.add(c);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }
}
