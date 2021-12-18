package card;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	JPanel WindowPanel = new JPanel();
	JPanel CardPanel = new JPanel();
	JFrame JF = new JFrame();

	Window window = new Window();

	Judge judge = new Judge(window.width, window.height);

	Player[] player = new Player[4];

	public static void main(String args[]) {
		new Main();
	}

	public Main() {

		for (int i = 0; i < 4; i++) {
			player[i] = new Player();
		}
		// window.addCard(judge.drawCard());
		// window.repaint();
		Card card;

		while (true) {
			if (window.restarted) {
				window.restarted = false;
				initGame();
				dealCard();
				window.repaint();
				System.out.println("init:");
				while (true) {
					player[0].openTouch();
					card = player[0].playCard();
					System.out.println("playcard:" + card.name);
					window.playCardPos(card);
					window.rePosition(player[0].playerCardList, 0);
				}
			} else {
				System.out.println("false");
			}
		}
	}

	public void initGame() {
		judge.initCard(window.width, window.height);
		for (int i = 0; i < 4; i++) {
			player[i].initCard();
		}
		for (int i = 0; i < judge.judgeCardList.size(); i++) {
			window.panel.add(judge.judgeCardList.get(i));
			window.panel.setComponentZOrder(judge.judgeCardList.get(i), i);
		}
	}

	public void dealCard() {
		Card card;
		for (int i = 0; i < 4; i++) {
			// draw cards from judge
			for (int j = 0; j < 7; j++) {
				card = judge.drawCard();
				player[i].drawCard(card);
			}
			// reposition the cards
			window.rePosition(player[i].playerCardList, i);
			// turn over the cards
			for (int j = 0; j < player[i].playerCardList.size(); j++) {
				player[i].playerCardList.get(j).turntoTop();
			}
		}

	}
}
