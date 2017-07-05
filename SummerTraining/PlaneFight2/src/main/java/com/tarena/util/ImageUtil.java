package com.tarena.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtil {
	public static BufferedImage getImage(InputStream is) {
		try {
			return ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
