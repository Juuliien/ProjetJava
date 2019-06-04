package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Connexion;

public class MainFrameCo extends JFrame {
	private JPanel panelCo = new JPanel();
	private JButton buttonCo;
	private JLabel serverLabel;
	private JLabel bddLabel;
	private JLabel loginLabel;
	private JLabel pwLabel;
	private JTextField serverTf;
	private JTextField bddTf;
	private JTextField loginTf;
	private JPasswordField pwTf;

	public MainFrameCo(){
		super("SchoolEngine Connexion");
		
		setSize(600, 500);
		setMinimumSize(new Dimension(600, 500));
		setMaximumSize(new Dimension(700, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		Border insideBorder = BorderFactory.createTitledBorder("Connexion");
		Border outsideBorder = BorderFactory.createEmptyBorder(150,100,160,100);
		panelCo.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		serverLabel = new JLabel("Serveur: ");
		bddLabel = new JLabel("Nom de la Base: ");
		loginLabel = new JLabel("Login: ");
		pwLabel = new JLabel("Password: ");
		
		serverTf = new JTextField(22);
		bddTf = new JTextField(22);
		loginTf = new JTextField(22);
		pwTf = new JPasswordField(22);
		
		buttonCo = new JButton("Connexion !");
		
		panelCo.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		/***row 1***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panelCo.add(serverLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panelCo.add(serverTf, gc);
		
		
		/***row 2***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panelCo.add(bddLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panelCo.add(bddTf, gc);
		
		/***row 3***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panelCo.add(loginLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panelCo.add(loginTf, gc);
		
		/***row 4***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		
		panelCo.add(pwLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		panelCo.add(pwTf, gc);
		
		/***row 5***/
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		panelCo.add(buttonCo, gc);
		
		setLayout(new BorderLayout());
		add(panelCo, BorderLayout.CENTER);
		setVisible(true);
		
		buttonCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server = serverTf.getText();
				String base = bddTf.getText();
				String login = loginTf.getText();
				@SuppressWarnings("deprecation")
				String pw = pwTf.getText();
				
				
				try {
					new Connexion(server, base, login, pw);
					new MainFrame();
					dispose();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(panelCo,
					    "Les informations saisies ne nous permettent pas de vous identifier !",
					    "Donnez nous 20/20 SVP",
					    JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelCo,
						    "Les informations saisies ne nous permettent pas de vous identifier !",
						    "Donnez nous 20/20 SVP",
						    JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		
		
	}


}
