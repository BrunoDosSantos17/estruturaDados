
package lista;

import java.util.Scanner;

public class Util {
    
    static Scanner bru = new Scanner(System.in);
    static int x = 0;
    public static int pedeInt(String mensagem){
        System.out.println(mensagem);
         int nu = 0;
        try{
        nu = bru.nextInt();
        }catch(Exception e){
            System.out.println("Isso não é um número pertencente aos inteiros");
        }
        
        return nu;
    }
    public static Numero pedeNumero(){
        Numero n = new Numero();
        x += 1;
        n.setId(x);
        do{
            n.setNumero(pedeInt("Escolha um número de 1 a 100"));
        }while(n.getNumero()< 1 || n.getNumero() > 100);
        
        
        return n;
    }
    
}
