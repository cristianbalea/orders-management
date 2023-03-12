package business;

import dataAccess.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    /**
     * Se declara un obiect clientDAO de tip ClientDAO pentru a avea acces la metodele implementate atat in
     * ClientDAO cat si in AbstractDAO.
     */
    private ClientDAO clientDAO = new ClientDAO();

    /**
     * Metoda pentru a gasi un client in baza de date dupa ID-ul lui.
     * Metoda returneaza clientul gasit, sau arunca o exceptie in caz contrar.
     *
     * @param id
     * @return
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "Client inexistent!");
            throw new NoSuchElementException("The client with clientID =" + id + " was not found!");
        }
        return client;
    }

    /**
     * Metoda pentru a insera un client in baza de date.
     * Metoda returneaza clientul inserat.
     *
     * @param client
     * @return
     */
    public Client insertClient(Client client) {
        return clientDAO.insert(client);
    }

    /**
     * Metoda pentru a sterge un client din baza de date pe baza ID-ului sau.
     *
     * @param clientID
     */
    public void deleteClient(int clientID) {
        clientDAO.delete(clientID);
    }

    /**
     * Metoda pentru a lua toti clientii din baza de date.
     * Este returnata o lista de obiecte de tip Client.
     *
     * @return
     */
    public List<Client> findAllClients() {
        return clientDAO.findAll();
    }

    /**
     * Metoda pentru a actualiza datele unui client.
     * Se returneaza clientul care a fost inserat.
     *
     * @param client
     * @return
     */
    public Client updateClient(Client client) {
        return clientDAO.update(client, client.getClientID());
    }
}
