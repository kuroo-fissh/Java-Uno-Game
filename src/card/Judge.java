package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Judge {
	int cardNum;
	List<Card> judgeCardList = new ArrayList<Card>();

	public Judge() {
		Card card;

		// 初始化牌
		cardNum = 108;
		// 数字牌
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < 2; j++) {
				card = new Card("b" + i, false);
				card.setLocation(300 + (0 * 20), 50);
				judgeCardList.add(card);

				card = new Card("g" + i, false);
				card.setLocation(300 + (1 * 20), 50);
				judgeCardList.add(card);

				card = new Card("r" + i, false);
				card.setLocation(300 + (2 * 20), 50);
				judgeCardList.add(card);

				card = new Card("l" + i, false);
				card.setLocation(300 + (3 * 20), 50);
				judgeCardList.add(card);
				// container.add(card[count]);
				if (i == 0)
					break;
			}
		}
		// 普通功能牌
		for (int i = 0; i < 2; i++) {
			card = new Card("bdraw2", false);
			card.setLocation(300 + (0 * 20), 50);
			judgeCardList.add(card);

			card = new Card("gdraw2", false);
			card.setLocation(300 + (1 * 20), 50);
			judgeCardList.add(card);

			card = new Card("rdraw2", false);
			card.setLocation(300 + (2 * 20), 50);
			judgeCardList.add(card);

			card = new Card("ydraw2", false);
			card.setLocation(300 + (3 * 20), 50);
			judgeCardList.add(card);

			card = new Card("breverse", false);
			card.setLocation(300 + (0 * 20), 50);
			judgeCardList.add(card);

			card = new Card("greverse", false);
			card.setLocation(300 + (1 * 20), 50);
			judgeCardList.add(card);

			card = new Card("rreverse", false);
			card.setLocation(300 + (2 * 20), 50);
			judgeCardList.add(card);

			card = new Card("yreverse", false);
			card.setLocation(300 + (3 * 20), 50);
			judgeCardList.add(card);

			card = new Card("bskip", false);
			card.setLocation(300 + (0 * 20), 50);
			judgeCardList.add(card);

			card = new Card("gskip", false);
			card.setLocation(300 + (1 * 20), 50);
			judgeCardList.add(card);

			card = new Card("rskip", false);
			card.setLocation(300 + (2 * 20), 50);
			judgeCardList.add(card);

			card = new Card("yskip", false);
			card.setLocation(300 + (3 * 20), 50);
			judgeCardList.add(card);
		}
		// 高级功能牌
		for (int i = 0; i < 4; i++) {
			card = new Card("wild", false);
			card.setLocation(300 + (i * 20), 50);
			judgeCardList.add(card);
		}
		for (int i = 0; i < 4; i++) {
			card = new Card("wild4", false);
			card.setLocation(300 + (i * 20), 50);
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
