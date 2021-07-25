
import org.jpl7.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Query q1 = new Query("consult", new Term[]{new Atom("src/Progenitor.pl")});
        String[] nombre = {"juan", "luis","maria", "carlos", "laura"};

        if(q1.hasSolution()){
            int result;
            do {
                result = menu();
                if(result < 1 || result > 6){
                    System.out.println("Seleccione en el rango!");
                }
                else{
                    if(result == 6){
                        System.out.println("Adios :D");
                        break;
                    }
                    else{
                        hijos(nombre[result-1]);
                        padres(nombre[result-1]);
                    }
                }

            }while(result < 1 || result > 6);

        }
    }
    public static int menu(){
        System.out.println("Seleccione un personaje: \n" +
                "1.Juan\n" +
                "2.Luis\n" +
                "3.Maria\n" +
                "4.Carlos\n" +
                "5.Laura\n" +
                "6.Salir\n");
        Scanner input = new Scanner(System.in);

        return input.nextInt();

    }
    public static void hijos(String persona){
        String consulta = "progenitor(" + persona +",Y)";
        Query hijos = new Query(consulta);
        if(hijos.hasSolution()){
            System.out.println("Tiene como hijo: ");
            while (hijos.hasMoreSolutions()){
                Map aux = hijos.nextSolution();
                System.out.println(aux.get("Y"));
            }
        }else{
            System.out.println("No tiene hijos");
        }
    }
    public static void padres(String persona){
        String consulta = "progenitor(Y, "+ persona + ")";
        Query padres = new Query(consulta);
        if(padres.hasSolution()){
            System.out.println("\nTiene como Padres: ");
            while (padres.hasMoreSolutions()){
                Map aux = padres.nextSolution();
                System.out.println(aux.get("Y"));
            }
        }else{
            System.out.println("\nNo tiene padres");
        }

    }

}
