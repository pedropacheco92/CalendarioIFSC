package calendario_ifsc.main;

import calendario_ifsc.login.LoginModel;
import calendario_ifsc.login.LoginModelImpl;
import calendario_ifsc.login.LoginPresenter;
import calendario_ifsc.login.LoginPresenterImpl;
import calendario_ifsc.login.LoginView;
import calendario_ifsc.login.LoginViewImpl;

public class Main {

	public static void main(String[] args) {
		LoginModel loginModel = new LoginModelImpl();
		LoginView loginView = new LoginViewImpl();
		LoginPresenter loginPresenter = new LoginPresenterImpl(loginModel, loginView);
		loginView.setPresenter(loginPresenter);
		loginView.render();
	}

}
