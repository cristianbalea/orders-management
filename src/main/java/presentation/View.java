package presentation;

import business.ClientBLL;
import business.OrdersBLL;
import business.ProductBLL;
import model.Client;
import model.Orders;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import static java.awt.Font.BOLD;


class WelcomeView implements ActionListener {
    /**
     * Clasa pentru pagina de pornire.
     * Contine butoane pentru toate actiunile programului,
     * la apasarea carora se vor deschide interfete corespunzatoare.
     */
    private JFrame frame = new JFrame("Welcome!");
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel panel = new JPanel();
    private JLabel labelClients = new JLabel("Clients");
    private JLabel labelProducts = new JLabel("Products");
    private JLabel labelOrders = new JLabel("Orders");
    private Font font = new Font("Times New Roman", BOLD, 20);
    private JButton btnAddClient = new JButton("Add");
    private JButton btnEditClient = new JButton("Edit");
    private JButton btnDeleteClient = new JButton("Delete");
    private JButton btnShowClients = new JButton("Show all");
    private JButton btnAddProduct = new JButton("Add");
    private JButton btnEditProduct = new JButton("Edit");
    private JButton btnDeleteProduct = new JButton("Delete");
    private JButton btnShowProducts = new JButton("Show all");
    private JButton btnNewOrder = new JButton("New order");
    private JButton btnOrders = new JButton("Orders");
    private Color backgroundColor = new Color(208, 204, 177);

    public WelcomeView() {
        labelClients.setBounds(50, 5, 150, 30);
        labelProducts.setBounds(50, 5, 150, 30);
        labelOrders.setBounds(50, 5, 150, 30);

        btnAddClient.setBounds(20, 60, 150, 30);
        btnEditClient.setBounds(20, 95, 150, 30);
        btnDeleteClient.setBounds(20, 130, 150, 30);
        btnShowClients.setBounds(20, 165, 150, 30);

        btnAddProduct.setBounds(20, 60, 150, 30);
        btnEditProduct.setBounds(20, 95, 150, 30);
        btnDeleteProduct.setBounds(20, 130, 150, 30);
        btnShowProducts.setBounds(20, 165, 150, 30);

        btnNewOrder.setBounds(20, 95, 150, 30);
        btnOrders.setBounds(20, 130, 150, 30);

        p1.add(btnAddClient);
        p1.add(btnEditClient);
        p1.add(btnDeleteClient);
        p1.add(btnShowClients);

        p2.add(btnAddProduct);
        p2.add(btnEditProduct);
        p2.add(btnDeleteProduct);
        p2.add(btnShowProducts);

        p3.add(btnNewOrder);
        p3.add(btnOrders);

        btnAddClient.addActionListener(this);
        btnEditClient.addActionListener(this);
        btnDeleteClient.addActionListener(this);
        btnShowClients.addActionListener(this);
        btnAddProduct.addActionListener(this);
        btnEditProduct.addActionListener(this);
        btnDeleteProduct.addActionListener(this);
        btnShowProducts.addActionListener(this);
        btnNewOrder.addActionListener(this);
        btnOrders.addActionListener(this);

        btnAddClient.setFocusPainted(false);
        btnAddClient.setContentAreaFilled(false);
        btnEditClient.setFocusPainted(false);
        btnEditClient.setContentAreaFilled(false);
        btnDeleteClient.setFocusPainted(false);
        btnDeleteClient.setContentAreaFilled(false);
        btnShowClients.setFocusPainted(false);
        btnShowClients.setContentAreaFilled(false);

        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setContentAreaFilled(false);
        btnEditProduct.setFocusPainted(false);
        btnEditProduct.setContentAreaFilled(false);
        btnDeleteProduct.setFocusPainted(false);
        btnDeleteProduct.setContentAreaFilled(false);
        btnShowProducts.setFocusPainted(false);
        btnShowProducts.setContentAreaFilled(false);

        btnNewOrder.setFocusPainted(false);
        btnNewOrder.setContentAreaFilled(false);
        btnOrders.setFocusPainted(false);
        btnOrders.setContentAreaFilled(false);

        labelClients.setFont(font);
        labelProducts.setFont(font);
        labelOrders.setFont(font);

        p1.add(labelClients);
        p2.add(labelProducts);
        p3.add(labelOrders);

        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);

