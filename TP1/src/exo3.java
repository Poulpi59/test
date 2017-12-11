import java.util.Scanner;

public class exo3 {
	public static void main(String[] args)
	{
		final int T1 = 10;
		final int T2 = 30;
		final double Prix1 = 0.10;
		final double Prix2 = 0.09;
		final double Prix3 = 0.08;
		int nbCopies;
		double facture;
		Scanner key = new Scanner(System.in);
		System.out.println("Veuillez entrer le nombre de photocopies: ");
		nbCopies = key.nextInt();
		if (nbCopies <= T1) {
			facture = nbCopies*Prix1;
		}
		else if (nbCopies <= T2) {
			facture = (T1*Prix1)+(nbCopies-T1)*Prix2;
		}
		else {
			facture=(T1*Prix1)+(T2-T1)*Prix2+(nbCopies-T2)*Prix3;
			}
		System.out.println(facture);
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
