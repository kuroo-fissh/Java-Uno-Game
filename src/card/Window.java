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

// 窗口类，负责显示牌局
public class Window extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JMenuItem start, exit, about; // 菜单按钮

	public Window() {
		// 初始化窗口
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

//		JButton loginButton = new JButton("一个按钮");
//		loginButton.setBounds(0, 100, 100, 25);
//
//		// ......
//		panel.add(loginButton);
	}

	public void addCard(Card card) {
		card.setBounds(200, 300, 100, 155);
		panel.add(card);
	}

	// 进行一个牌的移
	public static void move(Card card, Point from, Point to, int t) {
		if (to.x != from.x) {
			double k = (1.0) * (to.y - from.y) / (to.x - from.x);
			double b = to.y - to.x * k;
			int flag = 0;// 判断向左还是向右移动步幅
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
				double y = k * i + b;// 这里主要用的数学中的线性函数
				System.out.println(y + "=" + k + "*" + i + "+" + b);
				card.setLocation(i, (int) y);

				try {
					Thread.sleep(20); // 延迟，可自己设置
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// 位置校准
		card.setLocation(to);
	}

	// 根据牌数重置手牌位置
	public static void rePosition(List<Card> list, int flag) {
		Point new_p = new Point();
		if (flag == 0) {
			// 玩家0 - 本玩家 - 下
			new_p.x = (800 / 2) - (list.size() + 1) * 30 / 2;
			new_p.y = 450;
		} else if (flag == 1) {
			// 玩家1 - 左
			new_p.x = 50;
			new_p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
		} else if (flag == 2) {
			// 玩家2 - 上
			new_p.x = (800 / 2) - (list.size() + 1) * 30 / 2;
			new_p.y = 150;
		} else if (flag == 3) {
			// 玩家3 - 右
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

	// 创建菜单 功能按钮
	public void SetMenu() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu game = new JMenu("游戏");
		JMenu help = new JMenu("帮助");

		start = new JMenuItem("新游戏");
		exit = new JMenuItem("退出");
		about = new JMenuItem("关于");

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
