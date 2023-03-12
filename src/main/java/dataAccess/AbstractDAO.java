package dataAccess;

import java.lang.reflect.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Metoda pentru crearea query-ului pentru INSERT.
     *
     * @return
     */
    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" (");
        for (Field f : type.getDeclaredFields()) {
            if (!f.equals(type.getDeclaredFields()[0]))
                sb.append(f.getName() + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") VALUES (?, ?, ?)");
        return sb.toString();
    }

    /**
     * Metoda pentru crearea query-ului pentru DELETE.
     *
     * @return
     */
    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append("ID = ?");
        return sb.toString();
    }

    /**
     * Metoda pentru crearea query-ului pentru DELETE in tabela orders,
     * in urma unui query de DELETE asupra tabelelor product sau client.
     *
     * @return
     */
    private String createDeleteOrdersQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM orders WHERE ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append("ID = ?");
        return sb.toString();
    }

    /**
     * Metoda pentru crearea query-ului de UPDATE in tabela.
     *
     * @return
     */
    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for (Field f : type.getDeclaredFields()) {
            if (!f.equals(type.getDeclaredFields()[0])) {
                sb.append(f.getName());
                sb.append("=?, ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" WHERE ");
        sb.append(type.getSimpleName());
        sb.append("ID = ?");
        return sb.toString();
    }

    /**
     * Metoda pentru luarea datelor din tabele sub forma de obiecte Product, Client sau Orders.
     * Metoda este implementata de fiecare clasa in parte.
     *
     * @return
     */
    public List<T> findAll() {
        return null;
    }

    /**
     * Metoda pentru gasirea unui obiect de tip Product, Client sau Orders.
     * Metoda este implementata de fiecare clasa in parte.
     *
     * @param id
     * @return
     */
    public T findById(int id) {
        return null;
    }

    /**
     * Metoda generica pentru inserarea unui obiect in baza de date.
     *
     * @param t
     * @return
     */
    public T insert(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement insertStatement = null;
        int i = 1;
        try {
            insertStatement = dbConnection.prepareStatement(createInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            for (Field f : type.getDeclaredFields()) {
                if (!f.equals(type.getDeclaredFields()[0])) {
                    f.setAccessible(true);
                    Object obj = f.get(t);
                    insertStatement.setString(i, obj.toString());
                    i++;
                }

            }
            insertStatement.executeUpdate();

            rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                Field f = type.getDeclaredField(type.getSimpleName().toLowerCase() + "ID");
                f.setAccessible(true);
                f.set(t, id);
            }
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    /**
     * Metoda generica pentru stergerea unui obiect din baza de date, dupa ID.
     *
     * @param id
     */
    public void delete(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        PreparedStatement deleteOrdersStatement = null;
        try {
            deleteOrdersStatement = dbConnection.prepareStatement(createDeleteOrdersQuery(), Statement.NO_GENERATED_KEYS);
            deleteOrdersStatement.setInt(1, id);
            deleteOrdersStatement.executeUpdate();
            deleteStatement = dbConnection.prepareStatement(createDeleteQuery(), Statement.NO_GENERATED_KEYS);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:delete" + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Metoda generica pentru actualizarea unui obiect din baza de date.
     *
     * @param t
     * @param id
     * @return
     */
    public T update(T t, int id) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        int i = 1;
        try {
            updateStatement = dbConnection.prepareStatement(createUpdateQuery(), Statement.NO_GENERATED_KEYS);
            for (Field f : type.getDeclaredFields()) {
                if (!f.equals(type.getDeclaredFields()[0])) {
                    f.setAccessible(true);
                    Object obj = f.get(t);
                    updateStatement.setString(i, obj.toString());
                    i++;
                }
            }
            updateStatement.setString(i, String.valueOf(id));
            updateStatement.executeUpdate();

            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }
}
