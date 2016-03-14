package calendario_ifsc.main_screen;

import java.util.ArrayList;
import java.util.Map;

public interface MainScreenPresenter {

	void createNovoEvento();

	Map<String, ArrayList<String>> loadEventos();
}
