package calendario_ifsc.presenter.impl;

import calendario_ifsc.model.LoginModel;
import calendario_ifsc.model.MainScreenModel;
import calendario_ifsc.model.NovoCadastroModel;
import calendario_ifsc.model.impl.MainScreenModelImpl;
import calendario_ifsc.model.impl.NovoCadastroModelImpl;
import calendario_ifsc.presenter.LoginPresenter;
import calendario_ifsc.presenter.MainScreenPresenter;
import calendario_ifsc.presenter.NovoCadastroPresenter;
import calendario_ifsc.view.LoginView;
import calendario_ifsc.view.MainScreenView;
import calendario_ifsc.view.NovoCadastroView;
import calendario_ifsc.view.impl.MainScreenViewImpl;
import calendario_ifsc.view.impl.NovoCadastroViewImpl;

public class LoginPresenterImpl<MODEL, VIEW> implements LoginPresenter<VIEW, MODEL> {

	LoginModel model;
	LoginView view;

	public LoginPresenterImpl(MODEL loginModel, VIEW loginView) {
		this.model = (LoginModel) loginModel;
		this.view = (LoginView) loginView;
	}

	@Override
	public void validateLogin(String login, String senha) {
		try {
			this.model.loadUsuario(login, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createMainScreen() {
		MainScreenModel mainScreenModel = new MainScreenModelImpl();
		MainScreenView mainScreenView = new MainScreenViewImpl();
		MainScreenPresenter cadastroPresenter = new MainScreenPresenterImpl(mainScreenModel, mainScreenView);
		mainScreenView.setPresenter(cadastroPresenter);
		mainScreenView.render();
	}

	@Override
	public void createNovoCadastro() {
		NovoCadastroModel cadastroModel = new NovoCadastroModelImpl();
		NovoCadastroView cadastroView = new NovoCadastroViewImpl();
		NovoCadastroPresenter cadastroPresenter = new NovoCadastroPresenterImpl(cadastroModel, cadastroView);
		cadastroView.setPresenter(cadastroPresenter);
		cadastroView.render();
	}

}
