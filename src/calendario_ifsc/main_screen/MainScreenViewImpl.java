package calendario_ifsc.main_screen;

import javax.swing.JFrame;

public class MainScreenViewImpl implements MainScreenView {

	private JFrame frame;

	@Override
	public void setPresenter(MainScreenPresenter cadastroPresenter) {
		// TODO Auto-generated method stub

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void render() {
		this.frame = new JFrame();
		this.frame.getContentPane().setEnabled(false);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setBounds(100, 100, 450, 461);
		this.frame.getContentPane().setLayout(null);
	}

}