        p1.setBackground(backgroundColor);
        p2.setBackground(backgroundColor);
        p3.setBackground(backgroundColor);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);

        frame.setSize(580, 300);
        panel.setLayout(new GridLayout());
        frame.setVisible(true);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddClient) {
            AddClientView addClientView = new AddClientView();
        }
        if (e.getSource() == btnEditClient) {
            EditClientView editClientView = new EditClientView();
        }
        if (e.getSource() == btnDeleteClient) {
            RemoveClientView removeClientView = new RemoveClientView();
        }
        if (e.getSource() == btnShowClients) {
            ShowClients showClients = new ShowClients();
        }
        if (e.getSource() == btnAddProduct) {
            AddProductView addProductView = new AddProductView();
        }
        if (e.getSource() == btnEditProduct) {
            EditProductView editProductView = new EditProductView();
        }
        if (e.getSource() == btnDeleteProduct) {
            RemoveProductView removeProductView = new RemoveProductView();
        }
        if (e.getSource() == btnShowProducts) {
            ShowProducts showProducts = new ShowProducts();
        }
        if (e.getSource() == btnNewOrder) {
            NewOrder newOrder = new NewOrder();
        }
        if (e.getSource() == btnOrders) {
            ShowOrders showOrders = new ShowOrders();
        }
    }
}

class AddProductView implements ActionListener {
    /**
     * Clasa pentru interfata de adaugare a unui produs in baza de date.
     */
    private Font font = new Font("Times New Roman", BOLD, 20);
    private JLabel labelTitle = new JLabel("Inserati datele despre produs:");
    private JLabel labelName = new JLabel("Nume:");
    private JLabel labelPrice = new JLabel("Pret:");
    private JLabel labelStock = new JLabel("Stoc:");
    private JTextField textName = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textStock = new JTextField();
    private JButton btnAdd = new JButton("Adauga");
    private JFrame frame = new JFrame("Add new product");
    private JPanel panel = new JPanel();
    private Color backgroundColor = new Color(208, 204, 177);

    public AddProductView() {
        labelTitle.setBounds(5, 5, 300, 30);
        labelName.setBounds(5, 50, 150, 30);
        textName.setBounds(130, 50, 250, 30);
        labelPrice.setBounds(5, 80, 150, 30);
        textPrice.setBounds(130, 80, 250, 30);
        labelStock.setBounds(5, 110, 150, 30);
        textStock.setBounds(130, 110, 250, 30);
        btnAdd.setBounds(130, 145, 250, 30);

        labelName.setFont(font);
        labelTitle.setFont(font);
        labelPrice.setFont(font);
        labelStock.setFont(font);

        btnAdd.addActionListener(this);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);

        panel.add(labelTitle);
        panel.add(labelName);
        panel.add(labelPrice);
        panel.add(labelStock);
        panel.add(textName);
        panel.add(textPrice);
        panel.add(textStock);
        panel.add(btnAdd);

        panel.setBackground(backgroundColor);
        frame.setSize(450, 230);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            if (textPrice.getText().equals("") || textName.getText().equals("") || textStock.getText().equals("")) {
                JOptionPane.showMessageDialog(btnAdd, "Toate campurile trebuie completate!");
            } else if (Integer.parseInt(textPrice.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnAdd, "Pretul produsului trebuie sa fie mai mare ca 0!");
            } else if (Integer.parseInt(textStock.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnAdd, "Stocul produsului trebuie sa fie mai mare ca 0!");
            } else {
                JOptionPane.showMessageDialog(btnAdd, "Produs adaugat cu succes!");
                Product product = new Product(textName.getText(), Integer.parseInt(textPrice.getText()), Integer.parseInt(textStock.getText()));
                ProductBLL productBLL = new ProductBLL();
                productBLL.insertProduct(product);
            }
        }
    }
}

