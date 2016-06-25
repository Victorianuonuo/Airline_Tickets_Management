import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AllTicketFrame extends JFrame{
	
	private DefaultListModel<Ticket> model;
    final JList<Ticket> list;
    private JButton printButton;
    private JPanel printPanel;
    private Ticket tk;
	
	public AllTicketFrame() {
		// TODO Auto-generated constructor stub
		super("ÒÑ¶©»úÆ±");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		model= new DefaultListModel<Ticket>();
    	list=new JList<Ticket>(model);
    	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Ticket ticket = list.getSelectedValue();
                if (ticket != null) {
                	tk=ticket;
                }
			}
		});
    	initList();
    	add(new JScrollPane(list),BorderLayout.CENTER);
    	
    	printButton=new JButton("´òÓ¡");
    	printPanel=new JPanel();
    	printPanel.setLayout(new GridLayout(5, 1));
    	printPanel.add(new JLabel());
    	printPanel.add(new JLabel());
    	printPanel.add(printButton);
    	printPanel.add(new JLabel());
    	printPanel.add(new JLabel());
    	printButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tk!=null){
					PrintFrame printFrame=new PrintFrame(tk);
				}
			}
		});
    	add(printPanel, BorderLayout.EAST);
    	
    	setSize(300, 300);
    	setResizable(false);
    	setLocationRelativeTo(null);
    	setVisible(true);
	}
	
	private void initList(){
		
	}
	
}
