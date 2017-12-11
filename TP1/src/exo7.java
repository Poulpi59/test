import java.util.Scanner;

public class exo7 {
	public static void main(String[] args) {
		
	int x;
	System.out.println("Entrez un nombre: ");
	Scanner key = new Scanner(System.in);
	x = key.nextInt();
	for (int i=0; i<10; i++)
	{
	x = x+1;
	 System.out.println(x);	
	}
	}
}
