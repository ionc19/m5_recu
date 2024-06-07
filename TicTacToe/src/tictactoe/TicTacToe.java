/*
 * Joc de Tic-Tac-Toe
 * Aquest programa implementa un simple joc de Tic-Tac-Toe on un jugador competeix contra un oponent controlat per l'ordinador.
 *
 * Autor: Ion
 */
package tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe principal del joc de Tic-Tac-Toe.
 * Conté la lògica del joc i gestiona el flux del joc.
 */
public class TicTacToe {

    /**
     * Mètode principal per iniciar el joc de Tic-Tac-Toe.
     * @param args arguments de la línia de comandes (no utilitzats)
     */
    public static void main(String[] args) {
        int[][] tauler = new int[3][3]; // Inicialització del tauler de joc de 3x3
        imprimirTauler(tauler); // Imprimeix el tauler inicial
        iniciJoc(tauler); // Inicialitza el tauler amb valors per defecte
        System.out.println("");
        System.out.println("");
        imprimirTauler(tauler); // Torna a imprimir el tauler després d'inicialitzar-lo
        while (true) {
            tirJugador(tauler); // Gestiona el torn del jugador
            imprimirTauler(tauler); // Imprimeix el tauler després del torn del jugador
            tirContrincant(tauler); // Gestiona el torn de l'ordinador
            imprimirTauler(tauler); // Imprimeix el tauler després del torn de l'ordinador
        }
    }

    /**
     * Inicialitza el tauler del joc a "-N", on N és la mida del tauler.
     * Aquest mètode marca totes les cel·les del tauler com a buides.
     * @param taulerJoc el tauler del joc
     */
    public static void iniciJoc(int[][] taulerJoc) {
        for (int i = 0; i < taulerJoc.length; i++) {
            for (int j = 0; j < taulerJoc.length; j++) {
                taulerJoc[i][j] = -3; // Marca totes les cel·les com a buides amb el valor -3
            }
        }
    }

    /**
     * Imprimeix el tauler del joc a la consola.
     * @param taulerJoc el tauler del joc
     */
    public static void imprimirTauler(int[][] taulerJoc) {
        System.out.println("  1 2 3 "); // Capçalera de les columnes
        for (int i = 0; i < taulerJoc.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < taulerJoc.length; j++) {
                System.out.print(crossOrCircle(taulerJoc[i][j]) + " "); // Converteix el valor numèric a un caràcter
            }
            System.out.print("| " + (i + 1)); // Capçalera de les files
            System.out.println("");
        }
    }

    /**
     * Converteix el valor numèric d'una cel·la a un caràcter per mostrar-lo.
     * @param i el valor de la cel·la
     * @return '_' per cel·la buida, 'O' per moviment de l'oponent, 'X' per moviment del jugador
     */
    public static char crossOrCircle(int i) {
        if (i == -3) return '_'; // Cel·la buida
        return (i == 0) ? 'O' : 'X'; // 'O' per l'oponent, 'X' per el jugador
    }

    /**
     * Converteix una posició de matriu 2D a una posició de matriu 1D.
     * @param x l'índex de la columna (1-based)
     * @param y l'índex de la fila (1-based)
     * @return l'índex de la matriu 1D
     */
    private static int bidimensionalToUnidimensional(int x, int y) {
        return (y - 1) * 3 + x; // Converteix la posició 2D a 1D
    }

    /**
     * Gestió del moviment de l'oponent seleccionant aleatòriament una cel·la buida.
     * @param taulerJoc el tauler del joc
     */
    public static void tirContrincant(int[][] taulerJoc) {
        System.out.println("");
        System.out.println("TIR CONTRINCANT");

        int random_x;
        int random_y;

        Random rand = new Random();

        do {
            random_x = rand.nextInt(3); // Genera un valor aleatori per la columna
            random_y = rand.nextInt(3); // Genera un valor aleatori per la fila
        } while (taulerJoc[random_x][random_y] != -3); // Assegura que la cel·la és buida

        taulerJoc[random_x][random_y] = 0; // 0 = 'O', moviment de l'oponent
    }

    /**
     * Gestió del moviment del jugador demanant a l'usuari que seleccioni una cel·la.
     * @param taulerJoc el tauler del joc
     */
    public static void tirJugador(int[][] taulerJoc) {
        System.out.println("");
        System.out.println("TIR JUGADOR");

        Scanner sc = new Scanner(System.in);
        System.out.print("[X] Entra la columna (1-3): ");
        int x = sc.nextInt(); // Llegeix la columna introduïda pel jugador
        System.out.print("[Y] Entra la fila (1-3): ");
        int y = sc.nextInt(); // Llegeix la fila introduïda pel jugador

        taulerJoc[y - 1][x - 1] = 1; // 1 = 'X', moviment del jugador
    }

    /**
     * Determina el guanyador del joc comprovant files, columnes i diagonals.
     * @param taulerJoc el tauler del joc
     * @return "-1" si no hi ha guanyador, "0" si guanya l'oponent, "1" si guanya el jugador
     */
    public static int determinarGuanyador(int[][] taulerJoc) {
        // TODO: Implementar el mètode per comprovar el guanyador
        throw new UnsupportedOperationException();
    }
}
