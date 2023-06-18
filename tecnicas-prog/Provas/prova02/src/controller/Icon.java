package controller;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Icon{
	
	private Image img;
	
	public Icon(String caminho) {
		ImageIcon icon = new ImageIcon(caminho);
		Image image = icon.getImage();
		setImg(image);
	}
	
	public ImageIcon getIcon(int width, int heigth) {
		Image resizedImage = getImg().getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	
}
