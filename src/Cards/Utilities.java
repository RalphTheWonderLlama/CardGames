package Cards;

import Cards.Valued;

public class Utilities {
	public static void main(String[] Args) {
		int[] x = { 35, 124, 53, 1, -325, 5, 0, -23, 56, 432, 5329 };

	}

	/////////////////
	// GET FACTORS //
	/////////////////

	public static long[] getFactors(long numb) {
		int place = 0;
		long test = 1;
		long[] factors = new long[5000];
		int count = 0;
		while (test <= Math.sqrt(numb)) {
			if (numb % test == 0) {
				factors[place] = test;
				place++;
				factors[place] = numb / test;
				place++;
				count += 2;
			}
			test++;
		}
		long[] ret = new long[count];
		int p2 = 0;
		place = 0;
		while (p2 < count / 2) {
			ret[p2] = factors[place];
			place++;
			ret[ret.length - p2 - 1] = factors[place];
			p2++;
			place++;
		}
		return ret;
	}

	public static int[] getFactors(int numb) {
		int place = 0;
		int test = 1;
		int[] factors = new int[5000];
		int count = 0;
		while (test <= Math.sqrt(numb)) {
			if (numb % test == 0) {
				factors[place] = test;
				place++;
				factors[place] = numb / test;
				place++;
				count += 2;
			}
			test++;
		}
		int[] ret = new int[count];
		int p2 = 0;
		place = 0;
		while (p2 < count / 2) {
			ret[p2] = factors[place];
			place++;
			ret[ret.length - p2 - 1] = factors[place];
			p2++;
			place++;
		}
		return ret;
	}

	/////////////////////////
	// PRIME NUMBER TESTER //
	/////////////////////////

	public static boolean isPrime(long x) {
		if (x == 1) {
			return false;
		}
		boolean isPrime = true;
		long test = 2;
		while (test <= Math.sqrt(x)) {
			if (x % test == 0) {
				isPrime = false;
				break;
			}
			if (test % 2 == 0) {
				test++;
			} else {
				test += 2;
			}

		}
		return isPrime;
	}

	public static boolean isPrime(int x) {
		if (x == 1) {
			return false;
		}
		boolean isPrime = true;
		int test = 2;
		while (test <= Math.sqrt(x)) {
			if (x % test == 0) {
				isPrime = false;
				break;
			}
			if (test % 2 == 0) {
				test++;
			} else {
				test += 2;
			}

		}
		return isPrime;
	}

	///////////////////////////
	// PERFECT NUMBER TESTER //
	///////////////////////////

	public static boolean isPerfect(int x) {
		int[] factors = getFactors(x);
		int test = addArray(factors);
		if (test == x) {
			return true;
		} else {
			return false;
		}
	}

	////////////////
	// ADD ARRAYS //
	////////////////

	public static int addArray(int[] x) {
		int sum = 0;
		for (int pos = 0; pos < x.length; pos++) {
			sum += x[pos];
		}
		return sum;
	}

	public static long addArray(long[] x) {
		long sum = 0;
		for (int pos = 0; pos < x.length; pos++) {
			sum += x[pos];
		}
		return sum;
	}

	public static double addArray(double[] x) {
		double sum = 0;
		for (int pos = 0; pos < x.length; pos++) {
			sum += x[pos];
		}
		return sum;
	}

	/////////////////////
	// PRINTING ARRAYS //
	/////////////////////

	public static void printArray(int[] x) {
		System.out.print("[");
		for (int pos = 0; pos < x.length - 1; pos++) {
			System.out.print(x[pos] + ", ");
		}
		System.out.println(x[x.length - 1] + "]");
	}

	public static void printArray(int[] x, String p, int i) {
		for (int pos = 0; pos < x.length; pos++) {
			if (pos % i == 9) {
				System.out.println(x[pos] + p);
			} else {
				System.out.print(x[pos] + p);
			}
		}
		System.out.println();

	}

	public static void printArray(double[] x) {
		System.out.print("[");
		for (int pos = 0; pos < x.length - 1; pos++) {
			System.out.print(x[pos] + ", ");
		}
		System.out.println(x[x.length - 1] + "]");
	}

	public static void printArray(double[] x, String p, int i) {
		for (int pos = 0; pos < x.length; pos++) {
			if (pos % i == 9) {
				System.out.println(x[pos] + p);
			} else {
				System.out.print(x[pos] + p);
			}
		}
		System.out.println();

	}

	public static void printArray(String[] x) {
		System.out.print("[");
		for (int pos = 0; pos < x.length - 1; pos++) {
			System.out.print(x[pos] + ", ");
		}
		System.out.println(x[x.length - 1] + "]");
	}

	public static void printArray(String[] x, String p, int i) {
		for (int pos = 0; pos < x.length; pos++) {
			if (pos % i == 9) {
				System.out.println(x[pos] + p);
			} else {
				System.out.print(x[pos] + p);
			}
		}
		System.out.println();
	}

	public static void printArray(long[] x) {
		System.out.print("[");
		for (int pos = 0; pos < x.length - 1; pos++) {
			System.out.print(x[pos] + ", ");
		}
		System.out.println(x[x.length - 1] + "]");
	}

	public static void printArray(long[] x, String p, int i) {
		for (int pos = 0; pos < x.length; pos++) {
			if (pos % i == 9) {
				System.out.println(x[pos] + p);
			} else {
				System.out.print(x[pos] + p);
			}
		}
		System.out.println();
	}

	public static void printArray(Object[] x, String p, int i) {
		for (int pos = 0; pos < x.length; pos++) {
			if (pos % i == 9) {
				System.out.println(x[pos] + p);
			} else {
				System.out.print(x[pos] + p);
			}
		}
		System.out.println();
	}

