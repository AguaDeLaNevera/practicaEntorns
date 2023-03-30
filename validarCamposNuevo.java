import java.util.Random;

/**
 * Clase que comprueba si los campos introducidos por el usuario son válidos y
 * genera un código de seguridad aleatorio de 8 caracteres para su posterior
 * comprobación.
 */
public class validarCamposNuevo {

    String[] domains;
    String letras;
    String numeros;
    String simbolos;

    /**
     * Método que comprueba si los campos introducidos son válidos y el código de
     * seguridad generado coincide con el introducido por el usuario.
     * 
     * @param name     Nombre del usuario.
     * @param email    Dirección de correo electrónico del usuario.
     * @param password Contraseña elegida por el usuario.
     * @param code     Código de seguridad introducido por el usuario.
     * @return True si todos los campos son válidos y los códigos coinciden, False
     *         en caso contrario.
     */

    public validarCamposNuevo() {
        this.domains = new String[] { "paucasesnovescifp", "yahoo", "gmail", "hotmail" };
        this.letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.numeros = "0123456789";
        this.simbolos = "!@#$%^&*()_+-={}[]\\|:;\"'<>,.?/";
    }

    // name check
    public boolean nameCheck(String name, String[] names) {
        // Comprobación de que el nombre no está repetido
        for (int i = 0; i < names.length; i++) {
            if (name == names[i]) {
                System.out.println("name already exists");
                return false;
            }
        }

        // Comprobación de que el nombre tiene una longitud válida
        if (name.length() < 3 || name.length() > 16) {
            System.out.println("name must be between 3 and 16 characters");
            return false;
        }
        return true;
    }

    /**
     * @param email
     * @return boolean
     */
    // email check
    public boolean emailCheck(String email) {
        // Comprobación de que el email es válido
        boolean containsDomain = false;
        boolean endsWith = false;
        for (String domain : domains) {
            if (email.contains(domain)) {
                containsDomain = true;
                break;
            }
        }
        if (email.endsWith(".com") || email.endsWith(".cat")) {
            endsWith = true;
        }
        if (containsDomain == false || endsWith == false) {
            System.out.println("email must be correct");
            return false;
        }
        return true;
    }

    /**
     * @param password
     * @return boolean
     */
    // password check
    public boolean passwordCheck(String password) {
        // Comprueba que la contraseña tiene 8 caracteres
        if (password.length() != 8) {
            System.out.println("Password must be 8 characters long");
            return false;
        }

        // Comprueba que la contraseña empieza por una letra mayúscula
        char firstChar = password.charAt(0);
        if (!Character.isUpperCase(firstChar)) {
            System.out.println("Password must start with a capital letter");
            return false;
        }

        // Comprueba que la contraseña contiene un carácter especial
        boolean containsSpecialChar = false;
        String specialChars = "@-#_";
        for (int i = 0; i < specialChars.length(); i++) {
            char c = specialChars.charAt(i);
            if (password.indexOf(c) != -1) {
                containsSpecialChar = true;
                break;
            }
        }
        if (!containsSpecialChar) {
            System.out.println("Password must contain a special character");
            return false;
        }
        char lastChar = password.charAt(password.length() - 1);
        char secondLastChar = password.charAt(password.length() - 2);
        if (!Character.isDigit(lastChar) || !Character.isDigit(secondLastChar)) {
            System.out.println("Password must end with 2 integers");
            return false;
        }
        return true;
    }

    public String codeGenerator() {
        String caracteres = letras + numeros + simbolos;
        Random rand = new Random();
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            codigo.append(caracteres.charAt(rand.nextInt(caracteres.length())));
        }
        String codigo2 = codigo.toString();
        return codigo2;
    }

    public boolean codeCheck(String code1, String code2) {
        if (code1 != code2) {
            System.out.println("Codes must be equal");
            return false;
        }
        return true;
    }
}