class AddClientView implements ActionListener {
    /**
     * Clasa pentru interfata de adaugare a unui client in baza de date.
     */
    private Font font = new Font("Times New Roman", BOLD, 20);
    private JLabel labelTitle = new JLabel("Inserati datele despre client:");
    private JLabel labelName = new JLabel("Nume:");
    private JLabel labelAddress = new JLabel("Adresa:");
    private JLabel labelEmail = new JLabel("E-mail:");
    private JTextField textName = new JTextField();
    private JTextField textAddress = new JTextField();
    private JTextField textEmail = new JTextField();
    private JButton btnAdd = new JButton("Adauga");
    private JFrame frame = new JFrame("Add new client");
    private JPanel panel = new JPanel();
    private Color backgroundColor = new Color(208, 204, 177);

    public AddClientView() {
        labelTitle.setBounds(5, 5, 300, 30);
        labelName.setBounds(5, 50, 150, 30);
        textName.setBounds(130, 50, 250, 30);
        labelAddress.setBounds(5, 80, 150, 30);
        textAddress.setBounds(130, 80, 250, 30);
        labelEmail.setBounds(5, 110, 150, 30);
        textEmail.setBounds(130, 110, 250, 30);
        btnAdd.setBounds(130, 145, 250, 30);

        labelName.setFont(font);
        labelTitle.setFont(font);
        labelAddress.setFont(font);
        labelEmail.setFont(font);

        btnAdd.addActionListener(this);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);

        panel.add(labelTitle);
        panel.add(labelName);
        panel.add(labelAddress);
        panel.add(labelEmail);
        panel.add(textName);
        panel.add(textAddress);
        panel.add(textEmail);
        panel.add(btnAdd);

        panel.setBackground(backgroundColor);
        frame.setSize(450, 230);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            if (textAddress.getText().equals("") || textName.getText().equals("") || textEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(btnAdd, "Toate campurile trebuie completate!");
            } else if (!textEmail.getText().contains("@") || !textEmail.getText().contains(".")) {
                JOptionPane.showMessageDialog(btnAdd, "Adresa de E-mail invalida!");
            } else {
                JOptionPane.showMessageDialog(btnAdd, "Client adaugat cu succes!");
                Client client = new Client(textName.getText(), textAddress.getText(), textEmail.getText());
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.insertClient(client);
            }
        }
    }
}

class EditProductView implements ActionListener {
    /**
     * Clasa pentru interfata de editare a atributelor unui produs din baza de date.
     */
    private JFrame frame = new JFrame("Edit Product details");
    private JPanel panel = new JPanel();
    private JLabel labelSearch = new JLabel("Introduceti un ID valid de produs");
    private JTextField textSearch = new JTextField();
    private JLabel labelName = new JLabel("Nume:");
    private JLabel labelPrice = new JLabel("Pret:");
    private JLabel labelStock = new JLabel("Stoc:");
    private JTextField textName = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textStock = new JTextField();
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Times New Roman", BOLD, 20);
    private JButton btnSearch = new JButton("Cauta");
    private JButton btnEdit = new JButton("Modifica");

