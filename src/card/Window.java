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
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

// 绐��ｇ被锛�璐�璐ｆ�剧ず��灞�
public class Window extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JMenuItem start, exit, about; // ��������

	public Window() {
		// ��濮���绐���
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
		Card userCard = new Card("y0", true);
		userCard.setBounds(100, 100, 100, 155);
		panel.add(userCard);

		Card userCard1 = new Card("g0", true);
		userCard1.setBounds(130, 100, 100, 155);
		panel.add(userCard1);

//		JButton loginButton = new JButton("涓�涓�����");
//		loginButton.setBounds(0, 100, 100, 25);
//
//		// ......
//		panel.add(loginButton);
	}

	public void addCard(Card card, int tmp) {
		card.setBounds(200 + tmp * 30, 300, 100, 155);
		panel.add(card);
	}

	// 杩�琛�涓�涓�����绉�
	public static void move(Card card, Point from, Point to, int t) {
		if (to.x != from.x) {
			double k = (1.0) * (to.y - from.y) / (to.x - from.x);
			double b = to.y - to.x * k;
			int flag = 0;// �ゆ����宸�杩������崇Щ�ㄦ�ュ�
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
				double y = k * i + b;// 杩���涓昏��ㄧ���板��涓���绾挎�у�芥��
				System.out.println(y + "=" + k + "*" + i + "+" + b);
				card.setLocation(i, (int) y);

				try {
					Thread.sleep(20); // 寤惰�锛�����宸辫�剧疆
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// 浣�缃��″��
		card.setLocation(to);
	}

	// �规�����伴��缃�����浣�缃�
	public static void rePosition(List<Card> list, int flag) {
		Point new_p = new Point();
		if (flag == 0) {
			// �╁��0 - ���╁�� - 涓�
			new_p.x = (800 / 2) - (list.size() + 1) * 30 / 2;
			new_p.y = 450;
		} else if (flag == 1) {
			// �╁��1 - 宸�
			new_p.x = 50;
			new_p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
		} else if (flag == 2) {
			// �╁��2 - 涓�
			new_p.x = (800 / 2) - (list.size() + 1) * 30 / 2;
			new_p.y = 150;
		} else if (flag == 3) {
			// �╁��3 - ��
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

	// ��寤鸿���� ���芥����
	public void SetMenu() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");

		start = new JMenuItem("New game");
		exit = new JMenuItem("Exit");
		about = new JMenuItem("About");

		start.addActionListener(this);
		exit.addActionListener(this);
		about.addActionListener(this);

		game.add(start);
		game.add(exit);
		help.add(about);

		jMenuBar.add(game);
		jMenuBar.add(help);
		this.setJMenuBar(jMenuBar);

		start.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Start game");
					Judge judge = new Judge();
					for(int i = 0; i <= 5; i++)
					{
						Card card = judge.drawCard();
						addCard(card, i);
						repaint();
					}
					
				}
			}
		);

		exit.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Exit");
				}
			}
		);

		about.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("About");
				}
			}
		);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
