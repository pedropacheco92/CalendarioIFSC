package calendario_ifsc.login;

public interface LoginPresenter<VIEW, MODEL> {

	void validateLogin(String login, String senha);

	void createMainScreen();

	void createNovoCadastro();

}
