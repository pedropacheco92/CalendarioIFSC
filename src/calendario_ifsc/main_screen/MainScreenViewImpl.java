package calendario_ifsc.main_screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainScreenViewImpl implements MainScreenView {

	private JFrame frame;
	private JTable table;
	private MainScreenPresenter presenter;

	@Override
	public void setPresenter(MainScreenPresenter cadastroPresenter) {
		this.presenter = this.presenter;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void render() {
		this.frame = new JFrame();
		this.frame.getContentPane().setEnabled(false);
		this.frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 375);
		this.frame.getContentPane().add(scrollPane);

		this.table = new JTable();
		scrollPane.setViewportView(this.table);
		this.table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Data", "Nome", "Local", "Descrição" }));

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainScreenViewImpl.this.frame.dispose();
				System.exit(0);
			}
		});
		btnSair.setBounds(74, 388, 105, 23);
		this.frame.getContentPane().add(btnSair);

		JButton btnNovoEvento = new JButton("Novo Evento");
		btnNovoEvento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainScreenViewImpl.this.presenter.createNovoEvento();
			}
		});
		btnNovoEvento.setBounds(253, 388, 105, 23);
		this.frame.getContentPane().add(btnNovoEvento);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setBounds(100, 100, 450, 461);
	}
}
