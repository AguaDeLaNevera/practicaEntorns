
/**

This class prompts the user to input their name, email, password, and a code.
Then, it calls the check method from the validarCampos class to validate the inputs.
*/
import java.util.Scanner;

public class registroUsuario {
    static String name;
    static String email;
    static String password;
    static String code;
    static Scanner sc = new Scanner(System.in);

    // name input
    public static void nameInput() {
        System.out.println("Introduce your name: ");
        name = sc.nextLine();

    }

    // email input
    public static void emailInput() {
        System.out.println("Introduce your email: ");
        email = sc.nextLine();
    }

    // password input
    public static void passwordInput() {
        System.out.println("Introduce your password: ");
        password = sc.nextLine();
    }

    // code input
    public static void codeInput() {
        System.out.println("Introduce the code: ");
        code = sc.nextLine();
    }

    /**
     * Prompts the user to input their name, email, password, and code, and calls
     * the check method from
     * the validarCampos class to validate the inputs. If any input is invalid, it
     * prompts the user to
     * input the corresponding value again.
     */
    public static void main(String[] args) {
        validarCampos check = new validarCampos();

        while (!check.check(name, email, password, code)) {
            nameInput();
            emailInput();
            passwordInput();
            codeInput();
        }
    }
}
