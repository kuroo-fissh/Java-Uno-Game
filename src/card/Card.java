package card;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// 卡牌管理类
public class Card extends JLabel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	boolean faceup;
	boolean click_en = true;
	boolean clicked = false;

	public Card(String name, boolean faceup) {
		this.name = name;
		this.faceup = faceup;
		if (this.faceup)
			this.turntoTop();
		else {
			this.turntoBottom();
		}
		// this.setSize(220, 340);
		this.setVisible(true);
		this.addMouseListener(this);
	}

	public void turntoTop() {
		this.setIcon(new ImageIcon("images/" + name + ".png"));
		this.faceup = true;
	}

	public void turntoBottom() {
		this.setIcon(new ImageIcon("images/" + name + ".png"));
		this.faceup = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (click_en) {
			Point from = this.getLocation();
			int step;
			if (clicked)
				step = -30;
			else {
				step = 30;
			}

			clicked = !clicked;
			Window.move(this, from, new Point(from.x, from.y - step), 10);
		}
		System.out.println("鼠标点击");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标按下");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标松开");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标进入组件区域");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标离开组件区域");
	}
}