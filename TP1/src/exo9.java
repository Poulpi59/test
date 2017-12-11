import java.util.Scanner;

public class exo9 {
public static void main(String[] args) {
		
		int x, y;
		System.out.println("Entrez un nombre: ");
		Scanner key = new Scanner(System.in);
		x = key.nextInt();
		y=0;
		for (int i=1; i<=x; i++)
		{
		y=y+i;
		}
		 System.out.println("Le résultat est: "+y);
		}
}
