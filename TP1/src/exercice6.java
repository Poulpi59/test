import java.util.Scanner;


public class exercice6 {
	public static void main(String[] args) {
		final int min = 1;
		final int max = 9;
	double x;
	Scanner key = new Scanner(System.in);
	do {
	System.out.println("Choisir un nombre entre 1 et 9: ");
	x = key.nextDouble();
	}
		while (x<min || x>max);
	}
}
