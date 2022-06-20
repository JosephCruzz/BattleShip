package Battleship;

import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;
public class Battleship {
    public Battleship(int tableroLength,String agua,String portaaviones,String acorazado,String submarino,String Destructor,String fallo,String golpe,int Modo){
        Destructor=this.Destructor;
        agua=this.agua;
        tableroLength=this.tableroLength;
        agua=this.agua;
        portaaviones=this.portaaviones;
        acorazado=this.acorazado;
        submarino=this.submarino;
        fallo=this.fallo;
        golpe=this.golpe;
        Modo=this.Modo;  
        this.turno=true;
        
    }
        
        String modo="";   
    
        
        int tableroLength=8;
        String agua="~";
        String portaaviones="PA";
        String acorazado="AZ";
        String submarino="SM";
        String Destructor="DT";
        String fallo="F";
        String golpe="X";
        int Modo=4;
         private boolean turno;
        
        
        
     String[][] creartablero(int tableroLength, String agua, String portaaviones, String acorazado, String submarino, String Destructor, int Modo) {
        String[][] tablero=new String[tableroLength][tableroLength];
          for(String[] row:tablero){
              Arrays.fill(row,agua);
          }
          return placedShips(tablero, Modo, agua, portaaviones);
    }

     String[][] placedShips(String[][] tablero, int Modo, String agua, String portaaviones) {
       int ponerBarquitos=0;
       int tableroLength=tablero.length;
       while (ponerBarquitos<Modo){
           int[] lugar = generarCoordenadasBarquitos(tableroLength);
           String posibleLugar=tablero[lugar[0]][lugar[1]];
           if(posibleLugar.equals(agua)){
               tablero[lugar[0]][lugar[1]]=portaaviones;
               ponerBarquitos=ponerBarquitos+1;
           }
       }
       return tablero;       
    }

     int[] generarCoordenadasBarquitos(int tableroLength) {
        String coordenadasUser;
       int [] coordenadas = coordenadasPonerUser(tableroLength);
       
       
       return coordenadas;
    }

     public void imprimirTablero(String[][] tablero, String agua, String portaaviones,boolean tutorial) {
        int tableroLength=tablero.length;
        System.out.print("  ");
        for (int i=0;i<tableroLength;i++){
            System.out.print(i+1+" ");
        }
         System.out.println();
        for (int filas=0;filas<tableroLength;filas++){
            System.out.print(filas + 1 + " ");
            for (int col=0;col<tableroLength;col++){
                String posicion = tablero[filas][col];
                if(posicion.equals(portaaviones)){
                    if (tutorial==false){
                        System.out.print(agua+ " ");
                   
                    }else if(tutorial==true){
                         System.out.print(portaaviones+ " ");
                    }
                }else {
                    System.out.print(posicion + " ");
                }

            }
                   System.out.println();
        }
               System.out.println();
    }

     int[] coordenadasUsuario(int tableroLength) {
        int filas;
        int col;
        do{
            System.out.print("Filas: ");
            filas=new Scanner(System.in).nextInt();
        } while(filas <0|| filas > tableroLength +1);
        do{
            System.out.print("Columnas: ");
            col=new Scanner(System.in).nextInt();
        }while (col<0||col>tableroLength+1);
        return new int[]{filas -1,col-1};
    }
     int[] coordenadasPonerUser(int tableroLength) {
        int filas;
        int col;
        do{
            System.out.print("Filas: ");
            filas=new Scanner(System.in).nextInt();
        } while(filas <0|| filas > tableroLength +1);
        do{
            System.out.print("Columnas: ");
            col=new Scanner(System.in).nextInt();
        }while (col<0||col>tableroLength+1);
        return new int[]{filas -1,col-1};
    }
     String evaluaryTraerObjetivo(int[] adivinarCoordenadas, String[][] tablero, String portaaviones, String agua, String golpe, String fallo) {
        String mensaje;
        int filas=adivinarCoordenadas[0];
        int col=adivinarCoordenadas[1];
        System.out.println(filas);
        System.out.println(col);
        String objetivo = tablero[filas][col];
        System.out.println(objetivo);
        if(objetivo.equals(portaaviones)) {
            mensaje = "ha acertado!";
            objetivo = golpe;
        }else if (objetivo.equals(agua)){
            mensaje = "ha fallado!";
            objetivo = fallo;
        }else {
            mensaje = "Already hit!";
        }
        System.out.println(mensaje);
        return objetivo;
    }

     String[][] actualizarTablero(String[][] tablero, int[] adivinarCoordenadas, String actualizarLugar) {
        int filas=adivinarCoordenadas[0];
        int col=adivinarCoordenadas[1];
        tablero[filas][col]=actualizarLugar;
        return tablero;
    }
    
     String tipoBarquito(String portaaviones,String acorazado,String submarino, String Destructor){
        System.out.println("Que tipo de barco usted desea elejir? (");
        String tipoBarquitoUser;
        
        do{
           
        tipoBarquitoUser=new Scanner(System.in).next();
        tipoBarquitoUser=tipoBarquitoUser.toUpperCase();
         if(tipoBarquitoUser.equals("PA")||(tipoBarquitoUser.equals("AZ"))||(tipoBarquitoUser.equals("SM"))||(tipoBarquitoUser.equals("DT"))){
             
         
            switch (tipoBarquitoUser) {  case "PA": return  portaaviones;
                case "AZ": return acorazado;
                case "SM":return submarino;
                case "DT": return Destructor;
                default: System.out.println("Ingrese un tipo de barco valido");
                    break;
            }
         }else{
             System.out.println("Usted elijio el mismo barco dos veces elija otro");
         }
        }while (tipoBarquitoUser.equals("PA")||(tipoBarquitoUser.equals("AZ"))||(tipoBarquitoUser.equals("SM"))||(tipoBarquitoUser.equals("DT")));
        return portaaviones;
    }
    
     int dificultad(int modo){
        
        String dificultadUser;
       
        do{
            System.out.println("Ingrese la opcion");
                   
            dificultadUser=new Scanner(System.in).nextLine();
            
            dificultadUser=dificultadUser.toUpperCase();
            switch (dificultadUser) { case "EASY": return  5;
                case "NORMAL": return 4;
                case "EXPERT": return 2;
                case "GENIUS": return 1;
                default: System.out.println("Ingrese un tipo de dificultad valida"); break; }
            
        }while ("EASY".equals(dificultadUser)|| dificultadUser.equals("EXPERT")||dificultadUser.equals("GENIUS")||dificultadUser.equals("NORMAL"));
        return 4;
        
    }
         /**
         * Mostramos el turno actual
         */
          public void mostrarTurnoActual(String Player1,String Player2) {

            if (turno) {
                System.out.println("Le toca al jugador: "+Player1);
            } else {
                System.out.println("Le toca al jugador: "+Player2);
            }

        }

        /**
         * Cambia el turno
         */
     public void cambiaTurno() {
            turno = !turno;
        }
    }
        


        

       

