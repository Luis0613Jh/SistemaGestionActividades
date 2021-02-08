package controlador.utilidades;

public class VerificaCedula {

    public boolean verificarNumeroCedula(String cedula) {

        char[] cadenaNumeroCedula = cedula.toCharArray();
        int[] arrayNumeroCedula = asignarNumeroCedula(cadenaNumeroCedula);
        int numVerificador = asignarNumeroVerificador(cadenaNumeroCedula);
        return verificarNumeroCedulaConArray(arrayNumeroCedula, numVerificador);
    }

    private int[] asignarNumeroCedula(char[] cadenaNumeroCedula) {
        int[] arrayNumeroCedula = new int [cadenaNumeroCedula.length - 1];
        
        for (int i = 0; i < arrayNumeroCedula.length; i++) {
            arrayNumeroCedula[i] = Character.getNumericValue(cadenaNumeroCedula[i]);
        }
        return arrayNumeroCedula;
    }

    private int asignarNumeroVerificador(char[] cadenaNumeroCedula) {
        return Character.getNumericValue(cadenaNumeroCedula[cadenaNumeroCedula.length - 1]);
    }

    private boolean verificarNumeroCedulaConArray(int[] arrayNumeroCedula, int numVerificador) {
        int[] arrayResultante = new int[arrayNumeroCedula.length];
        arrayResultante = generarArrayResultante(arrayNumeroCedula);
        int sumaArrayResultante = sumarArrayResultante(arrayResultante);
        int decenaSiguiente = generarDecenaSiguiente(sumaArrayResultante);
        
        if ((decenaSiguiente - sumaArrayResultante) == numVerificador) {
            return true;
        }
        return false;
    }

    private int[] generarArrayResultante(int[] arrayNumeroCedula) {
        int[] arrayParaMultiplicar = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] arrayResultante = new int[arrayNumeroCedula.length];
        
        for (int i = 0; i < arrayResultante.length; i++) {
            arrayResultante[i] = (arrayNumeroCedula[i] * arrayParaMultiplicar[i]);
            if (arrayResultante[i] >= 10) {
                arrayResultante[i] -= 9;
            }
        }
        return arrayResultante;
    }

    private int sumarArrayResultante(int[] arrayResultante) {
        int suma = 0;
        
        for (int i = 0; i < arrayResultante.length; i++) {
            suma += arrayResultante[i];
        }
        return suma;
    }

    private int generarDecenaSiguiente(int suma) {
        int decena = suma;
        
        while (!(decena % 10 == 0)) {
            decena++;
        }
        return decena;
    }

}
