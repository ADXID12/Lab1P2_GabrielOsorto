package lab1p2_gabirelosorto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    Case1();
                    break;
                case 2:
                    Case2();
                    break;
                case 3:
                    Case3();
                    break;
                case 4:
                    System.out.println("Saliendo....");
                    seguir = false;
                    break;
            }
        }
    }//Main

    public static boolean CorreoValid(String correoElectronico) {
        String email = correoElectronico;
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }//Metodo Regex correo

    public static boolean ContraValid(String contraseña) {
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contraseña);
        return matcher.matches();
    }//Metodo Regex contra

    public static void Case1() throws ParseException {
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

        if (CorreoValid(correo)) {
            boolean valido1 = false;
            while (valido1 == false) {
                String[] splitear1 = correo.split("@");
                String dominioReal = splitear1[1];
                if ((dominioReal.equalsIgnoreCase("gmail.com")) || (dominioReal.equalsIgnoreCase("Outlook.com")) || (dominioReal.equalsIgnoreCase("Yahoo.com")) || (dominioReal.equalsIgnoreCase("iCloud.com")) || (dominioReal.equalsIgnoreCase("ProtonMail.com")) || (dominioReal.equalsIgnoreCase("FastMail.com"))) {
                    valido1 = true;
                } else {
                    System.out.println("Dominios validos== Gmail, Outlook, Yahoo, iCloud, ProtonMail y FastMail.");
                    System.out.print("Dominio no existente, ingrese un correo con un dominio valido:");
                    correo = lt.nextLine();
                }

            }

            System.out.print("Ingrese su contraseña:");
            String contra = lt.nextLine();
            if (ContraValid(contra)) {
                System.out.println("Contraseña Validada Correctamente!!");
            } else {
                System.out.println("Contraseña Invalida");
            }

            Usuario NuevoUsuario = new Usuario(nombre, apellido, FechadeNacimiento, correo, contra);
            Usuarios.add(NuevoUsuario);
            System.out.println("correo agregado con exito!!");
        } else {
            System.out.println("correo invalido");
        }
    }//Metodo Case 1(Agregar Usuario)

    public static void Case2() {
        if (Usuarios.isEmpty()) {
            System.out.println("No hay correos que mostrar");
        } else {
            System.out.println("Lista Users");
            for (int i = 0; i < Usuarios.size(); i++) {
                Usuario users = Usuarios.get(i);
                System.out.print(users);
                PrintFecha(users.getFechadeNacimiento());
            }
        }
        System.out.println("");
    }//Imprimir Lista de usuarios

    public static void PrintFecha(Date fecha) {
        System.out.println((fecha.getYear() + 1900) + "/" + (fecha.getMonth() + 1) + "/" + fecha.getDate() + "]");
    }//Metodo imprimir fecha

    public static void Case3() {//Imprimir lista segun el dominio
        System.out.println("Listar segun el Dominio");
        System.out.print("Ingrese el dominio que desea buscar(recuerde ingresarlo con el .com):");
        String dominio2 = lt.nextLine();
        if ((dominio2.equalsIgnoreCase("gmail.com")) || (dominio2.equalsIgnoreCase("Outlook.com")) || (dominio2.equalsIgnoreCase("Yahoo.com")) || (dominio2.equalsIgnoreCase("iCloud.com")) || (dominio2.equalsIgnoreCase("ProtonMail.com")) || (dominio2.equalsIgnoreCase("FastMail.com"))) {
            System.out.println("Usuarios con dominio " + dominio2);
            boolean encontrado = false;
            for (Usuario usuario : Usuarios) {
                if (usuario.getCorreo().toLowerCase().endsWith("@" + dominio2.toLowerCase())) {
                    System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
                    PrintFecha(usuario.getFechadeNacimiento());
                    encontrado = true;
                }
            }

            if (encontrado==false) {
                System.out.println("No hay usuarios con el dominio especificado.");
            }
        } else {
            System.out.println("El dominio no es válido");
        }
    }
}
