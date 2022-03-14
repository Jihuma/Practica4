import java.util.Scanner;

// Obtener los datos de la persona
class CapturaDatos {
    public static String dato(String str){
        Scanner sn = new Scanner(System.in);
        System.out.print("Ingresar "+ str + ": ");
        return (sn.nextLine());
    }

}