package application;

public class Algorytm {

	static StringBuilder sb;

	// metoda służąca do kodowania
	public static String encode(String plainText) {
		sb = new StringBuilder();
		char temp = plainText.charAt(0);
		int count = 1;
		for (int i = 1; i < plainText.length(); i++) {
			char current = plainText.charAt(i);
			if (current == temp) {
				count++;
			} else {
				sb.append(temp).append(count).append(",");
				count = 1;
			}
			temp = current;
		}
		sb.append(temp).append(count);
		return sb.toString();
	}

	// metoda służąca do dekodowania
	public static String decode(String encodedText) {

		try {
			String encodedText2 = encodedText.replace(",", "");
			sb = new StringBuilder();
			for (int i = 0; i < encodedText2.length(); i += 2) {
				int count = Integer.parseInt("+" + encodedText2.charAt(i + 1));
				for (int j = 0; j < count; j++) {
					sb.append(encodedText2.charAt(i));
				}
			}
		} catch (Exception e) {

			System.out.println("Wprowadzono błędne dane");
		}
		return sb.toString();
	}
}
