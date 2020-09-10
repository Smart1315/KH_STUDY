package com.kh.example.dao;

public class ConvertString {

	// �����ڵ忡�� String���� ��ȯ
	public static String convertString(String val) throws Exception {
		// ��ȯ�� ���ڸ� ������ ���� ����
		StringBuffer sb = new StringBuffer();
		// ���ڸ� �ϳ��ϳ� Ž���Ѵ�.
		for (int i = 0; i < val.length(); i++) {
			// ������ \\u�� �����ϸ� 6���ڸ� ��ȯ�Ѵ�. \\uxxxx
			if ('\\' == val.charAt(i) && 'u' == val.charAt(i + 1)) {
				// �� �� �ױ��ڴ� �����ڵ��� 16���� �ڵ��̴�. int������ �ٲپ �ٽ� char Ÿ������ ���� ��ȯ�Ѵ�.
				Character r = (char) Integer.parseInt(val.substring(i + 2, i + 6), 16);
				// ��ȯ�� ���ڸ� ���ۿ� �ִ´�.
				sb.append(r);
				// for�� ���� �� 1�� 5�� ���� 6���ڸ� ����
				i += 5;
			} else {
				// ascii�ڵ�� �״�� ���ۿ� �ִ´�.
				sb.append(val.charAt(i));
			}
		}
		// ��� ����
		return sb.toString();
	}

	// String���� �����ڵ�� ��ȯ
	public static String convertUnicode(String val) {
		// ��ȯ�� ���ڸ� ������ ���� ����
		StringBuffer sb = new StringBuffer();
		// ���ڸ� �ϳ��ϳ� Ž���Ѵ�.
		for (int i = 0; i < val.length(); i++) {
			// ���� ���� int������ �����´�.
			int code = val.codePointAt(i);
			// 128���ϸ� ascii�ڵ�� ��ȯ���� �ʴ´�.
			if (code < 128) {
				sb.append(String.format("%c", code));
			} else {
				// 16���� �����ڵ�� ��ȯ�Ѵ�.
				sb.append(String.format("\\u%04x", code));
			}
		}
		// ��� ����
		return sb.toString();
	}

}
