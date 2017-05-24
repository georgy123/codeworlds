package codewars;

public class Dinglemouse {

	private static final String FLAPORDER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";
	public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
		String[] newStr = new String[rotors.length];
		for (int j = 0; j < rotors.length; j++) {
			int sum = 0;
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < rotors[j].length; i++) {
				sum += rotors[j][i];
				int n = (FLAPORDER.indexOf(String.valueOf(lines[j].charAt(i))) + sum) % FLAPORDER.length();
				builder.append(FLAPORDER.charAt(n % FLAPORDER.length()));
			}
			newStr[j] = builder.toString();
		}
		return newStr;
	}
	public static void main(String[] args) {
		System.out.println(
				Dinglemouse.flapDisplay(new String[] { "HELLO " }, new int[][] { { 15, 49, 50, 48, 43, 13 } })[0]);
	}
}