    public EditProductView() {
        labelSearch.setBounds(5, 25, 300, 30);
        textSearch.setBounds(130, 60, 250, 30);
        labelName.setBounds(5, 150, 150, 30);
        textName.setBounds(130, 150, 250, 30);
        labelPrice.setBounds(5, 180, 150, 30);
        textPrice.setBounds(130, 180, 250, 30);
        labelStock.setBounds(5, 210, 150, 30);
        textStock.setBounds(130, 210, 250, 30);
        btnSearch.setBounds(130, 90, 250, 30);
        btnEdit.setBounds(130, 240, 250, 30);

        labelName.setFont(font);
        labelPrice.setFont(font);
        labelStock.setFont(font);
        labelSearch.setFont(font);

        btnEdit.setFocusPainted(false);
        btnEdit.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);

        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);

        panel.add(labelName);
        panel.add(labelPrice);
        panel.add(labelStock);
        panel.add(labelSearch);
        panel.add(textSearch);
        panel.add(textName);
        panel.add(textPrice);
        panel.add(textStock);
        panel.add(btnEdit);
        panel.add(btnSearch);

        panel.setLayout(null);
        panel.setBackground(backgroundColor);
        frame.setSize(450, 350);
        frame.setVisible(true);
        frame.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            if (textSearch.getText().equals("")) {
                JOptionPane.showMessageDialog(btnSearch, "Introduceti un ID de produs!");
            } else {
                ProductBLL productBLL = new ProductBLL();
                Product p = productBLL.findProductById(Integer.parseInt(textSearch.getText()));
                textName.setText(p.getProductName());
                textPrice.setText(String.valueOf(p.getProductPrice()));
                textStock.setText(String.valueOf(p.getProductStock()));
            }
        }
        if (e.getSource() == btnEdit) {
            if (textSearch.getText().equals("") || textName.getText().equals("") || textPrice.getText().equals("") || textStock.getText().equals("")) {
                JOptionPane.showMessageDialog(btnEdit, "Toate campurile trebuie sa fie completate!");
            } else if (Integer.parseInt(textPrice.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnEdit, "Pretul produsului trebuie sa fie mai mare ca 0!");
            } else if (Integer.parseInt(textStock.getText()) <= 0) {
                JOptionPane.showMessageDialog(btnEdit, "Stocul produsului trebuie sa fie mai mare ca 0!");
            } else {
                JOptionPane.showMessageDialog(btnEdit, "Produs modificat cu succes!");
                ProductBLL productBLL = new ProductBLL();
                Product p = productBLL.findProductById(Integer.parseInt(textSearch.getText()));
                p.setProductName(textName.getText());
                p.setProductPrice(Integer.parseInt(textPrice.getText()));
                p.setProductStock(Integer.parseInt(textStock.getText()));
                productBLL.updateProduct(p);
            }
        }
    }
}

class EditClientView implements ActionListener {
    /**
     * Clasa pentru interfata de editare a atributelor unui client din baza de date.
     */
    private JFrame frame = new JFrame("Edit Client details");
    private JPanel panel = new JPanel();
    private JLabel labelSearch = new JLabel("Introduceti un ID valid de client");
    private JTextField textSearch = new JTextField();
    private JLabel labelName = new JLabel("Nume:");
    private JLabel labelAddress = new JLabel("Adresa:");
    private JLabel labelEmail = new JLabel("Email:");
    private JTextField textName = new JTextField();
    private JTextField textAddress = new JTextField();
    private JTextField textEmail = new JTextField();
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Times New Roman", BOLD, 20);
    private JButton btnSearch = new JButton("Cauta");
    private JButton btnEdit = new JButton("Modifica");