	public static void printArray(Object[] x) {
		System.out.print("[");
		for (int pos = 0; pos < x.length - 1; pos++) {
			System.out.print(x[pos] + ", ");
		}
		System.out.println(x[x.length - 1] + "]");
	}

	////////////////////
	// COPYING ARRAYS //
	////////////////////

	public static int[] copyArray(int[] x) {
		int[] y = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		return y;
	}

	public static double[] copyArray(double[] x) {
		double[] y = new double[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		return y;
	}

	public static long[] copyArray(long[] x) {
		long[] y = new long[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		return y;
	}

	public static String[] copyArray(String[] x) {
		String[] y = new String[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		return y;
	}

	public static boolean[] copyArray(boolean[] x) {
		boolean[] y = new boolean[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		return y;
	}

	public static Object[] copyArray(Object[] x) {
		Object[] y = new Object[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		return y;
	}

	/////////////
	// inArray //
	/////////////

	public static boolean inArray(int[] x, int y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return true;
			}
		}
		return false;
	}

	public static boolean inArray(double[] x, double y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return true;
			}
		}
		return false;
	}

	public static boolean inArray(long[] x, long y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return true;
			}
		}
		return false;
	}

	public static boolean inArray(String[] x, String y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i].equals(y)) {
				return true;
			}
		}
		return false;
	}

	public static boolean inArray(char[] x, char y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return true;
			}
		}
		return false;
	}

	/////////////////
	// getPosition //
	/////////////////

	public static int getPosition(int[] x, int y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return i;
			}
		}
		return -1;
	}

	public static int getPosition(double[] x, double y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return i;
			}
		}
		return -1;
	}

	public static int getPosition(long[] x, long y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				return i;
			}
		}
		return -1;
	}

	public static int getPosition(String[] x, String y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i].equals(y)) {
				return i;
			}
		}
		return -1;
	}

	public static int getPosition(char[] x, char y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == (y)) {
				return i;
			}
		}
		return -1;
	}

	/////////////////
	// getGreatest //
	/////////////////

	public static int getGreatest(int[] x) {
		int g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] >= g) {
				g = x[i];
			}
		}
		return g;
	}

	public static double getGreatest(double[] x) {
		double g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] >= g) {
				g = x[i];
			}
		}
		return g;
	}

	public static long getGreatest(long[] x) {
		long g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] >= g) {
				g = x[i];
			}
		}
		return g;
	}

	public static Valued getGreatest(Valued[] x) {
		Valued g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i].getValue() >= g.getValue()) {
				g = x[i];
			}
		}
		return g;
	}

	//////////////
	// getLeast //
	//////////////

	public static int getLeast(int[] x) {
		int g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] <= g) {
				g = x[i];
			}
		}
		return g;
	}

	public static double getLeast(double[] x) {
		double g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] <= g) {
				g = x[i];
			}
		}
		return g;
	}

	public static long getLeast(long[] x) {
		long g = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] <= g) {
				g = x[i];
			}
		}
		return g;
	}

	////////////
	// GetGCF //
	////////////

	public static int getGCF(int a, int b) {
		int[] af = getFactors(a);
		int[] bf = getFactors(b);
		int gcf = 0;
		for (int i = 0; i < af.length; i++) {
			if (inArray(bf, af[i])) {
				gcf = af[i];
			}
		}
		return gcf;
	}

	//////////////////
	// compileArray //
	//////////////////

	public static int[] compileArray(int[] a, int[] b) {
		int x[] = new int[a.length + b.length];
		int pos = 0;
		for (int i = 0; i < a.length; i++) {
			x[pos] = a[i];
			pos++;
		}
		for (int i = 0; i < b.length; i++) {
			x[pos] = b[i];
			pos++;
		}
		return x;
	}

	//////////////////////
	// countAppearances //
	//////////////////////

	public static int countAppearance(int a, int[] b) {
		int x = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == a) {
				x++;
			}
		}
		return x;
	}

	public static int countAppearance(double a, double[] b) {
		int x = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == a) {
				x++;
			}
		}
		return x;
	}

	///////////////
	// binSearch //
	///////////////

	public static int binSearch(int[] a, int target) {
		int max = a.length - 1;
		int min = 0;
		while (max >= min) {
			int mid = (max + min) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (a[mid] > target) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return -1;
	}

	public static int binSearch(double[] a, double target) {
		int max = a.length - 1;
		int min = 0;
		while (max >= min) {
			int mid = (max + min) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (a[mid] > target) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return -1;
	}

	public static int binSearch(String[] a, String target) {
		int max = a.length - 1;
		int min = 0;
		while (max >= min) {
			int mid = (max + min) / 2;
			if (a[mid].equals(target)) {
				return mid;
			} else if (a[mid].compareTo(target) > 0) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return -1;
	}

	////////////////
	// orderArray //
	////////////////

	public static int[] orderArray(int[] list) {
		int[] a = new int[list.length];
		int[] b = copyArray(list);
		int g = getGreatest(b);
		for (int i = 0; i < a.length; i++) {
			int c = getLeast(b);
			a[i] = c;
			b[getPosition(b, c)] = g;
		}
		return a;
	}

	//////////////
	// MATRICES //
	//////////////

	public static double[] matrixMult(double[] a, double[][] b) {
		if (a.length != b.length || b.length != b[0].length) {
			throw new IllegalArgumentException();
		}
		double[] ret = new double[a.length];
		for (int c = 0; c < ret.length; c++) {
			for (int r = 0; r < 3; r++) {
				ret[0] += a[r] * b[r][c];
			}
		}
		return ret;
	}
}
