package calendario_ifsc.login;

public interface LoginView<PRESENTER> {

	void render();

	void setPresenter(PRESENTER loginPresenter);

}
