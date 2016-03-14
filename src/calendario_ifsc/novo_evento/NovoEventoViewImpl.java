package calendario_ifsc.novo_evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import calendario_ifsc.utils.DateLabelFormatter;

public class NovoEventoViewImpl implements NovoEventoView {

	private JFrame frame;
	private JDatePickerImpl datePicker;
	private JTextField textFieldNomeEvento;
	private JTextField textFieldLocalEvento;
	private JTextField textFieldDescricao;
	NovoEventoPresenter presenter;

	@Override
	public void setPresenter(NovoEventoPresenter novoEventoPresenter) {
		this.presenter = novoEventoPresenter;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void render() {
		this.frame = new JFrame();
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		UtilDateModel model = new UtilDateModel();
		// model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "Mês");
		p.put("text.year", "Ano");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.frame.getContentPane().add(datePanel);

		JLabel lblNomeDoEvento = new JLabel("Nome do Evento:");
		lblNomeDoEvento.setBounds(24, 111, 106, 14);
		this.frame.getContentPane().add(lblNomeDoEvento);

		this.textFieldNomeEvento = new JTextField();
		this.textFieldNomeEvento.setBounds(122, 108, 302, 20);
		this.frame.getContentPane().add(this.textFieldNomeEvento);
		this.textFieldNomeEvento.setColumns(10);

		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(24, 136, 46, 14);
		this.frame.getContentPane().add(lblLocal);

		this.textFieldLocalEvento = new JTextField();
		this.textFieldLocalEvento.setBounds(122, 136, 302, 20);
		this.frame.getContentPane().add(this.textFieldLocalEvento);
		this.textFieldLocalEvento.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(24, 172, 98, 14);
		this.frame.getContentPane().add(lblDescrio);

		this.textFieldDescricao = new JTextField();
		this.textFieldDescricao.setBounds(24, 197, 388, 113);
		this.frame.getContentPane().add(this.textFieldDescricao);
		this.textFieldDescricao.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NovoEventoViewImpl.this.cadastarEvento();
			}
		});
		btnConfirmar.setBounds(254, 321, 106, 23);
		this.frame.getContentPane().add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NovoEventoViewImpl.this.frame.dispose();
			}
		});
		btnCancelar.setBounds(74, 321, 106, 23);
		this.frame.getContentPane().add(btnCancelar);

		this.frame.setBounds(100, 100, 450, 400);
	}

	protected void cadastarEvento() {
		this.presenter.salvarEvento(new Date(), this.textFieldNomeEvento.getText(), this.textFieldLocalEvento.getText(),
				this.textFieldDescricao.getText());
		this.frame.dispose();
	}
}
