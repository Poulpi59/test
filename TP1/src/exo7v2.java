import java.util.Scanner;

public class exo7v2 {
	public static void main(String[] args) {
		
		int n, x;
		final int y;
		System.out.println("Entrez deux nombre: ");
		Scanner key = new Scanner(System.in);
		x = key.nextInt();
		Scanner key2 = new Scanner(System.in);
		n = key2.nextInt();
		y = x; 
		for (int i=1; i<n; i++)
		{
		x = x*y;
		}
		 System.out.println("Le résultat est: "+x);
		}
}
