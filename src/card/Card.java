package card;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// manage cards
public class Card extends JLabel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int color;
	int number;
	int draw2;
	int skip;
	int change;
	boolean faceup;
	boolean enter_en = false;
	boolean click_en = false;
	boolean clicked = false;

	public Card(String name, boolean faceup) {
		this.name = name;
		this.faceup = faceup;
		this.clicked = false;
		if (this.faceup)
			this.turntoTop();
		else {
			this.turntoBottom();
		}
		this.setSize(100, 155);
		this.setVisible(true);
		this.addMouseListener(this);
	}

	public void turntoTop() {
		this.setIcon(new ImageIcon("images/" + name + ".png"));
		this.faceup = true;
	}

	public void turntoBottom() {
		this.setIcon(new ImageIcon("images/back.png"));
		this.faceup = false;
	}

	public void closeTouch() {
		enter_en = false;
		click_en = false;
	}

	public void openTouch() {
		enter_en = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (click_en && e.getClickCount() == 2) {
			System.out.println("Currently click on:" + this.name);
			System.out.println("ko no card da!   " + this.name);
			// Point from = this.getLocation();
			// Window.move(this, from, new Point(from.x + 200, from.y + 60), 10);
			clicked = true;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (enter_en) {
			click_en = true;
			System.out.println("mouse entered");
			Point from = this.getLocation();
			Window.move(this, from, new Point(from.x, from.y - 30), 10);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (enter_en) {
			click_en = false;
			System.out.println("mouse exited");
			Point from = this.getLocation();
			Window.move(this, from, new Point(from.x, from.y + 30), 10);
		}

	}
}