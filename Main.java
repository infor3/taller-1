package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 27/02/2016.
 */
public class Main {
    public static boolean esPrimo(double numero){
        for(int i = 2; i <= Math.sqrt(numero); i++){
            if(numero % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        double limite = 1000000;
        long time_start, time_end;

        int guardar = 0;
        File fileIn = new File("dataset.in");
        File fileOut = new File("Salida1.out");
        StringBuilder sb = new StringBuilder();

//        List<String> result = FileManipulator.fileReader(fileIn);
//        time_start = System.currentTimeMillis();
//        for (String s: result) {
//            s = s.substring(0, s.length()-1);
//            if(esPrimo(Integer.parseInt(s))){
//                sb.append(s);
//                sb.append(",\n");
//            }
//        }
//        time_end = System.currentTimeMillis();
//        FileManipulator.fileWriter(fileOut, sb.toString());
//        long timeSpan = time_end - time_start;
//        System.out.println("Duración del algoritmo " + timeSpan);



        time_start = System.currentTimeMillis();
        for (int i = 1; i < limite; i+=2) {
            if(esPrimo(i)) {
                guardar++;
                sb.append(i);
                sb.append(",\n");
            }
            if(guardar % 39249 == 0) {
                FileManipulator.fileWriter(fileOut, sb.toString());
                sb = new StringBuilder();
            }
        }
        System.out.println(guardar);
        time_end = System.currentTimeMillis();
        long timeSpan = time_end - time_start;
        System.out.println("Duración del algoritmo " + timeSpan + "ms");
    }
}
