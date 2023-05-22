package listaencadeada2;

/**
 *
 * @author bruno
 */
public class ListaEncadeada2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaComEncadeamento<Integer> a1 = new ListaComEncadeamento();
        a1.add(1);
        a1.add(2);
        System.out.println(a1.toString());
        a1.add(0, 2);
        System.out.println(a1.toString());
        a1.add(1, 4);
        System.out.println(a1.toString());
        a1.add(5, 5);
        System.out.println(a1.toString());
        System.out.println(a1.size());
        System.out.println(a1.isEmpty());
        System.out.println(a1.removeFirst(5));
        System.out.println(a1.toString());
        System.out.println(a1.get(4));
        System.out.println(a1.contains(2));
        System.out.println(a1.lastIndexOf(2));
        System.out.println(a1.toString());
       
    }

}
