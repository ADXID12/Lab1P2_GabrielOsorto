package lab1p2_gabirelosorto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class Lab1P2_GabirelOsorto {

    static Scanner sc = new Scanner(System.in);
    static Scanner lt = new Scanner(System.in);
    static ArrayList<Usuario> Usuarios = new ArrayList();

    public static void main(String[] args) throws ParseException {
        boolean seguir = true;
        while (seguir == true) {
            System.out.println("Menu");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Listar Todo");
            System.out.println("3. Listar por Dominio");
            System.out.println("4. Salir");
            System.out.print("Que desea hacer?:");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Ingrese su nombre:");
                    String nombre = lt.nextLine();
                    System.out.print("Ingrese su apellido:");
                    String apellido = lt.nextLine();
                    System.out.print("Ingrese su fecha de nacimiento(yyyy/MM/dd):");
                    String fechanacimiento = lt.nextLine();
                    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
                    Date FechadeNacimiento = sd.parse(fechanacimiento);
                    System.out.print("Ingrese su correo electronico:");
                    String correo = lt.nextLine();
                    System.out.print("Ingrese su contraseña:");
                    String contra = lt.nextLine();
                    Usuario NuevoUsuario = new Usuario(nombre, apellido, FechadeNacimiento, correo, contra);
                    Usuarios.add(NuevoUsuario);
                    System.out.println("correo agregado con exito!!");
                case 2:
                    if (Usuarios.isEmpty()) {
                        System.out.println("No hay picos que mostrar");
                    } else {
                        for (int i = 0; i < Usuarios.size(); i++) {
                            System.out.println(Usuarios.get(i));
                        }
                    }
                    System.out.println("");
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo....");
                    seguir = false;
                    break;
            }
        }
    }

}
