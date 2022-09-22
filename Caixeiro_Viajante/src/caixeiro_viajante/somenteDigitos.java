package caixeiro_viajante;
/**
 * @author Maria Sanchez
 */
public class somenteDigitos {
    public Integer somenteDigitos(String str) {
        StringBuilder digitos = new StringBuilder();
        char[] letras  = str.toCharArray();
        for (char letra : letras) {
            if(Character.isDigit(letra)) {
                digitos.append( letra );
            }
        }

        return Integer.parseInt( digitos.toString() );
    }
}
