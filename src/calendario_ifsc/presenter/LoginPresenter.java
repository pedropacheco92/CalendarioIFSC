package calendario_ifsc.presenter;

public interface LoginPresenter<VIEW, MODEL> {

	void validateLogin(String login, String senha);

	void createMainScreen();

	void createNovoCadastro();

}
