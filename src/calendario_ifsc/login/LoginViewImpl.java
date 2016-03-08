package calendario_ifsc.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginViewImpl<PRESENTER> implements LoginView<PRESENTER> {

	private LoginPresenter presenter;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnRecuperarSenha;
	private JButton btnNovoCadastro;

	@Override
	public void setPresenter(PRESENTER loginPresenter) {
		this.presenter = (LoginPresenter) loginPresenter;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void render() {
		this.frame = new JFrame();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		JLabel lblBemvindoaAgenda = new JLabel("Bem-vindo(a) \u00E0 Agenda IFSC");
		lblBemvindoaAgenda.setBounds(10, 11, 414, 21);
		lblBemvindoaAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindoaAgenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		this.frame.getContentPane().add(lblBemvindoaAgenda);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsurio.setBounds(31, 69, 83, 21);
		this.frame.getContentPane().add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(31, 116, 83, 14);
		this.frame.getContentPane().add(lblSenha);

		this.textField = new JTextField();
		this.textField.setBounds(144, 66, 245, 25);
		this.frame.getContentPane().add(this.textField);
		this.textField.setColumns(10);

		this.passwordField = new JPasswordField();
		this.passwordField.setBounds(144, 110, 245, 25);
		this.frame.getContentPane().add(this.passwordField);

		this.btnLogin = new JButton("Login");
		this.btnLogin.setForeground(Color.WHITE);
		this.btnLogin.setBackground(new Color(51, 204, 102));
		this.btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnLogin.setBounds(274, 146, 115, 33);
		this.btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoginViewImpl.this.fazerLoginUsuario();
			}
		});
		this.frame.getContentPane().add(this.btnLogin);

		this.btnRecuperarSenha = new JButton("Recuperar Senha");
		this.btnRecuperarSenha.setHorizontalTextPosition(SwingConstants.LEFT);
		this.btnRecuperarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnRecuperarSenha.setForeground(Color.BLUE);
		this.btnRecuperarSenha.setContentAreaFilled(false);
		this.btnRecuperarSenha.setBorderPainted(false);
		this.btnRecuperarSenha.setBounds(31, 167, 148, 23);
		HashMap<TextAttribute, Object> textAttrMap = new HashMap<TextAttribute, Object>();
		textAttrMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		textAttrMap.put(TextAttribute.FOREGROUND, Color.BLUE);
		this.btnRecuperarSenha.setFont(this.btnRecuperarSenha.getFont().deriveFont(textAttrMap));

		this.frame.getContentPane().add(this.btnRecuperarSenha);

		this.btnNovoCadastro = new JButton("Novo Cadastro");
		this.btnNovoCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoginViewImpl.this.createNovoCadastro();
			}
		});
		this.btnNovoCadastro.setHorizontalTextPosition(SwingConstants.LEFT);
		this.btnNovoCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnNovoCadastro.setForeground(Color.BLUE);
		this.btnNovoCadastro.setContentAreaFilled(false);
		this.btnNovoCadastro.setBorderPainted(false);
		this.btnNovoCadastro.setBounds(31, 201, 139, 23);
		this.btnNovoCadastro.setFont(this.btnNovoCadastro.getFont().deriveFont(textAttrMap));
		this.frame.getContentPane().add(this.btnNovoCadastro);

		this.frame.setBounds(100, 100, 450, 300);
	}

	protected void fazerLoginUsuario() {
		this.frame.dispose();
		try {
			this.presenter.validateLogin(this.textField.getText().trim(),
					this.passwordField.getPassword().toString().trim());
		} catch (Exception e) {

		}

		this.presenter.createMainScreen();
	}

	protected void createNovoCadastro() {
		this.presenter.createNovoCadastro();
	}
}
