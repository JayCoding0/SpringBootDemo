package com.example.demo.tool.utils;

import org.apache.xmlbeans.impl.util.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Util {
	private static Base64Util instance = new Base64Util();

	static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

	static private byte[] codes = new byte[1024];

	static {
		for (int i = 0; i < 256; i++) {
			codes[i] = -1;
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			codes[i] = (byte) (i - 'A');
		}
		for (int i = 'a'; i <= 'z'; i++) {
			codes[i] = (byte) (26 + i - 'a');
		}
		for (int i = '0'; i <= '9'; i++) {
			codes[i] = (byte) (52 + i - '0');
		}
		codes['+'] = 62;
		codes['/'] = 63;
	}

	private Base64Util() {
	}

	public static synchronized Base64Util getInstance() {
		if (instance == null) {
			instance = new Base64Util();
		}
		return instance;
	}

	/**
	 * ��ȡϵͳĬ�ϱ���
	 */
	private String getDefaultEncoding() {
		return System.getProperty("file.encoding", "UTF-8");
	}

	/**
	 * �����ݽ���Base64����
	 */
	public String encode(String str) throws UnsupportedEncodingException {
		return encode(str, getDefaultEncoding());
	}

	/**
	 * �����ݽ���Base64����
	 */
	public String encode(String str, String encoding) throws UnsupportedEncodingException {
		if (str == null || "".equals(str.trim())) {
			return "";
		}
		byte[] data = str.getBytes(encoding);
		char[] out = new char[((data.length + 2) / 3) * 4];
		for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
			boolean quad = false;
			boolean trip = false;
			int val = (0xFF & (int) data[i]);
			val <<= 8;
			if ((i + 1) < data.length) {
				val |= (0xFF & (int) data[i + 1]);
				trip = true;
			}
			val <<= 8;
			if ((i + 2) < data.length) {
				val |= (0xFF & (int) data[i + 2]);
				quad = true;
			}
			out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 1] = alphabet[val & 0x3F];
			val >>= 6;
			out[index] = alphabet[val & 0x3F];
		}

		return new String(out);
	}

	/**
	 * �����ݽ���Base64����
	 */
	public String decode(String str, String encoding) throws UnsupportedEncodingException {
		if (str == null || "".equals(str.trim())) {
			return "";
		}
		char[] data = str.toCharArray();
		int len = ((data.length + 3) / 4) * 3;
		if (data.length > 0 && data[data.length - 1] == '=') {
			--len;
		}
		if (data.length > 1 && data[data.length - 2] == '=') {
			--len;
		}
		byte[] out = new byte[len];
		int shift = 0;
		int accum = 0;
		int index = 0;
		for (int ix = 0; ix < data.length; ix++) {
			int value = codes[data[ix] & 0xFF];
			if (value >= 0) {
				accum <<= 6;
				shift += 6;
				accum |= value;
				if (shift >= 8) {
					shift -= 8;
					out[index++] = (byte) ((accum >> shift) & 0xff);
				}
			}
		}
		if (index != out.length) {
			return null;
			// throw new Error("miscalculated data length!");
		}

		return new String(out, encoding);
	}

	/** */
	/**
	 * <p>
	 * BASE64�ַ�������Ϊ����������
	 * </p>
	 *
	 * @param base64
	 * @return
	 * @throws Exception
	 */
	public static byte[] decode(String base64) throws Exception {
		return Base64.decode(base64.getBytes());
	}

	/** */
	/**
	 * <p>
	 * ���������ݱ���ΪBASE64�ַ���
	 * </p>
	 *
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode(byte[] bytes) throws Exception {
		return new String(Base64.encode(bytes));
	}
}
