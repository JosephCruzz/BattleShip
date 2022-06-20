package Battleship;
import java.io.IOException;
import java.util.Scanner;
public class Ejecutar_Juego {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        String nombre="",contraseña="",nombre2="",contraseña2="";
        String Player1="";
        String contraseñaPlayer1="";
        String Player2="";
        String nuevonombre="",nuevopassword="";
        int puntos=0,respuesta=0,respuesta2=0,respuesta3=0,perfil=0;
        int tableroLength=8;
        String agua="~";
        String portaaviones="PA";
        String acorazado="AZ";
        String submarino="SM";
        String Destructor="DT";
        String fallo="F";
        String golpe="X";
        int Modo=4;
        database crear=new database(nombre,contraseña,puntos);
        Battleship battle=new Battleship(tableroLength,agua,portaaviones,acorazado,submarino,Destructor,fallo,golpe,Modo);
        boolean Menu_Inicio=false,Menu_prin=false,inicio=false,perfilB=false,eliminar=false,salir=false;
        int Opcion_Menu=0,Opcion_Prin=0;
        boolean Tutorial=true;
        String ModosJuego;
        
        //Menu Inicio
        do{
            crear.imprimirMenuIn();
            Opcion_Menu=lea.nextInt();
            switch(Opcion_Menu){
                case 1:
                    crear.imprimirDatabase();
                    System.out.println("**Login**");
                    System.out.print("Username: ");
                    lea.useDelimiter("\n");
                    nombre=lea.next();
                    System.out.print("Password: ");
                    lea.useDelimiter("\n");
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
                                do{
                                   System.out.println("--Inicio de Sesion para Player 2--");
                                System.out.print("Username: ");
                                lea.useDelimiter("\n");
                                nombre2=lea.next();
                                System.out.print("Password: ");
                                lea.useDelimiter("\n");
                                contraseña2=lea.next();
                                crear.loginPlayer2(Player1, nombre2, contraseña2);
                                if (crear.loginPlayer2(Player1, nombre2,contraseña2)==true){
                                    Player2=nombre2;
                                    System.out.println("Player 1: "+Player1);
                                    System.out.println("Player 2: "+Player2);
                                    System.out.println("Listos?");
                                    System.out.println("1-SI  2-NO");
                                    System.out.println("--Si desea salir, presione 3--");
                                    respuesta=lea.nextInt();
                                    switch(respuesta){
                                        case 1:
                                            System.out.println("Juego en construccion :v ya no xd");
                                            crear.TiposBarcos();
                                            battle.mostrarTurnoActual(Player1,Player2);
                                            int Modotmp=Modo;
                                            battle.tipoBarquito(portaaviones, acorazado, submarino, Destructor);
                                             
                                            while (battle.tipoBarquito(portaaviones, acorazado, submarino, Destructor).equals(battle.tipoBarquito(portaaviones, acorazado, submarino, Destructor))){
                                                if (battle.tipoBarquito(portaaviones, acorazado, submarino, Destructor).equals(battle.tipoBarquito(portaaviones, acorazado, submarino, Destructor))){
                                             System.out.println("No puede elejir el mismo tipo de barco dos veces");
                                                
                                            
                                                
                                                }else {  }
                                               
                                            }
                                                    
                                           
                                            
                                            
                                            
                                             
                                            String[][] tablero = battle.creartablero(tableroLength,agua,portaaviones,acorazado,submarino,Destructor,Modo);
                                           
                                            battle.imprimirTablero(tablero, agua,portaaviones,Tutorial);
                                            int numeroBarquitosIndetectados=Modo;                                            
                                            while(numeroBarquitosIndetectados>0){
                                                battle.cambiaTurno();
                                                battle.mostrarTurnoActual(Player1,Player2);
                                                int [] adivinarCoordenadas = battle.coordenadasUsuario(tableroLength);
                                                String actualizarLugar=battle.evaluaryTraerObjetivo(adivinarCoordenadas,tablero,portaaviones,agua,golpe,fallo);
                                                if(actualizarLugar.equals(golpe)){
                                                    numeroBarquitosIndetectados=-1;
                                                }
                                                tablero=battle.actualizarTablero(tablero, adivinarCoordenadas,actualizarLugar);
                                                battle.imprimirTablero(tablero,agua,portaaviones,Tutorial);
                                            }
                                                System.out.println("Ganaste!");
                                               
                                            
                                   
                                            break;
                                             
                                        case 2:
                                            System.out.println("--Volviendo al Inicio de sesion de Player 2--");
                                            break;
                                        case 3:
                                            System.out.println("--Volviendo al Menu Principal--");
                                            inicio=true;
                                            break;
                                        default:
                                            System.out.println("Selecciona 1, 2 o 3");
                                            break;
                                    }
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
                                            inicio=true;
                                            System.out.println("Volviendo al Menu Principal");
                                            break;
                                    }
                                } 
                                }while(!inicio);
                                inicio=false;
                                break;
                            case 2:
                                System.out.println("Bienvenido a configuracion");
                                 crear.imprimirConfig();
                                 int ConfigMenu;
                                 ConfigMenu=lea.nextInt();
                                 switch (ConfigMenu){
                                    case 1:
                                        System.out.println("Aqui usted puede cambiar la dificultad");
                                        System.out.println("Press enter to continue");
                                         try{System.in.read();}
                                         catch(IOException e){}
                                         
                                        battle.dificultad(Modo);
                                        Modo=battle.dificultad(Modo);                                        
                                             break;
                                    case 2: 
                                        System.out.println("--------------------------------------");
                                        System.out.println("Modos de juego");
                                        System.out.println("En el tutorial todos podran ver los barcos, en el modo de juego Arcade estaran ocultos.");
                                        System.out.println("a) Tutorial -- b) Arcade");
                                        System.out.println("Escriba cual la letra correspondiente del modo de juego desea: ");
                                        System.out.println("Ejemplo : a");
                                        ModosJuego=lea.next();
                                        ModosJuego=ModosJuego.toLowerCase();
                            switch (ModosJuego) {
                                case "a":
                                    System.out.println("Usted activo Tutorial");
                                    Tutorial=true;
                                    break;
                                case "b":
                                    System.out.println("Usted activo arcade");
                                    Tutorial=false;
                                    break;
                                default:
                                    System.out.println("Usted ha ingresado una letra incorrecta, escriba la correcta");
                                    break;
                            }

                                            }
                                break;
                            case 3:
                                crear.imprimirRep();
                                break;
                            case 4:
                                do{
                                crear.imprimirPerf();
                                perfil=lea.nextInt();
                                switch(perfil){
                                    //Ver datos
                                    case 1:
                                        crear.imprimirPlayer1(Player1);
                                        break;
                                        //Modificar cuenta
                                    case 2:
                                        do{
                                                                                 
                                        crear.imprimirModificacion(Player1);
                                        respuesta=lea.nextInt();
                                        if (respuesta==1||respuesta==2||respuesta==3){
                                            salir=true;
                                        }
                                        else {
                                            System.out.println("--Opcion Invalida--");
                                        }
                                         }while (!salir);
                                        salir=false;
                                        switch(respuesta){
                                            case 1:
                                                do{
                                                System.out.println("------------------");
                                                System.out.print("Nuevo nombre: ");
                                                lea.useDelimiter("\n");
                                                nuevonombre=lea.next();
                                                if(!nuevonombre.equals(Player1)){
                                                    if (crear.modificarNombre(Player1, nuevonombre)==true){
                                                        System.out.println("--Los cambios se han aplicado--");
                                                        crear.modificarNombre(Player1, nuevonombre);
                                                        Player1=nuevonombre;
                                                        salir=true;
                                                    }
                                                    else{
                                                        System.out.println("----ATENCION---");
                                                        System.out.println("--NUEVO NOMBRE YA ESTA EN USO--");
                                                    }
                                                }
                                                else {
                                                    System.out.println("--Ha ingresado el mismo nombre-- \nTiene que ser uno nuevo");
                                                }
                                                }while(!salir);
                                                salir=false;
                                                break;
                                            case 2:
                                                System.out.println("-------------------------------");
                                                System.out.print("Ingrese el nuevo password: ");
                                                lea.useDelimiter("\n");
                                                nuevopassword=lea.next();
                                                crear.modificarPassword(Player1, nuevopassword);
                                                break;
                                            case 3:
                                                System.out.println("--Volviendo al Menu de Perfil--");
                                                
                                                break;
                                        }
                                        break;
                                        //Eliminar cuenta
                                    case 3:
                                        do{
                                         System.out.println("--Eliminacion de cuenta--");
                                         System.out.println("------------------------------------------");
                                         System.out.println("Deseas eliminar tu cuenta permanentemente?");
                                         System.out.println("1-SI  2-NO");
                                         System.out.print("Opcion: ");
                                         respuesta=lea.nextInt();
                                         if (respuesta==1||respuesta==2){
                                             salir=true;
                                         }
                                        }while(!salir);
                                        salir=false;
                                        switch(respuesta){
                                             case 1:
                                             eliminar=true;
                                            crear.eliminarCuenta(eliminar,Player1);
                                             System.out.println("--Volviendo al Menu de Inicio--");
                                             perfilB=true;
                                             Menu_prin=true;
                                             eliminar=false;
                                                 break;
                                             case 2:
                                           System.out.println("--Volviendo al Menu de Perfil--");
                                                 break;
                                         }
                                        break;
                                    case 4:
                                         System.out.println("--Volviendo al Menu Principal--");
                                        perfilB=true;
                                        break;
                                    default:
                                        break;
                                }
                                }while(!perfilB);
                                perfilB=false;
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
                    }
                    Menu_prin=false;
                    break;
                case 2:
                    System.out.println("*************");
                    System.out.println("Crear player");
                    System.out.print("Usuario: ");
                    lea.useDelimiter("\n");
                    nombre=lea.next();
                    System.out.print("Password: ");
                    lea.useDelimiter("\n");
                    contraseña=lea.next();
                    crear.agregarplayer(nombre, contraseña, puntos);                    
                    break;
                case 3:
                    do{
                        System.out.println("--------------------------------------------");
                        System.out.println("Esta seguro que desea salir de Battleship?");
                        System.out.println("1-SI   2-NO");
                        System.out.println("Ingrese el numero de la opcion");
                        System.out.print("Opcion: ");
                        respuesta=lea.nextInt();
                        if (respuesta==1||respuesta==2){
                            salir=true;
                        }
                        else {
                            System.out.println("--Opcion Invalida--");
                        }
                    }while(!salir);
                    salir=false;
                    switch(respuesta){
                        case 1:
                            System.out.println("**Saliendo de Battleship**");
                            Menu_Inicio=true;
                            break;
                        case 2:
                            System.out.println("--Volviendo al Menu de Inicio--");
                            break;
                    }
                    break;
                default:
                    break;
            }
        }while(!Menu_Inicio);
    }   
}