import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float n1,n2;

        Scanner nombre = new Scanner(System.in);
        System.out.println("Entrer un nombre:");
        n1 = nombre.nextFloat();
        System.out.println("Entrer un autre nombre:");
        n2 = nombre.nextFloat();
        if ((n1 >0 && n2 >0) || (n1 <0 && n2 <0)){
            System.out.println("Le produit est positif");
        }
        if ((n1 >0 && n2 <0) || (n1 <0 && n2 >0)){
            System.out.println("Le produit est negatif");
        }
        else {
            System.out.println("Le produit est nul");
        }
        nombre.close();



    }
}