package calendario_ifsc.main_screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import calendario_ifsc.utils.Evento;

public class MainScreenViewImpl implements MainScreenView {

	private JFrame frame;
	private JTable table;
	private MainScreenPresenter presenter;
	private DefaultTableModel dtm;
	private List<Evento> eventos;

	@Override
	public void setPresenter(MainScreenPresenter cadastroPresenter) {
		this.presenter = cadastroPresenter;
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
		this.table.setEnabled(false);
		scrollPane.setViewportView(this.table);
		this.table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Data Inicio", "Data Fim", "Descrição" }));

		this.dtm = (javax.swing.table.DefaultTableModel) this.table.getModel();
		this.loadEventos();

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

	private void loadEventos() {
		this.eventos = this.presenter.loadEventos();
		this.renderEventos();
	}

	private void renderEventos() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (Evento e : this.eventos) {
			this.dtm.addRow(new Object[] { e.getNome(), df.format(e.getDateInicio()), df.format(e.getDateFim()),
					e.getDescricao() });
		}
	}

}
