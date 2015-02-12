package edu.uj.pdpum.dynprog.lcs;

public class LCSSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(calculateLCS("abc", "bdc"));
		System.out.println();
		

	}
	
	private static int calculateLCS(String a, String b) {
		int[][] lcs = new int[a.length() + 1][];
		char[][] dir = new char[a.length() + 1][];
		for (int i = 0; i <= a.length(); i++) {
			lcs[i] = new int[b.length() + 1];
			dir[i] = new char[b.length() + 1];
			for (int k = 0; k <= b.length(); k++) {
				lcs[i][k] = 0;
				dir[i][k] = '.';
			}
		}
		
		for (int i = 1; i <= a.length(); i++) {
			for (int k = 1; k <= b.length(); k++) {
				char ca = a.charAt(i - 1);
				char cb = b.charAt(k - 1);
				if (ca == cb) {
					lcs[i][k] = lcs[i-1][k-1] + 1;
					dir[i][k] = '\\';
				} else if (lcs[i-1][k] > lcs[i][k-1]) {
					lcs[i][k] = lcs[i-1][k];
					dir[i][k] = '|';
				} else {
					lcs[i][k] = lcs[i][k-1];
					dir[i][k] = '-';
				}
			}
		}
		
		printArrays(lcs, dir);
		
		return lcs[a.length()][b.length()];
	}
	
	private static void printArrays(int[][] t, char[][] d) {
		for (int i = 0; i < t.length; i++) {
			for (int k = 0; k < t[i].length; k++) {
				System.out.print(String.format("%1$3d%2$1c", t[i][k], d[i][k]));				
			}
			System.out.println();
		}
	}

}
