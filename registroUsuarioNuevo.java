
/**

This class prompts the user to input their name, email, password, and a code.
Then, it calls the check method from the validarCampos class to validate the inputs.
*/
import java.util.Scanner;

public class registroUsuarioNuevo {
    static String[] names = { "Ricardo", "Ignasi", "Miquel", "Jaume", "Pere", "Joan", "Pedro", "Juan", "Antonio",
            "Albacete" };
    static String nombreDeUsuario = "";
    static String email = "";
    static String password = "";
    static String code = "";
    static Scanner sc = new Scanner(System.in);
    static validarCamposNuevo vc = new validarCamposNuevo();

    // name input
    public static void nameInput() {
        while (!vc.nameCheck(nombreDeUsuario, names)) {
            System.out.println("Introduce your name: ");
            nombreDeUsuario = sc.nextLine();
        }
    }

    // email input
    public static void emailInput() {
        while (!vc.emailCheck(email)) {
            System.out.println("Introduce your email: ");
            email = sc.nextLine();
        }
    }

    // password input
    public static void passwordInput() {
        while (!vc.passwordCheck(password)) {
            System.out.println("Introduce your password: ");
            password = sc.nextLine();
        }
    }

    // code input
    public static void codeInput() {
        String codeGenerated = vc.codeGenerator();
        while (!vc.codeCheck(code, codeGenerated)) {
            System.out.println("Introduce the code: ");
            code = sc.nextLine();
        }
    }

    /**
     * Prompts the user to input their name, email, password, and code, and calls
     * the check method from
     * the validarCampos class to validate the inputs. If any input is invalid, it
     * prompts the user to
     * input the corresponding value again.
     */
    public static void init() {
        // inicialitzem els mètodes
        nameInput();
        emailInput();
        passwordInput();
        codeInput();
    }

    public static void main(String[] args) {
        // Inicialització
        init();
    }
}