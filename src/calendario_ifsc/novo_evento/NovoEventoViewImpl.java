package calendario_ifsc.novo_evento;

import java.util.Properties;

import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import calendario_ifsc.utils.DateLabelFormatter;

public class NovoEventoViewImpl implements NovoEventoView {

	private JFrame frame;
	private JDatePickerImpl datePicker;

	@Override
	public void setPresenter(NovoEventoPresenter novoEventoPresenter) {
		// TODO Auto-generated method stub

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
		this.frame.add(datePanel);

	}

}
