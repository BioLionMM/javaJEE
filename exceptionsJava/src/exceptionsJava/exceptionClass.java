package exceptionsJava;
import java.util.Scanner;
import java.util.ArrayList;

public class exceptionClass {
public static void main(String agrc[]) {
		java.util.Scanner input=new Scanner(System.in);
		System.out.println("Entrez un nombre ou q pour quitter:");
		String entree=input.nextLine();
		int nbre=Integer.parseInt(entree);
		ArrayList<Integer> listeNbre=new ArrayList<Integer>();
		
		while(entree!="q") {
			if(listeNbre.contains(nbre)) {
				System.out.println("Deja dans la liste.");
				continue;
			}else {
				try {
					nbre=Integer.valueOf(entree);
					listeNbre.add(nbre);
					}catch(NumberFormatException e) {
						System.out.printf("Pas un chiffre.");
					}
			System.out.println("Entrez un nombre ou q pour quitter:");
			entree=input.nextLine();
			}
		
			System.out.printf("Vous avez saisi %d nombres.\n", listeNbre.size());
			System.out.println(listeNbre);
		
		}

	}
}
