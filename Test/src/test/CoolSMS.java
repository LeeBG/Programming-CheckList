package test;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CoolSMS extends JFrame implements ActionListener {
	private Container c;
	private JLabel la_phoneNum, la_message;
	private JButton send, init; // 전송 초기화
	private JTextField phoneT, messageT;
	private JPanel jp;
	private GridLayout grid;

	public CoolSMS() {
		initObject();
		initSetting();
		initBatch();
		setVisible(true);
	}

	private void initSetting() {
		setTitle("CoolSMS");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid = new GridLayout(3, 2);
		grid.setVgap(1);
		jp = new JPanel();
		jp.setLayout(grid);
		c = getContentPane();
	}

	private void initBatch() {
		c.add(jp);
		jp.add(la_phoneNum);
		jp.add(phoneT);
		jp.add(la_message);
		jp.add(messageT);
		jp.add(send);
		jp.add(init);
		send.addActionListener(this);
		init.addActionListener(this);
	}

	private void initObject() {
		la_phoneNum = new JLabel("전화번호");
		la_message = new JLabel("메시지");
		send = new JButton("전송");
		init = new JButton("초기화");
		phoneT = new JTextField("");
		messageT = new JTextField("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		ExampleSend ex = new ExampleSend();

		if (btn.getText().equals("전송")) {
			ex.SendM(phoneT.getText(), messageT.getText());
			
			if(ex.getErr()==false) {
				JOptionPane.showMessageDialog(null, "메시지가 전송되었습니다", "전송완료", JOptionPane.PLAIN_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "메시지가 전송실패", "전송실패", JOptionPane.WARNING_MESSAGE);
			
		} else if (btn.getText().equals("초기화")) {
			phoneT.setText(null);
			messageT.setText(null);
			JOptionPane.showMessageDialog(null, "초기화 되었습니다.", "초기화", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new CoolSMS();
	}
}
