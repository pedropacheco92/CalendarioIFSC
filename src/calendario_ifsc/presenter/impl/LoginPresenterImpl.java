package calendario_ifsc.presenter.impl;

import calendario_ifsc.presenter.LoginPresenter;

public class LoginPresenterImpl<MODEL, VIEW> implements LoginPresenter {

	MODEL model;
	VIEW view;

	public LoginPresenterImpl(MODEL loginModel, VIEW loginView) {
		this.model = loginModel;
		this.view = loginView;
	}

}
