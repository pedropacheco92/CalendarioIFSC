package calendario_ifsc.utils;

public class Usuario {

	private String email;
	private String nome;
	private String cpf;
	private String senha;
	private String matricula;

	public Usuario() {

	}

	public Usuario(String email, String nome, String cpf, String senha, String matricula) {
		super();
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.matricula = matricula;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
