package Battleship;
import java.util.Scanner;
public class Ejecutar_Juego {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
         
        String nombre="",contraseña="";
        int puntos=0;
        database crear=new database(nombre,contraseña,puntos);
        boolean Menu_Inicio=false,Bcrear=false;
        int Opcion_Menu=0;
        do{
            crear.imprimirMenuIn();
            Opcion_Menu=lea.nextInt();
            
            switch(Opcion_Menu){
                case 1:
                    crear.imprimirDatabase();
                    System.out.println("**Login**");
                    System.out.print("Username: ");
                    nombre=lea.next();
                    System.out.println("Contraseña: ");
                    contraseña=lea.next();
                    crear.login(nombre, contraseña);
                    crear.entrar(nombre,contraseña);
                    //Menu principal
                    if (crear.login(nombre, contraseña)==true){
                        crear.imprimirMenuPrin();
                        
                    }
                    break;
                case 2:
                    System.out.println("*************");
                    System.out.println("Crear player");
                    System.out.print("Usuario: ");
                    nombre=lea.next();
                    System.out.print("Contraseña: ");
                    contraseña=lea.next();
                    crear.agregarplayer(nombre, contraseña, puntos);                    
                    break;
                case 3:
                    System.out.println("**Saliendo del juego**");
                    Menu_Inicio=true;
                    break;
                default:
                    break;
            }
        }while(!Menu_Inicio);
    }   
}