    public EditClientView() {
        labelSearch.setBounds(5, 25, 300, 30);
        textSearch.setBounds(130, 60, 250, 30);
        labelName.setBounds(5, 150, 150, 30);
        textName.setBounds(130, 150, 250, 30);
        labelAddress.setBounds(5, 180, 150, 30);
        textAddress.setBounds(130, 180, 250, 30);
        labelEmail.setBounds(5, 210, 150, 30);
        textEmail.setBounds(130, 210, 250, 30);
        btnSearch.setBounds(130, 90, 250, 30);
        btnEdit.setBounds(130, 240, 250, 30);

        labelName.setFont(font);
        labelAddress.setFont(font);
        labelEmail.setFont(font);
        labelSearch.setFont(font);

        btnEdit.setFocusPainted(false);
        btnEdit.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);

        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);

        panel.add(labelName);
        panel.add(labelAddress);
        panel.add(labelEmail);
        panel.add(labelSearch);
        panel.add(textSearch);
        panel.add(textName);
        panel.add(textAddress);
        panel.add(textEmail);
        panel.add(btnEdit);
        panel.add(btnSearch);

        panel.setLayout(null);
        panel.setBackground(backgroundColor);
        frame.setSize(450, 350);
        frame.setVisible(true);
        frame.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            if (textSearch.getText().equals("")) {
                JOptionPane.showMessageDialog(btnSearch, "Introduceti un ID de client!");
            } else {
                ClientBLL clientBLL = new ClientBLL();
                Client c = clientBLL.findClientById(Integer.parseInt(textSearch.getText()));
                textName.setText(c.getClientName());
                textAddress.setText(c.getClientAddress());
                textEmail.setText(c.getClientEmail());
            }
        }
        if (e.getSource() == btnEdit) {
            if (textSearch.getText().equals("") || textName.getText().equals("") || textAddress.getText().equals("") || textEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(btnEdit, "Toate campurile trebuie sa fie completate!");
            } else if (textAddress.getText().equals("") || textName.getText().equals("") || textEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(btnEdit, "Toate campurile trebuie completate!");
            } else if (!textEmail.getText().contains("@") || !textEmail.getText().contains(".")) {
                JOptionPane.showMessageDialog(btnEdit, "Adresa de E-mail invalida!");
            } else {
                JOptionPane.showMessageDialog(btnEdit, "Client modificat cu succes!");
                ClientBLL clientBLL = new ClientBLL();
                Client c = clientBLL.findClientById(Integer.parseInt(textSearch.getText()));
                c.setClientName(textName.getText());
                c.setClientAddress(textAddress.getText());
                c.setClientEmail(textEmail.getText());
                clientBLL.updateClient(c);
            }
        }
    }
}

class RemoveClientView implements ActionListener {
    /**
     * Clasa pentru interfata de stergere a unui client din baza de date.
     */
    private JFrame frame = new JFrame("Remove client");
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Introduceti un ID valid de client!");
    private JTextField textID = new JTextField();
    private JButton btnDelete = new JButton("Sterge");
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Times New Roman", BOLD, 20);

    public RemoveClientView() {
        labelTitle.setBounds(5, 10, 300, 30);
        textID.setBounds(5, 40, 250, 30);
        btnDelete.setBounds(5, 70, 250, 30);

        labelTitle.setFont(font);

        btnDelete.addActionListener(this);
        btnDelete.setFocusPainted(false);
        btnDelete.setContentAreaFilled(false);

        panel.add(labelTitle);
        panel.add(textID);
        panel.add(btnDelete);

        panel.setBackground(backgroundColor);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setContentPane(panel);
        frame.setSize(350, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDelete) {
            if (textID.getText().equals("")) {
                JOptionPane.showMessageDialog(btnDelete, "Introduceti un ID valid!");
            } else {
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.deleteClient(Integer.parseInt(textID.getText()));
                JOptionPane.showMessageDialog(btnDelete, "Client sters cu succes!");
            }
        }
    }
}

class RemoveProductView implements ActionListener {
    /**
     * Clasa pentru interfata de stergere a unui produs din baza de date.
     */
    private JFrame frame = new JFrame("Remove product");
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Introduceti un ID valid de produs!");
    private JTextField textID = new JTextField();
    private JButton btnDelete = new JButton("Sterge");
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Times New Roman", BOLD, 20);

