package card;

import java.util.ArrayList;
import java.util.List;

public class Player {
	int cardNum = 0;
	List<Card> playerCardList = new ArrayList<Card>();

	public void getCard(Card card) {
		playerCardList.add(card);
	}
}
