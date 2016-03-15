package calendario_ifsc.novo_evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import com.toedter.calendar.JDateChooser;

public class NovoEventoViewImpl implements NovoEventoView {

	private JFrame frame;
	private JDatePickerImpl datePicker;
	private JTextField textFieldNomeEvento;
	private JTextField textFieldDescricao;
	JDateChooser dateChooserInicio, dateChooserFim;

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

		JLabel lblNomeDoEvento = new JLabel("Nome do Evento:");
		lblNomeDoEvento.setBounds(24, 58, 106, 14);
		this.frame.getContentPane().add(lblNomeDoEvento);

		this.textFieldNomeEvento = new JTextField();
		this.textFieldNomeEvento.setBounds(122, 55, 302, 20);
		this.frame.getContentPane().add(this.textFieldNomeEvento);
		this.textFieldNomeEvento.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(24, 89, 98, 14);
		this.frame.getContentPane().add(lblDescrio);

		this.textFieldDescricao = new JTextField();
		this.textFieldDescricao.setBounds(24, 114, 388, 113);
		this.frame.getContentPane().add(this.textFieldDescricao);
		this.textFieldDescricao.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NovoEventoViewImpl.this.cadastarEvento();
			}
		});
		btnConfirmar.setBounds(254, 238, 106, 23);
		this.frame.getContentPane().add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NovoEventoViewImpl.this.frame.dispose();
			}
		});
		btnCancelar.setBounds(74, 238, 106, 23);
		this.frame.getContentPane().add(btnCancelar);

		this.dateChooserInicio = new JDateChooser();
		this.dateChooserInicio.setBounds(74, 11, 129, 23);
		this.frame.getContentPane().add(this.dateChooserInicio);

		this.dateChooserFim = new JDateChooser();
		this.dateChooserFim.setBounds(276, 11, 129, 23);
		this.frame.getContentPane().add(this.dateChooserFim);

		JLabel lblIncio = new JLabel("In\u00EDcio");
		lblIncio.setBounds(24, 20, 46, 14);
		this.frame.getContentPane().add(lblIncio);

		JLabel lblFim = new JLabel("Fim");
		lblFim.setBounds(239, 20, 46, 14);
		this.frame.getContentPane().add(lblFim);

		this.frame.setBounds(100, 100, 450, 311);
	}

	protected void cadastarEvento() {
		this.presenter.salvarEvento(this.dateChooserInicio.getDate(), this.dateChooserFim.getDate(),
				this.textFieldNomeEvento.getText(), this.textFieldDescricao.getText());
		this.frame.dispose();
	}
}
