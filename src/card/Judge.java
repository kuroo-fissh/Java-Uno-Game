package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Judge {
	int cardNum;
	List<Card> judgeCardList = new ArrayList<Card>();

	public Judge(int width, int height) {
		initCard(width, height);
	}

	public void initCard(int width, int height) {
		Card card;

		// initialize cards
		cardNum = 108;
		judgeCardList.removeAll(judgeCardList);
		// cards with numbers
		int init_width, init_height;
		init_width = width / 2 - 300;
		init_height = height / 2 - 100;
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < 2; j++) {
				card = new Card("b" + i, false);
				card.setLocation(init_width + (0 * 20), init_height);
				judgeCardList.add(card);

				card = new Card("g" + i, false);
				card.setLocation(init_width + (1 * 20), init_height);
				judgeCardList.add(card);

				card = new Card("r" + i, false);
				card.setLocation(init_width + (2 * 20), init_height);
				judgeCardList.add(card);

				card = new Card("y" + i, false);
				card.setLocation(init_width + (3 * 20), init_height);
				judgeCardList.add(card);
				// container.add(card[count]);
				if (i == 0)
					break;
			}
		}
		// draw2, reverse and skip cards
		for (int i = 0; i < 2; i++) {
			card = new Card("bdraw2", false);
			card.setLocation(init_width + (0 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("gdraw2", false);
			card.setLocation(init_width + (1 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("rdraw2", false);
			card.setLocation(init_width + (2 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("ydraw2", false);
			card.setLocation(init_width + (3 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("breverse", false);
			card.setLocation(init_width + (0 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("greverse", false);
			card.setLocation(init_width + (1 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("rreverse", false);
			card.setLocation(init_width + (2 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("yreverse", false);
			card.setLocation(init_width + (3 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("bskip", false);
			card.setLocation(init_width + (0 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("gskip", false);
			card.setLocation(init_width + (1 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("rskip", false);
			card.setLocation(init_width + (2 * 20), init_height);
			judgeCardList.add(card);

			card = new Card("yskip", false);
			card.setLocation(init_width + (3 * 20), init_height);
			judgeCardList.add(card);
		}
		// wild cards
		for (int i = 0; i < 4; i++) {
			card = new Card("wild", false);
			card.setLocation(300 + (i * 20), init_height);
			judgeCardList.add(card);
		}
		for (int i = 0; i < 4; i++) {
			card = new Card("wild4", false);
			card.setLocation(300 + (i * 20), init_height);
			judgeCardList.add(card);
		}
	}

	public Card drawCard() {
		Card card;
		Random random = new Random();
		int a = random.nextInt(cardNum);
		card = judgeCardList.get(a);
		judgeCardList.remove(a);
		cardNum--;
		return card;
	}
}
