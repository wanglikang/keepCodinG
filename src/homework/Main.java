package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author WLK 创建时间: 2018年3月16日 下午2:14:59
 */

public class Main {
	private static final int STATE_INIT = 0;
	private static final int STATE_NORMAL = 1;
	private static final int STATE_ERROR = -1;
	private int state = STATE_INIT;

	private int[] location = new int[3];
	private int[] prelocation = new int[3];
	private int[] templocation = new int[3];
	private int[][] resultlocation = new int[1000][4];
	private int countResult = 0;
	private String name = "";

	
	public static void main(String[] args) {
		String filepath = "./data.txt";
		if(args.length>0)
			filepath = args[1];
		
		Main mm = new Main();
		try {
			mm.readData(filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		int i;
		while (scanner.hasNext()) {
			i = scanner.nextInt();
			mm.dealRuestion(i);
		}
	}

	public void dealRuestion(int n) {
		if (countResult <= n)
			System.out.println("Cannot find " + n);
		else if (resultlocation[n][3] == STATE_ERROR)
			System.out.println("Error: " + n);
		else {
			System.out.println(name + " " + n + " "
					+ resultlocation[n][0] + " "
					+ resultlocation[n][1] + " "
					+ resultlocation[n][2]);
		}
	}

	
	/**
	 * 此函数用于从文件中读取记录
	 * 
	 * @param filepath 要读取的文件路径
	 * @throws Exception
	 */
	private void readData(String filepath) throws Exception {
		File f = new File(filepath);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line = "";
		String lines[] = null;
		while (br.ready()) {
			sb.setLength(0);
			sb.append(br.readLine());

			if (state == STATE_ERROR) {
				dealWithError();
				continue;
			}

			line = sb.toString();
			lines = line.split(" ");
			if (!isCorrMessage(lines, lines.length)) {
				dealWithError();
				continue;
			}

			if (state == STATE_INIT) {// 当前状态是初始状态
				dealWithInitMessage(lines);
					state = STATE_NORMAL;
			} else if (state == STATE_NORMAL) {// 当前状态都是正常状态
				if (lines.length == 4) {// 消息长度为4
					dealWithError();
					continue;
				} else if (lines.length == 7) {// 消息长度为7
					if(!dealWithMessage(lines)) {
						dealWithError();
					}
				} else {// 其他为错误的消息
					dealWithError();
				}
			}
		}
	}

	public void dealWithError() {
		state = STATE_ERROR;
		resultlocation[countResult][3] = state;
		countResult++;
	}
	/**
	 * 处理第一次的消息
	 *
	 */
	public void dealWithInitMessage(String[] lines) {
		name = lines[0];
		location[0] = Integer.parseInt(lines[1]);
		location[1] = Integer.parseInt(lines[2]);
		location[2] = Integer.parseInt(lines[3]);
		copyArray(resultlocation[countResult], location, 3);
		resultlocation[countResult][3] = state;
		countResult++;
	}

	/**
	 * 处理格式正常的消息，,包括判断坐标是否与上一坐标相等
	 * @param lines 分割后的消息字符数组
	 */
	public boolean dealWithMessage(String[] lines) {
		prelocation[0] = Integer.parseInt(lines[1]);
		prelocation[1] = Integer.parseInt(lines[2]);
		prelocation[2] = Integer.parseInt(lines[3]);

		templocation[0] = Integer.parseInt(lines[4]) + prelocation[0];
		templocation[1] = Integer.parseInt(lines[5]) + prelocation[1];
		templocation[2] = Integer.parseInt(lines[6]) + prelocation[2];

		if (comparyArray(prelocation, location, 3)) {
			copyArray(location, templocation, 3);
			copyArray(resultlocation[countResult], location, 3);
			resultlocation[countResult][3] = state;
			countResult++;
			return true;
		} else {
			state = STATE_ERROR;
			return false;
		}
	}

	/***
	 *  比较坐标数组是否相同
	 * @param a1
	 * @param a2
	 * @param len 数组长度
	 * @return
	 */
	public boolean comparyArray(int a1[], int[] a2, int len) {
		for (int i = 0; i < len; i++)
			if (a1[i] != a2[i])
				return false;

		return true;
	}

	
	/**
	 * 将a2数组的前len个内容复制到a1中
	 * @param a1
	 * @param a2
	 * @param len
	 */
	public void copyArray(int[] a1, int[] a2, int len) {
		for (int i = 0; i < len; i++) {
			a1[i] = a2[i];
		}
	}

	/**
	 * 判断此消息是不是格式正确的消息
	 * @param lines 分割过的消息数组
	 * @param messagelen
	 * @return
	 */
	public boolean isCorrMessage(String[] lines, int messagelen) {
		int currstate = STATE_NORMAL;

		if (!isLegalName(lines[0]))
			currstate = STATE_ERROR;

		for (int i = 1; i < messagelen; i++) {
			if (!isCorrNum(lines[i])) {
				currstate = STATE_ERROR;
				break;
			}
		}

		return currstate != STATE_ERROR;
	}

	/**
	 * 判断ch是否为数字
	 * @param ch
	 * @return
	 */
	public boolean isNum(char ch) {
		if ('0' <= ch && ch <= '9')
			return true;
		else
			return false;
	}

	/**
	 * 判断ch是否为字母
	 * @param ch
	 * @return
	 */
	public boolean isAlpha(char ch) {
		if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'))
			return true;
		else
			return false;
	}

	/**
	 * 判断参数name是否为一个合法的无人机ID
	 * @param name
	 * @return
	 */
	public boolean isLegalName(String name) {
		char[] chs = name.toCharArray();
		int len = chs.length;
		if (isNum(chs[0]))// 猜测 无人机ID 的开头第一个字符不能是数字
			return false;

		for (int i = 1; i < len; i++) {//只由字母或数字组成
			if (!isNum(chs[i]) && !isAlpha(chs[i]))
				return false;
		}
		return true;
	}


	/**
	 * 判断是否能格式正确的数字
	 * @param str
	 * @return
	 */
	public boolean isCorrNum(String str) {
		try {
			int i = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ne) {
			return false;
		}
	}

}
