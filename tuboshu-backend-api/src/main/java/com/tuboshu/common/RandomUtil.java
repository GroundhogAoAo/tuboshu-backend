package com.tuboshu.common;

public class RandomUtil {
	/*
	 * 获取6位随机数字
	 */
	public static String getRandom() {
		String num = "";
		for (int i = 0; i < 6; i++) {
			num = num + String.valueOf((int) Math.floor(Math.random() * 9 + 1));
		}
		return num;
	}
}
