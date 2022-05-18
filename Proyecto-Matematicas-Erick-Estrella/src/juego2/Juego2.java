
package juego2;

import java.util.Scanner;

public class Juego2 {
/*
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int[] nivel = new int[5];
        int contador = 0;
        do{
            System.out.println("Nivel: "+contador);
        nivel[0] = 10;
        nivel[1] = 100;
        nivel[2] = 1000;
        nivel[3] = 10000;
        nivel[4] = 100000;
        int num1;
        int num2;
        int suma;
        boolean mayor1;
        do{
            mayor1 = false;
        num1 = (int)(Math.random() * nivel[contador]);
        num2 = (int)(Math.random() * nivel[contador]);
        if(contador > 0){
            if(num1 < nivel[contador -1] || num2 < nivel[contador-1]){
                mayor1 = true;
            }
        }
        suma = num1 + num2;
        }while(num1 == 0 || num2 == 0 || suma >= nivel[contador] || mayor1);
        System.out.println(num1+"+"+num2+"= ");
            
        //vamos a crear alternativas
        int[] alternativas = new int[4];
        boolean encontrar;
        boolean mayor2;
        for (int i = 0; i < 4; i++) {
            do{
                encontrar = false;
            do{
                mayor2 = false;
            alternativas[i] = (int)(Math.random() * nivel[contador]);
            if(contador > 0){
                if(alternativas[i] < nivel[contador - 1]){
                    mayor2 = true;
                }
            }
            //tambien no debemos olvidar que las alternativas que estamos generando no sean iguales a la respuesta
            }while(alternativas[i] == 0 || alternativas[i] >= nivel[contador] || mayor2 || alternativas[i] == suma);
            
            
            //las alternativas no te pueden repetir 
            for (int j = 0; j < 4; j++) {
                if(alternativas[i] == alternativas[j]){
                    if(i != j){
                        //entonces se encontro una alternativa repetida
                    encontrar = true;
                    }
                }
            }
            }while(encontrar);
        }
        
        //ahora vamos a juntas las alternativas y la respuesta
        String[] todo = new String[5];
        int ale = (int)(Math.random() * 4);
        int a = 0;
        for (int i = 0; i < 5; i++) {
            if(ale == i){
                todo[i] = String.valueOf(suma);
            }else{
                todo[i] = String.valueOf(alternativas[a]);
                a++;
            }
        }
        
        //vamos a imprimir todas las alterntivas y la respuesta
        int asci = 65;
        for (int i = 0; i < 5; i++) {
            System.out.println((char)asci+")"+todo[i]);
            asci++;
        }
        
        
            System.out.print("Ingrese la respuesta: ");
            int ingresado = entrada.nextInt();
            if(ingresado == suma){
                System.out.println("Respuesta Correcta");
                System.out.println("Pasaste al siguiente nivel :)");
                contador++;
                if(contador == 5){
                    System.out.println("Felicitaciones llegaste al maximo nivel");
                }
            }else{
                System.out.println("La respuesta es incorrecta :(");
            }
        }while(contador != 5);
        
    }
    */
}
