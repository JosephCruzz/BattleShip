package Battleship;
import java.util.Scanner;
public class Ejecutar_Juego {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
         
        String nombre="",contraseña="",nombre2="",contraseña2="";
        String Player1="";
        String contraseñaPlayer1="";
        String Player2="";
        int puntos=0,respuesta=0,respuesta2=0,respuesta3=0;
        database crear=new database(nombre,contraseña,puntos);
        boolean Menu_Inicio=false,Menu_prin=false;
        int Opcion_Menu=0,Opcion_Prin=0;
        
        //Menu Inicio
        do{
            crear.imprimirMenuIn();
            Opcion_Menu=lea.nextInt();
            switch(Opcion_Menu){
                case 1:
                    crear.imprimirDatabase();
                    System.out.println("**Login**");
                    System.out.print("Username: ");
                    nombre=lea.next();
                    System.out.print("Password: ");
                    contraseña=lea.next();
                    crear.login(nombre, contraseña);
                    crear.entrar(nombre,contraseña);
                    //Menu principal
                    if (crear.login(nombre, contraseña)==true){
                         Player1=nombre;
                         contraseñaPlayer1=contraseña;
                        do{            
                        crear.imprimirMenuPrin();
                        Opcion_Prin=lea.nextInt();
                        switch(Opcion_Prin){
                            case 1:
                                System.out.println("--Inicio de Sesion para Player 2--");
                                System.out.println("Username: ");
                                nombre2=lea.next();
                                System.out.println("Password: ");
                                contraseña2=lea.next();
                                crear.loginPlayer2(Player1, nombre2, contraseña2);
                                if (crear.loginPlayer2(Player1, nombre2,contraseña2)==true){
                                    Player2=nombre2;
                                    System.out.println("Player 1: "+Player1);
                                    System.out.println("Player 2: "+Player2);
                                    System.out.println("Listos?");
                                    System.out.println("1-SI  2-NO");
                                    respuesta=lea.nextInt();
                                }
                                else{
                                    System.out.println("Username o Password Incorrectos");
                                    System.out.println("Desea volver a intentarlo?");
                                    System.out.println("1-SI  2-NO");
                                    respuesta2=lea.nextInt();
                                    switch(respuesta2){
                                        case 1:
                                            System.out.println("-----------------");
                                            break;
                                        case 2:
                                            System.out.println("Desea volver al Menu Principal?");   
                                            System.out.println("1-SI   2-NO");
                                            respuesta3=lea.nextInt();
                                            switch(respuesta3){
                                                case 1: 
                                                    System.out.println("Estoy en el switch ");
                                                    break;
                                                case 2:
                                                    System.out.println("--------------");
                                                    break;
                                            }
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                crear.imprimirConf();
                                break;
                            case 3:
                                crear.imprimirRep();
                                break;
                            case 4:
                                crear.imprimirPerf();
                                break;
                            case 5:
                                System.out.println("--Volviendo al Menu de Inicio--");
                                Menu_prin=true;
                                break;
                            default:
                                System.out.println("---Opcion Invalida---");
                                break;
                        }
                        }while(!Menu_prin);
                        Menu_prin=false;
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