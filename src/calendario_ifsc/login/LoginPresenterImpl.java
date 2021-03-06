package calendario_ifsc.login;

import calendario_ifsc.main_screen.MainScreenModel;
import calendario_ifsc.main_screen.MainScreenModelImpl;
import calendario_ifsc.main_screen.MainScreenPresenter;
import calendario_ifsc.main_screen.MainScreenPresenterImpl;
import calendario_ifsc.main_screen.MainScreenView;
import calendario_ifsc.main_screen.MainScreenViewImpl;
import calendario_ifsc.novo_cadastro.NovoCadastroModel;
import calendario_ifsc.novo_cadastro.NovoCadastroModelImpl;
import calendario_ifsc.novo_cadastro.NovoCadastroPresenter;
import calendario_ifsc.novo_cadastro.NovoCadastroPresenterImpl;
import calendario_ifsc.novo_cadastro.NovoCadastroView;
import calendario_ifsc.novo_cadastro.NovoCadastroViewImpl;

public class LoginPresenterImpl<MODEL, VIEW> implements LoginPresenter<VIEW, MODEL> {

	LoginModel model;
	LoginView view;

	public LoginPresenterImpl(MODEL loginModel, VIEW loginView) {
		this.model = (LoginModel) loginModel;
		this.view = (LoginView) loginView;
	}

	@Override
	public void validateLogin(String login, String senha) throws Exception {
		this.model.loadUsuario(login, senha);
	}

	@Override
	public void createMainScreen(String cpf) {
		MainScreenModel mainScreenModel = new MainScreenModelImpl();
		MainScreenView mainScreenView = new MainScreenViewImpl();
		MainScreenPresenter mainScreenPresenter = new MainScreenPresenterImpl(mainScreenModel, mainScreenView);
		mainScreenView.setPresenter(mainScreenPresenter);
		mainScreenPresenter.setCpf(cpf);
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
