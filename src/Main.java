
import org.jpl7.*;

public class Main {
    public static void main(String[] args) {
        Query q1 = new Query("consult", new Term[]{new Atom("src/Progenitor.pl")});
        System.out.println("consulta: "+(q1.hasSolution() ? "succeded" : "failed"));



    }
}
