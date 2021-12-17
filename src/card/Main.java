package card;

public class Main {
	public static void main(String[] args) {
		Card card[] = new Card[110];
		Window window = new Window();
		Judge judge = new Judge();
		window.addCard(judge.drawCard());
	}
}
