package calendario_ifsc.main;

import calendario_ifsc.model.LoginModel;
import calendario_ifsc.model.impl.LoginModelImpl;
import calendario_ifsc.presenter.LoginPresenter;
import calendario_ifsc.presenter.impl.LoginPresenterImpl;
import calendario_ifsc.view.LoginView;
import calendario_ifsc.view.impl.LoginViewImpl;

public class Main {

	public static void main(String[] args) {
		LoginModel loginModel = new LoginModelImpl();
		LoginView loginView = new LoginViewImpl();
		LoginPresenter loginPresenter = new LoginPresenterImpl(loginModel, loginView);
		loginView.setPresenter(loginPresenter);
		loginView.render();

	}

}
