/**
 * 
 */
package com.tarena.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*****************************************************
 *
 * 项目名称：PlaneFight
 * 类名称：ImageUtil
 * 类描述：
 * 创建人：skyfervor
 * 创建时间：Jul 16, 2015 11:23:41 PM
 * 修改人：skyfervor
 * 修改时间：Jul 16, 2015 11:23:41 PM
 * 修改备注：
 *
 * @version
 *
 *****************************************************/
public class ImageUtil {
	public static BufferedImage getImage(String name) {
		try {
			return ImageIO.read(new File(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