    public RemoveProductView() {
        labelTitle.setBounds(5, 10, 300, 30);
        textID.setBounds(5, 40, 250, 30);
        btnDelete.setBounds(5, 70, 250, 30);

        labelTitle.setFont(font);

        btnDelete.addActionListener(this);
        btnDelete.setFocusPainted(false);
        btnDelete.setContentAreaFilled(false);

        panel.add(labelTitle);
        panel.add(textID);
        panel.add(btnDelete);

        panel.setBackground(backgroundColor);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setContentPane(panel);
        frame.setSize(350, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDelete) {
            if (textID.getText().equals("")) {
                JOptionPane.showMessageDialog(btnDelete, "Introduceti un ID valid!");
            } else {
                ProductBLL productBLL = new ProductBLL();
                productBLL.deleteProduct(Integer.parseInt(textID.getText()));
                JOptionPane.showMessageDialog(btnDelete, "Produs sters cu succes!");
            }
        }
    }
}

class ShowClients {
    /**
     * Interfata pentru vizualizarea clientilor din baza de date.
     */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Clients");
    private JTable table;
    private JScrollPane scrollPane;

    ShowClients() {
        String[] header = {"ID Client", "Nume", "Adresa", "E-Mail"};
        String[][] data = new String[1000][4];

        ClientBLL clientBLL = new ClientBLL();
        List<Client> list = clientBLL.findAllClients();
        int i = 0;
        for (Client c : list) {
            data[i][0] = String.valueOf(c.getClientID());
            data[i][1] = c.getClientName();
            data[i][2] = c.getClientAddress();
            data[i][3] = c.getClientEmail();
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}

class ShowProducts {
    /**
     * Clasa pentru vizualizarea produselor din baza de date.
     */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Products");
    private JTable table;
    private JScrollPane scrollPane;

    ShowProducts() {
        String[] header = {"ID Produs", "Nume", "Pret", "Stoc"};
        String[][] data = new String[1000][4];

        ProductBLL productBLL = new ProductBLL();
        List<Product> list = productBLL.findAllProducts();
        int i = 0;
        for (Product p : list) {
            data[i][0] = String.valueOf(p.getProductID());
            data[i][1] = p.getProductName();
            data[i][2] = String.valueOf(p.getProductPrice());
            data[i][3] = String.valueOf(p.getProductStock());
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}

class ShowOrders {
    /**
     * Clasa pentru vizualizarea comenzilor din baza de date.
     */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Orders");
    private JTable table;
    private JScrollPane scrollPane;

    ShowOrders() {
        String[] header = {"ID Comanda", "ID Produs", "ID Client", "Cantitate"};
        String[][] data = new String[1000][4];

        OrdersBLL ordersBLL = new OrdersBLL();
        List<Orders> list = ordersBLL.findAllOrders();
        int i = 0;
        for (Orders o : list) {
            data[i][0] = String.valueOf(o.getOrdersID());
            data[i][1] = String.valueOf(o.getClientID());
            data[i][2] = String.valueOf(o.getProductID());
            data[i][3] = String.valueOf(o.getQuantity());
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}

class NewOrder implements ActionListener {
    /**
     * Clasa pentru interfata de adaugare a unei comenzi in baza de date.
     */
    private JPanel panel = new JPanel();
    private JPanel upPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JFrame frame = new JFrame("New order");
    private JLabel labelQuantity = new JLabel("Selectati din tabele un client si un produs. Introduceti cantitatea dorita:");
    private JTextField textQuantity = new JTextField();
    private JButton btnNewOrder = new JButton("Add Order");
    private JScrollPane js1;
    private JScrollPane js2;
    private JTable t1;
    private JTable t2;
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Times New Roman", BOLD, 20);
    private String[][] data1 = new String[1000][4];
    private String[][] data2 = new String[1000][4];

    public NewOrder() {
        String[] header1 = {"ID Client", "Nume", "Adresa", "E-Mail"};
        ClientBLL clientBLL = new ClientBLL();
        List<Client> list1 = clientBLL.findAllClients();
        int i = 0;
        for (Client c : list1) {
            data1[i][0] = String.valueOf(c.getClientID());
            data1[i][1] = c.getClientName();
            data1[i][2] = c.getClientAddress();
            data1[i][3] = c.getClientEmail();
            i++;
        }

        DefaultTableModel model1 = new DefaultTableModel(data1, header1);
        t1 = new JTable(model1);
        js1 = new JScrollPane(t1);
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(js1, BorderLayout.WEST);

        String[] header2 = {"ID Produs", "Nume", "Pret", "Stoc"};
        ProductBLL productBLL = new ProductBLL();
        List<Product> list2 = productBLL.findAllProducts();
        i = 0;
        for (Product p : list2) {
            data2[i][0] = String.valueOf(p.getProductID());
            data2[i][1] = p.getProductName();
            data2[i][2] = String.valueOf(p.getProductPrice());
            data2[i][3] = String.valueOf(p.getProductStock());
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data2, header2);
        t2 = new JTable(model);
        js2 = new JScrollPane(t2);

        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(js2, BorderLayout.EAST);

        upPanel.add(leftPanel);
        upPanel.add(rightPanel);

        labelQuantity.setBounds(200, 0, 700, 30);
        textQuantity.setBounds(400, 30, 200, 30);
        btnNewOrder.setBounds(400, 60, 200, 30);

        labelQuantity.setFont(font);
        btnNewOrder.addActionListener(this);

        bottomPanel.add(labelQuantity);
        bottomPanel.add(textQuantity);
        bottomPanel.add(btnNewOrder);
        bottomPanel.setLayout(null);

        upPanel.setBackground(backgroundColor);
        bottomPanel.setBackground(backgroundColor);

        panel.add(upPanel);
        panel.add(bottomPanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewOrder) {
            if (t1.getSelectedRow() == -1 || t2.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(btnNewOrder, "Selectati un produs si un client!");
            } else if (textQuantity.getText().equals("")) {
                JOptionPane.showMessageDialog(btnNewOrder, "Introduceti o cantitate valida!");
            } else {
                int availableStock = Integer.parseInt(data2[t2.getSelectedRow()][3]);
                int productID = Integer.parseInt(data2[t2.getSelectedRow()][0]);
                int clientID = Integer.parseInt(data1[t1.getSelectedRow()][0]);
                if (availableStock < Integer.parseInt(textQuantity.getText())) {
                    JOptionPane.showMessageDialog(btnNewOrder, "Stoc insuficient!");
                } else {
                    OrdersBLL ordersBLL = new OrdersBLL();
                    ProductBLL productBLL = new ProductBLL();
                    ClientBLL clientBLL = new ClientBLL();
                    Orders order = new Orders(clientID, productID, Integer.parseInt(textQuantity.getText()));
                    Orders o = ordersBLL.insertOrders(order);
                    Product p = productBLL.findProductById(productID);
                    Client c = clientBLL.findClientById(clientID);
                    try {
                        PrintWriter printWriter = new PrintWriter("C:\\Users\\balea\\Documents\\Facultate\\TP\\PT2022_30221_Balea_Cristian_Constantin_Assignment_3" +
                                "\\bill" + o.getOrdersID() + ".txt");
                        printWriter.write("Comanda nr." + o.getOrdersID() + "\n\n");
                        printWriter.write("Client: " + c.getClientName() + "\nAdresa: " + c.getClientAddress() + "\nE-Mail: " + c.getClientEmail() + "\n\n");
                        printWriter.write("Produsul: " + p.getProductName() + "\nCantitate: " + textQuantity.getText() + "\nPret per produs: " + p.getProductPrice() +
                                "\nPret total: " + p.getProductPrice() * Integer.parseInt(textQuantity.getText()));
                        printWriter.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(btnNewOrder, "Comanda adaugata cu succes!");
                    p.setProductStock(p.getProductStock() - o.getQuantity());
                    productBLL.updateProduct(p);
                }
            }
        }
    }
}