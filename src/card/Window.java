package card;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

// �����࣬������ʾ�ƾ�
public class Window extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JMenuItem start, exit, about; // �˵���ť

	public Window() {
		// ��ʼ������
		this.setTitle("Uno!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(930, 620);
		this.add(panel);
		placeComponents(panel);
		SetMenu();
		this.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

//		JLabel userLabel = new JLabel(new ImageIcon("images/y0_.png"));
		Card userCard = new Card("y0_", true);
		userCard.setBounds(100, 100, 100, 155);
		panel.add(userCard);

		Card userCard1 = new Card("g0_", true);
		userCard1.setBounds(130, 100, 100, 155);
		panel.add(userCard1);

//		JButton loginButton = new JButton("һ����ť");
//		loginButton.setBounds(0, 100, 100, 25);
//
//		// ......
//		panel.add(loginButton);
	}

	// ����һ���Ƶ���
	public static void move(Card card, Point from, Point to, int t) {
		if (to.x != from.x) {
			double k = (1.0) * (to.y - from.y) / (to.x - from.x);
			double b = to.y - to.x * k;
			int flag = 0;// �ж������������ƶ�����
			if (from.x < to.x) {
				if (t % 3 == 2) {
					flag = 3;
				} else {
					flag = 10;
				}
			} else {
				if (t % 3 == 2) {
					flag = -3;
				} else {
					flag = -10;
				}
			}
			for (int i = from.x; Math.abs(i - to.x) > 20; i += flag) {
				double y = k * i + b;// ������Ҫ�õ���ѧ�е����Ժ���
				System.out.println(y + "=" + k + "*" + i + "+" + b);
				card.setLocation(i, (int) y);

				try {
					Thread.sleep(20); // �ӳ٣����Լ�����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// λ��У׼
		card.setLocation(to);
	}

	// ����������������λ��
	public static void rePosition(List<Card> list, int flag) {
		Point new_p = new Point();
		if (flag == 0) {
			// ���0 - ����� - ��
			new_p.x = (800 / 2) - (list.size() + 1) * 30 / 2;
			new_p.y = 450;
		} else if (flag == 1) {
			// ���1 - ��
			new_p.x = 50;
			new_p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
		} else if (flag == 2) {
			// ���2 - ��
			new_p.x = (800 / 2) - (list.size() + 1) * 30 / 2;
			new_p.y = 150;
		} else if (flag == 3) {
			// ���3 - ��
			new_p.x = 700;
			new_p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
		}
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Card card = list.get(i);
			Window.move(card, card.getLocation(), new_p, 10);
			// m.container.setComponentZOrder(card, 0);
			if (flag == 0 || flag == 2)
				new_p.x += 30;
			else
				new_p.y += 15;
		}
	}

	// �����˵� ���ܰ�ť
	public void SetMenu() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu game = new JMenu("��Ϸ");
		JMenu help = new JMenu("����");

		start = new JMenuItem("����Ϸ");
		exit = new JMenuItem("�˳�");
		about = new JMenuItem("����");

		start.addActionListener(this);
		exit.addActionListener(this);
		about.addActionListener(this);

		game.add(start);
		game.add(exit);
		help.add(about);

		jMenuBar.add(game);
		jMenuBar.add(help);
		this.setJMenuBar(jMenuBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
