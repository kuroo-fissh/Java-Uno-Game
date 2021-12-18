package card;

import java.util.ArrayList;
import java.util.List;

public class Player {
	int cardNum = 0;
	List<Card> playerCardList = new ArrayList<Card>();

	public Player() {
		cardNum = 0;
	}

	public void initCard() {
		cardNum = 0;
		playerCardList.removeAll(playerCardList);
	}

	public void drawCard(Card card) {
		playerCardList.add(card);
	}

	public void openTouch() {
		for (int i = 0; i < playerCardList.size(); i++) {
			playerCardList.get(i).openTouch();
		}
	}

	public Card playCard() {
		Card card = null;
		while (true) {
			for (int i = 0; i < playerCardList.size(); i++) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("card:" + playerCardList.get(i).name);
				if (playerCardList.get(i).clicked) {
					card = playerCardList.get(i);
					break;
				}
			}
			if (card != null)
				break;
		}
		card.clicked = false;
		card.closeTouch();
		playerCardList.remove(card);
		return card;
	}

}
