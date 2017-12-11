import java.util.Scanner;

public class Zorglub {
	public static void main(String[] args)
	{
		int age;
		String genre;
		String reponse;
		Scanner key = new Scanner(System.in);
		do {
		System.out.println("Entrez votre age : ");
		age = key.nextInt();
		System.out.println("Homme ou Femme : ");
		genre = key.next();
		if (age>20 & genre.equals("Homme") || age>=18 & age<=35 & genre.equals("Femme"))
		{
			System.out.println("Vous etes imposable");
			System.out.println("Taper oui pour continuer: ");
			reponse = key.next();
		}
		else {
			System.out.println("Vous n'etes pas imposable.");
			System.out.println("Taper oui pour continuer: ");
			reponse = key.next();
		}
		}while (reponse.equals("oui"));		
	}
}
