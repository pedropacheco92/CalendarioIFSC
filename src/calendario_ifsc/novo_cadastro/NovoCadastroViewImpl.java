package calendario_ifsc.novo_cadastro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import calendario_ifsc.constants.NovoCadastroConstants;
import calendario_ifsc.utils.Usuario;

public class NovoCadastroViewImpl implements NovoCadastroView {

	private NovoCadastroPresenter presenter;
	private JFrame frame;
	private JTextField textFieldLogin;
	private JTextField textFieldConfirmaLogin;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirma;
	private JTextField textFieldMatricula;

	HashMap<NovoCadastroConstants, JTextField> listaCampos;

	public NovoCadastroViewImpl() {
		this.listaCampos = new HashMap<>();
	}

	@Override
	public void setPresenter(NovoCadastroPresenter cadastroPresenter) {
		this.presenter = cadastroPresenter;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void render() {
		this.frame = new JFrame();
		this.frame.getContentPane().setEnabled(false);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setBounds(100, 100, 450, 461);
		this.frame.getContentPane().setLayout(null);

		JLabel lblNovoCadastro = new JLabel("Novo Cadastro");
		lblNovoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovoCadastro.setBounds(10, 11, 414, 23);
		this.frame.getContentPane().add(lblNovoCadastro);

		JLabel lblLoginemail = new JLabel("Login (e-mail)");
		lblLoginemail.setBounds(10, 49, 80, 14);
		this.frame.getContentPane().add(lblLoginemail);

		this.textFieldLogin = new JTextField();
		this.textFieldLogin.setBounds(100, 45, 301, 23);
		this.frame.getContentPane().add(this.textFieldLogin);
		this.textFieldLogin.setColumns(10);
		this.listaCampos.put(NovoCadastroConstants.LOGIN, this.textFieldLogin);

		JLabel lblConfirmeEmail = new JLabel("Confirme email");
		lblConfirmeEmail.setBounds(10, 83, 80, 14);
		this.frame.getContentPane().add(lblConfirmeEmail);

		this.textFieldConfirmaLogin = new JTextField();
		this.textFieldConfirmaLogin.setColumns(10);
		this.textFieldConfirmaLogin.setBounds(100, 79, 301, 23);
		this.frame.getContentPane().add(this.textFieldConfirmaLogin);
		this.listaCampos.put(NovoCadastroConstants.CONFIRMA_LOGIN, this.textFieldConfirmaLogin);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 117, 46, 14);
		this.frame.getContentPane().add(lblNome);

		this.textFieldNome = new JTextField();
		this.textFieldNome.setColumns(10);
		this.textFieldNome.setBounds(100, 113, 301, 23);
		this.frame.getContentPane().add(this.textFieldNome);
		this.listaCampos.put(NovoCadastroConstants.NOME, this.textFieldNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 151, 46, 14);
		this.frame.getContentPane().add(lblCpf);

		this.textFieldCPF = new JTextField();
		this.textFieldCPF.setBounds(100, 147, 159, 23);
		this.frame.getContentPane().add(this.textFieldCPF);
		this.textFieldCPF.setColumns(10);
		this.listaCampos.put(NovoCadastroConstants.CPF, this.textFieldCPF);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 185, 46, 14);
		this.frame.getContentPane().add(lblSenha);

		this.passwordField = new JPasswordField();
		this.passwordField.setBounds(100, 181, 159, 23);
		this.frame.getContentPane().add(this.passwordField);
		this.listaCampos.put(NovoCadastroConstants.SENHA, this.passwordField);

		JLabel lblConfirmaSenha = new JLabel("Confirma senha");
		lblConfirmaSenha.setBounds(10, 219, 80, 14);
		this.frame.getContentPane().add(lblConfirmaSenha);

		this.passwordFieldConfirma = new JPasswordField();
		this.passwordFieldConfirma.setBounds(100, 215, 159, 23);
		this.frame.getContentPane().add(this.passwordFieldConfirma);
		this.listaCampos.put(NovoCadastroConstants.CONFIRMA_SENHA, this.passwordFieldConfirma);

		JTextPane txtpnVocAluno = new JTextPane();
		txtpnVocAluno.setEnabled(false);
		txtpnVocAluno.setEditable(false);
		txtpnVocAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnVocAluno.setText(
				"Voc\u00EA \u00E9 aluno do IFSC? Ent\u00E3o insira sua matr\u00EDcula para poder participar da Agenda da Turma:");
		txtpnVocAluno.setBounds(10, 259, 414, 50);
		this.frame.getContentPane().add(txtpnVocAluno);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(10, 320, 80, 14);
		this.frame.getContentPane().add(lblMatricula);

		this.textFieldMatricula = new JTextField();
		this.textFieldMatricula.setColumns(10);
		this.textFieldMatricula.setBounds(100, 317, 159, 23);
		this.frame.getContentPane().add(this.textFieldMatricula);
		this.listaCampos.put(NovoCadastroConstants.MATRICULA, this.textFieldMatricula);

		JButton btnCadasterse = new JButton("Cadaster-se");
		btnCadasterse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (NovoCadastroViewImpl.this.verificaVazio()) {
					JOptionPane.showMessageDialog(NovoCadastroViewImpl.this.frame, "Campos Vazios!");
				} else {
					if (!Arrays.equals(NovoCadastroViewImpl.this.passwordField.getPassword(),
							NovoCadastroViewImpl.this.passwordFieldConfirma.getPassword())) {
						JOptionPane.showMessageDialog(NovoCadastroViewImpl.this.frame, "Senhas diferentes!");
					} else {
						if (!NovoCadastroViewImpl.this.textFieldConfirmaLogin.getText()
								.equals(NovoCadastroViewImpl.this.textFieldLogin.getText())) {
							JOptionPane.showMessageDialog(NovoCadastroViewImpl.this.frame, "Logins diferentes!");
						} else {
							Usuario u = new Usuario();
							u.setCpf(NovoCadastroViewImpl.this.textFieldCPF.getText());
							u.setEmail(NovoCadastroViewImpl.this.textFieldLogin.getText());
							u.setMatricula(NovoCadastroViewImpl.this.textFieldMatricula.getText());
							u.setNome(NovoCadastroViewImpl.this.textFieldNome.getText());
							u.setSenha(new String(NovoCadastroViewImpl.this.passwordField.getPassword()));

							NovoCadastroViewImpl.this.presenter.cadastrar(u);
							NovoCadastroViewImpl.this.frame.dispose();
						}
					}
				}

			}
		});
		btnCadasterse.setBounds(242, 370, 120, 40);
		this.frame.getContentPane().add(btnCadasterse);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NovoCadastroViewImpl.this.frame.dispose();
			}
		});
		btnVoltar.setBounds(73, 370, 120, 40);
		this.frame.getContentPane().add(btnVoltar);
	}

	protected boolean verificaVazio() {
		if (this.textFieldLogin == null || this.textFieldConfirmaLogin == null || this.textFieldNome == null
				|| this.textFieldCPF == null || this.passwordField == null || this.passwordFieldConfirma == null
				|| this.textFieldMatricula == null || this.textFieldLogin.getText() == ""
				|| this.textFieldConfirmaLogin.getText() == "" || this.textFieldNome.getText() == ""
				|| this.textFieldCPF.getText() == "" || this.passwordField.getPassword().length == 0
				|| this.passwordFieldConfirma.getPassword().length == 0 || this.textFieldMatricula.getText() == "") {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public HashMap getListaCampos() {
		return this.listaCampos;
	}

}
