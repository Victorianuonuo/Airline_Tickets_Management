import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InfoDialog extends JDialog{
	
	private JLabel text=new JLabel("attention",SwingConstants.CENTER);

	public InfoDialog(Frame parent) {
		// TODO Auto-generated constructor stub
		super(parent, "Attention");
		setLayout(new BorderLayout());
		add(text,BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void setText(String message) {
		text.setText(message);
	}
	
}
