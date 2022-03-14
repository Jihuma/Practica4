import java.util.*;

public class Mexicano {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("---- Menu ----");
            System.out.println("1. Calcular CURP.");
            System.out.println("2. Calcular RFC.");
            System.out.println("3. Calcular CURP y RFC.");
            System.out.println("4. Salir.");
            System.out.println("--------------");

            try {
                System.out.println("Opcion: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.println("---- Calcular CURP ----\n");

                        datosPersona info1 = new datosPersona(
                                CapturaDatos.dato("nombre"),
                                CapturaDatos.dato("primer apellido"),
                                CapturaDatos.dato("segundo apellido"),
                                CapturaDatos.dato("fecha de nacimiento (AAAA/MM/DD)"),
                                CapturaDatos.dato("género (hombre o mujer)"),
                                CapturaDatos.dato("estado donde nacio")
                        );

                        info1.setCurp();
                        System.out.println("\nCURP: " + info1.getCurp());
                    }
                    case 2 -> {
                        System.out.println("---- Calcular RFC ----\n");
                        datosPersona info2 = new datosPersona(
                                CapturaDatos.dato("nombre"),
                                CapturaDatos.dato("primer apellido"),
                                CapturaDatos.dato("segundo apellido"),
                                CapturaDatos.dato("fecha de nacimiento (AAAA/MM/DD)"),
                                CapturaDatos.dato("género (hombre o mujer)"),
                                CapturaDatos.dato("estado donde nacio")
                        );
                        info2.setRfc();
                        System.out.println("\nRFC: " + info2.getRfc());
                    }
                    case 3 -> {
                        System.out.println("---- Calcular CURP y RFC ----\n");
                        datosPersona info3 = new datosPersona(
                                CapturaDatos.dato("nombre"),
                                CapturaDatos.dato("primer apellido"),
                                CapturaDatos.dato("segundo apellido"),
                                CapturaDatos.dato("fecha de nacimiento (AAAA/MM/DD)"),
                                CapturaDatos.dato("género (hombre o mujer)"),
                                CapturaDatos.dato("estado donde nacio")
                        );

                        info3.setCurp();
                        info3.setRfc();

                        System.out.println("\nCURP: " + info3.getCurp());
                        System.out.println("\nRFC: " + info3.getRfc());
                    }
                    case 4 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 3");

                }

            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
        }
    }

}

static class datosPersona {
    String curp;
    String rfc;
    String nombre;
    String apellido1;
    String apellido2;
    String fecha;
    String genero;
    String estado;
    public char letra;
    Random rand = new Random();

    public datosPersona(String name, String ap1, String ap2, String date, String gen, String est) {
        nombre = name.toUpperCase();
        apellido1 = ap1.toUpperCase();
        apellido2 = ap2.toUpperCase();
        this.fecha = date;
        genero = gen.toUpperCase();
        estado = est.toUpperCase();
    }


    //Obtener el CURP
    public void setCurp() {
        curp = Character.toString(apellido1.charAt(0));
        for (int i = apellido1.length() - 1; i >= 0; i--) {
            if (apellido1.charAt(i) == 'A' || apellido1.charAt(i) == 'E' || apellido1.charAt(i) == 'I'
                    || apellido1.charAt(i) == 'O' || apellido1.charAt(i) == 'U') {
                letra = apellido1.charAt(i);
            }
        }
        curp += letra;
        curp += Character.toString(apellido2.charAt(0));
        curp += Character.toString(nombre.charAt(0));
        for (int i = 2; i < fecha.length(); i++) {
            if (fecha.charAt(i) != '/') {
                curp += Character.toString(fecha.charAt(i));
            }
        }
        curp += Character.toString(genero.charAt(0));
        curp += Character.toString(estado.charAt(0));
        for (int i = 0; i < estado.length(); i++) {
            if (estado.charAt(i) == ' ') {
                curp += Character.toString(estado.charAt(i + 1));
            }
        }
        for (int i = apellido1.length() - 1; i >= 1; i--) {
            if (apellido1.charAt(i) != 'A' && apellido1.charAt(i) != 'E' && apellido1.charAt(i) != 'I'
                    && apellido1.charAt(i) != 'O' && apellido1.charAt(i) != 'U') {
                letra = apellido1.charAt(i);
            }
        }
        curp += letra;
        for (int i = apellido2.length() - 1; i >= 1; i--) {
            if (apellido2.charAt(i) != 'A' && apellido2.charAt(i) != 'E' && apellido2.charAt(i) != 'I'
                    && apellido2.charAt(i) != 'O' && apellido2.charAt(i) != 'U') {
                letra = apellido2.charAt(i);
            }
        }
        curp += letra;
        for (int i = nombre.length() - 1; i >= 1; i--) {
            if (nombre.charAt(i) != 'A' && nombre.charAt(i) != 'E' && nombre.charAt(i) != 'I'
                    && nombre.charAt(i) != 'O' && nombre.charAt(i) != 'U') {
                letra = nombre.charAt(i);
            }
        }
        curp += letra;
        curp += Character.toString((char) (rand.nextInt(26) + 'a')).toUpperCase();
        curp += Character.toString((char) (rand.nextInt(26) + 'a')).toUpperCase();
    }

    public String getCurp() {
        return curp;
    }

    //Obtener el RFC
    public void setRfc() {
        rfc = Character.toString(apellido1.charAt(0));
        rfc += Character.toString(apellido1.charAt(1));
        rfc += Character.toString(apellido2.charAt(0));
        rfc += Character.toString(nombre.charAt(0));
        for (int i = 2; i < fecha.length(); i++) {
            if (fecha.charAt(i) != '/') {
                rfc += Character.toString(fecha.charAt(i));
            }
        }
        rfc += Character.toString((char) (rand.nextInt(26) + 'a')).toUpperCase();
        rfc += Character.toString((char) (rand.nextInt(26) + 'a')).toUpperCase();
        rfc += Character.toString((char) (rand.nextInt(26) + 'a')).toUpperCase();
    }

    public String getRfc() {
        return rfc;
    }
}
}

