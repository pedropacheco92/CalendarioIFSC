package calendario_ifsc.utils;

import java.util.Date;

public class Evento {

	private int id;
	private String cpf;
	private String nome;
	private int tipoEvento;
	private Date dateInicio;
	private Date dateFim;
	private String descricao;

	public Evento(int id, String cpf, String nome, int tipoEvento, Date dateInicio, Date dateFim, String descricao) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.tipoEvento = tipoEvento;
		this.dateInicio = dateInicio;
		this.dateFim = dateFim;
		this.descricao = descricao;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(int tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Date getDateInicio() {
		return this.dateInicio;
	}

	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}

	public Date getDateFim() {
		return this.dateFim;
	}

	public void setDateFim(Date dateFim) {
		this.dateFim = dateFim;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
