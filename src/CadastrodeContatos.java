import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CadastrodeContatos extends JFrame {
    private JTextField txtNome, txtTelefone, txtEmail;
    private JList<String> listContatos;
    private DefaultListModel<String> model;
    private JButton btnAdicionar, btnRemover;
    private JPanel CadastrodeContatos;

    public CadastrodeContatos() {
        setTitle("Cadastro de Contatos");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        txtNome = new JTextField(15);
        txtTelefone = new JTextField(15);
        txtEmail = new JTextField(15);
        model = new DefaultListModel<>();
        listContatos = new JList<>(model);
        btnAdicionar = new JButton("Adicionar Contato");
        btnRemover = new JButton("Remover Contato");


        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Telefone:"));
        add(txtTelefone);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(btnAdicionar);
        add(new JScrollPane(listContatos));
        add(btnRemover);


        btnAdicionar.addActionListener(e -> adicionarContato());


        btnRemover.addActionListener(e -> removerContato());
    }


    private void adicionarContato() {
        String nome = txtNome.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String email = txtEmail.getText().trim();


        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {

            model.addElement("Nome: " + nome + " | Tel: " + telefone + " | Email: " + email);

            txtNome.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");
        }
    }


    private void removerContato() {
        int index = listContatos.getSelectedIndex();
        if (index != -1) {
            model.remove(index);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um contato para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastrodeContatos().setVisible(true));
    }
}

