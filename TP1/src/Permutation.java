import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		int x, y, temp;
		Scanner key = new Scanner(System.in);
		String reponse;
		do {
		System.out.println("Entrer deux nombres : ");
		x = key.nextInt();
		y = key.nextInt();
		System.out.println("x = " + x + "\t y = " + y);
		// permutation
		temp = x;
		x = y;
		y = temp;
		System.out.println("x = " + x + "\t y = " + y);
		System.out.println("Pour continuer taper oui : ");
		reponse = key.next();
		} while (reponse.equals("oui"));
	}

}
