/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejA;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author elisabet
 */
public class Morra {

    private static Random random = new Random();

    public static void main(String[] args) {

        String peticionJugar = "¿Quieres jugar?";
        String reglasJuego = """
                             Ahora te voy a pedir dos número.
                             El primero número -> es el que has elegido tu
                             El segundo número -> el total que crees que va a salir sumando tu número y el mio
                             Que gane el mejor !!!
                             """;

        final String NUMERO_JUGADOR = "¿Que número has elegido?";
        final String NUMERO_ADIVINA_JUGADOR = "¿Que número crees que va a salir?";
        final String TEXTO_PENSAR = "Ahora me toca a mi, dejame que piense...";
        final String TEXTO_NOMBRE_JUGADOR = "¿Cual es tu nombre?";
        final int DEDOS_MIN = 1;
        final int DEDOS_MAX = 5;
        final int DEDOS_MAX_TOTAL = DEDOS_MAX * 2;
        final int PUNTUACION_FINAL_MIN = 5;
        final int PUNTUACION_FINAL_MAX = 21;

        int jugar = 0;
        int numJugador = 0;
        int numAdivina = 0;
        int numMaquina = 0;
        int numAdivinaMaquina = 0;
        int puntuacionJugador = 0;
        int puntuacionMaquina = 0;
        int ronda = 0;

        String ganadorRonda = "";
        String nombreHumano = "";
        String jaque = "";
        String ganadorFinal = "ninguno";

        String textoEstadisticas = """
                                  ESTADISTICAS
                                  ----------------------------
                                  Puntuacion Humano %d
                                  Puntuacion Máquina %d
                                  Rondas Jugadas: %d
                                   
                                  Dedos que ha sacado %s %d y piensa que salrá %d
                                  Dedos que ha sacado máquina %d y piensa que saldrá %d
                                  
                                  """.formatted(puntuacionJugador, puntuacionMaquina, ronda, nombreHumano,
                numJugador, numAdivina, numMaquina, numAdivinaMaquina);

        do {
            // se pregunta si se quiere jugar todas las veces 
            jugar = mensajeConfirmacion(peticionJugar);

            // solo si quieres jugar 
            if (jugar == JOptionPane.YES_OPTION) {
                // solo en la primera ronda
                if (ronda == 0) {
                    // se muestra el mensaje de las reglas
                    mostrarMensaje(reglasJuego);
                    // pedir el nombre al jugador humano
                    nombreHumano = solicitarPalabra(TEXTO_NOMBRE_JUGADOR);
                }
                // se solicita el número que quiere el jugador humano
                numJugador = solicitarNumero(NUMERO_JUGADOR, DEDOS_MIN, DEDOS_MAX);
                // se obtiene el número que ha sacado la maquina
                numMaquina = numRandom(DEDOS_MIN, DEDOS_MAX);
                // se solicita el número que cree que va a salir
                numAdivina = solicitarNumero(NUMERO_ADIVINA_JUGADOR, DEDOS_MIN, DEDOS_MAX_TOTAL);
                // frase para dar ambiente
                mostrarMensaje(TEXTO_PENSAR);
                // se obtiene un número random que como mínimo tendrá el número que ha sacado la maquina
                numAdivinaMaquina = numRandom((numMaquina+1), (DEDOS_MAX * 2));
                // se calcula el ganador de la ronda 
                ganadorRonda = ganadorRonda(numJugador, numMaquina, numAdivina, numAdivinaMaquina);
                // se añade la pubtacion de ronda
                if (ganadorRonda.equalsIgnoreCase("persona")) {
                    puntuacionJugador += 1;
                } else if (ganadorRonda.equalsIgnoreCase("maquina")) {
                    puntuacionMaquina += 1;
                }
                // se comprueba si alguno ha llegado a la puntación mínima o máxima
                jaque = quienJaque(puntuacionJugador, puntuacionMaquina, PUNTUACION_FINAL_MIN, PUNTUACION_FINAL_MAX);
                // se calcula el ganador final si lo hay
                ganadorFinal = quienGana(jaque, puntuacionMaquina, puntuacionJugador, PUNTUACION_FINAL_MAX);
                // se muestran las estadisticas
                mostrarMensaje("""
                                  ESTADISTICAS
                                  ----------------------------
                                  Puntuacion %s %d
                                  Puntuacion Máquina %d 
                                  Rondas Jugadas: %d
                                   
                                  Dedos que ha sacado %s %d y piensa que salrá %d
                                  Dedos que ha sacado máquina %d y piensa que saldrá %d
                                  
                                  """.formatted(nombreHumano, puntuacionJugador, puntuacionMaquina, ronda, nombreHumano,
                        numJugador, numAdivina, numMaquina, numAdivinaMaquina));

                // se muestra quién ha ganado
                mostrarMensaje(mensajeFinal(ganadorFinal, nombreHumano));
                ronda++;
            }

        } while (jugar != JOptionPane.NO_OPTION);

    }
    // calcula un numero Random entre enteros
    private static int numRandom(int inicio, int fin) {
        fin += 1;
        return random.nextInt(inicio, fin);
    }
    // muestra un mensaje
    private static void mostrarMensaje(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
    // muestra una confirmacion
    private static int mensajeConfirmacion(String text) {
        return JOptionPane.showConfirmDialog(null, text);
    }
    // solicita un numero entre un rango, 
    //text=texto que se desea usar para pedir el numero
    //min= numero minimo de rango
    //max= numero maximo de rango
    private static int solicitarNumero(String text, int min, int max) {
        int respuesta = -1;

        final String MENSAJE_ERROR_DATO = "El dato es incorrecto, debe ser un número entero";

        do {
            try {
                respuesta = Integer.parseInt(JOptionPane.showInputDialog(text));
                if (!estaEnRango(respuesta, min, max)) {
                    String mensaje_error_rango = """
                                   Estamos jugando al juego morra, y aun que yo no tengo dedos,
                                   me gustaría simular que si, así que el mínimo es %d y el máximo %d
                                   así me sentiré más humano :D
                                   """.formatted(min, max);
                    mostrarMensaje(mensaje_error_rango);

                }
            } catch (Exception e) {
                mostrarMensaje(MENSAJE_ERROR_DATO);
            }

        } while (!estaEnRango(respuesta, min, max));
        return respuesta;
    }
    
    // se comprueba si un numero esta en rango
    private static boolean estaEnRango(int num, int min, int max) {
        return (num >= min && num <= max);
    }

    // se comprubea si alguien ha ganado
    private static String quienGana(String jaque, int puntuacionMaquina, int puntacionHumano, int PUNTUACION_FINAL_MAX) {
        String ganadorFinal = "";
        if (!(jaque.equalsIgnoreCase("nadie"))
                && ((puntacionHumano >= (puntuacionMaquina + 2) || (puntuacionMaquina >= (puntacionHumano + 2))))) {
            ganadorFinal = jaque;
        } else if (puntuacionMaquina == PUNTUACION_FINAL_MAX || puntacionHumano == PUNTUACION_FINAL_MAX) {
            ganadorFinal = "nadie";
        } else {
            ganadorFinal = "";
        }

        return ganadorFinal;
    }
    
    // se determina el ganador de la ronda
    private static String ganadorRonda(int numJugador, int numMaquina, int numAdivina, int numAdivinaMaquina) {
        String ganador = "";
        if (numAdivina == (numJugador + numMaquina)) {
            ganador = "persona";
        } else if (numAdivinaMaquina == (numJugador + numMaquina)) {
            ganador = "maquina";
        } else {
            ganador = "ninguno";
        }
        return ganador;
    }
    
    // se determina si alguno ha llegado a 5 puntos o 21 
    private static String quienJaque(int puntuacionHumano, int puntiacionMaquina, int PUNTUACION_FINAL_MIN, int PUNTUACION_FINAL_MAX) {
        String jaque = "";
        if (puntuacionHumano == PUNTUACION_FINAL_MIN || puntuacionHumano == PUNTUACION_FINAL_MAX) {
            jaque = "humano";
        } else if (puntiacionMaquina == PUNTUACION_FINAL_MIN || puntuacionHumano == PUNTUACION_FINAL_MAX) {
            jaque = "maquina";
        } else {
            jaque = "nadie";
        }
        return jaque;
    }
    
    // mensaje final de partida
    private static String mensajeFinal(String ganadorFinal, String nombreHumano) {
        String mensajeGanador = switch (ganadorFinal) {
            case "persona" ->
                """
                Enorahueba %s me has ganado !!!
                """.formatted(nombreHumano);
            case "maquina" ->
                "He ganado yo !!!";
            case "nadie" ->
                "No ha ganado nadie, deberiamos jugar otra";
            default ->
                "Sigamos jugando";
        };

        return mensajeGanador;

    }
    // se solicita el nombre
    private static String solicitarPalabra(String text) {
        String mensaje = (text.isBlank()) ? "Dame una palabra" : text;
        return JOptionPane.showInputDialog(mensaje);
    }



}
