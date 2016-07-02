package com.victoria.Frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import com.victoria.Entity.*;
import com.victoria.mysql.DataBase;
import com.victoria.mysql.SQL;

public class UnprintedTicketFrame extends JFrame{//��ʾ���û������ж���״̬
	
	private DefaultListModel<UnprintedTicket> model;
    final JList<UnprintedTicket> list;
    private JButton printButton;
    private JPanel printPanel;
    private UnprintedTicket tk;
    private String user;

	public UnprintedTicketFrame(String user) {
		// TODO Auto-generated constructor stub
		super("�Ѷ���Ʊ");
		this.user=user;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);//�����С���ɸı�
		setLayout(new BorderLayout());
		
		model= new DefaultListModel<UnprintedTicket>();
    	list=new JList<UnprintedTicket>(model);
    	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	list.addListSelectionListener(new ListSelectionListener() {//ѡ���б��е�ĳ���������д�ӡ
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				UnprintedTicket unprintedTicket = list.getSelectedValue();
                if (unprintedTicket != null) {
                	tk=unprintedTicket;
                }
			}
		});
    	initList();
    	add(new JScrollPane(list),BorderLayout.CENTER);
    	
    	printButton=new JButton("��ӡ");
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
					PrintFrame printFrame=new PrintFrame(tk.getTicket_id(),user);//��ʾ��ӡ��������
					setVisible(false);
					dispose();
				}
			}
		});
    	add(printPanel, BorderLayout.EAST);
    	
    	setSize(300, 300);
    	setResizable(false);//�����С���ɸı�
    	setLocationRelativeTo(null);//����һֱλ����Ļ����
    	setVisible(true);
	}
	
	private void initList(){
		SQL sql=new SQL();
		sql.select("booking_reference, flight_id, flight_date, class_name, worth "
				, " ticket_query "," true ");
		DataBase db=new DataBase();
		System.err.println(sql.toString());
		ArrayList<ArrayList<String>> res=db.query(sql.toString());
		for(ArrayList<String> tmp:res){
			UnprintedTicket unprintedTicket=new UnprintedTicket(tmp);
			model.addElement(unprintedTicket);
		}
	}
	
}
