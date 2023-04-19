
package árbol.de.expresiones;

import java.util.Scanner;



class Nodo {
    String valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(String valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ÁrbolDeExpresiones {
    public Nodo raiz;

    
    
    public ÁrbolDeExpresiones() {
        raiz = null;
    }

    
    
    public void agregarNodo(String valor) {
        raiz = agregarNodoRec(raiz, valor);
    }

    
    
    private Nodo agregarNodoRec(Nodo nodo, String valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }

        if (esOperador(valor)) {
            nodo.derecho = agregarNodoRec(nodo.derecho, valor);
        } 
        else {
            nodo.izquierdo = agregarNodoRec(nodo.izquierdo, valor);
        }

        return nodo;
    }

    
    
    private boolean esOperador(String valor) {
        return valor.equals("+") || valor.equals("-") || valor.equals("*") || valor.equals("/");
    }

    
    
    public void imprimirArbol() {
        imprimirArbolRec(raiz, 0);
    }

    
    
    private void imprimirArbolRec(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirArbolRec(nodo.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            System.out.println(nodo.valor);
            imprimirArbolRec(nodo.izquierdo, nivel + 1);
        }
    }
    
    
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Introduce una expresion aritmetica: ");
    String expresion = sc.nextLine();

    String[] elementos = expresion.split(" ");
    ÁrbolDeExpresiones arbol = new ÁrbolDeExpresiones();
    for (String elemento : elementos) {
        arbol.agregarNodo(elemento);
    }

    System.out.println("Arbol de expresiones:");
    arbol.imprimirArbol();
    }
}
