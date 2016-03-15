package calendario_ifsc.login;

public interface LoginPresenter<VIEW, MODEL> {

	void validateLogin(String login, String senha) throws Exception;

	void createMainScreen(String cpf);

	void createNovoCadastro();

}
