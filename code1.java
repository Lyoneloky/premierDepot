import javax.swing.*;
import javax.swing.*;
import java.awt.*;
public class LoginPage extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;

    public LoginPage() {
        // Configurer la fenêtre
        setTitle("Page de Connexion");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setMinimumSize(new Dimension(800, 400));

        // Utiliser un JPanel personnalisé pour l'arrière-plan en dégradé
        JPanel panel = new GradientPanel();
        panel.setLayout(new GridBagLayout());
        add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Ajouter des marges

        // Charger l'image et la redimensionner
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\hp\\Downloads\\PROJET JAVA\\Gestion de bibliotheque\\data_1770095.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Ajouter l'image au JLabel
        JLabel imageLabel = new JLabel(resizedIcon);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(imageLabel, constraints);

        // Texte supplémentaire au-dessus
        JLabel infoLabel = new JLabel("Connectez-vous pour accéder à l'application");
        infoLabel.setFont(new Font("Bahnschrift SemiBold SemiConden", Font.PLAIN, 18));
        infoLabel.setForeground(Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(infoLabel, constraints);

        // Titre de la page
        JLabel titleLabel = new JLabel("Connexion");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.BLACK);
        constraints.gridy = 2;
        panel.add(titleLabel, constraints);

        // Champ d'utilisateur
        JLabel userLabel = new JLabel("Utilisateur :");
        userLabel.setForeground(Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(userLabel, constraints);

        userText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(userText, constraints);

        // Champ de mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe :");
        passwordLabel.setForeground(Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, constraints);

        passwordText = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(passwordText, constraints);

        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(new Color(66, 133, 244));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;
        panel.add(loginButton, constraints);

        // Ajouter une action au bouton de connexion
        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());
            if(!user.isEmpty() && password!=null) {

                // Vérifier les informations de connexion (ici, juste un exemple simple)
                if (user.equals("admin") && password.equals("admin")) {
                    dispose();
                    new Livres();
                } else {
                    JOptionPane.showMessageDialog(panel, "nom d'utilisateur ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(panel, "veuillez remplir les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
        });

        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        });
    }

    // Classe interne pour le JPanel avec un arrière-plan en dégradé
    private static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(50, 0, Color.WHITE, getWidth(), getHeight(), Color.PINK);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }


}
