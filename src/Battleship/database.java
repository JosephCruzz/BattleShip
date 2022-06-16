package Battleship;
import java.util.ArrayList;
import java.util.ArrayList;
public class database {
    
    ArrayList<Integer> Puntos=new ArrayList<Integer>();
    ArrayList<String> id=new ArrayList<String>();
    ArrayList<String> contra=new ArrayList<String>();
    String username="";
    String password="";
    int puntos=0;
    public database(String id,String password, int puntos){
    username=id;
    this.password=password;
    this.puntos=puntos;
    }
    
    public boolean agregarplayer(String id2,String password,int puntos){
        for(String tmp:id){
            if(tmp.equals(id2)){
                return false;
            }           
        }        
            id.add(id2);
            contra.add(password);
            Puntos.add(puntos);
            return true;   
        }
    public void imprimirDatabase(){
        for (int i=0;i<id.size();i++){
            System.out.println("Nombre :"+id.get(i)+" Password :"+contra.get(i)+" Puntos :"+Puntos.get(i));
        }
    }
     public void imprimirMenuPrin(){
         System.out.println("1-Jugar Battleship");
         System.out.println("2-Configuracion");
         System.out.println("3-Reportes");
         System.out.println("4-Mi perfil");
         System.out.println("5-Volver al Menu de Inicio");
    }
     public void imprimirMenuIn(){
        System.out.println("**Menu Inicio**");
        System.out.println("1-Login");
        System.out.println("2-Crear player");
        System.out.println("3-Salir");
        System.out.print("Ingrese el numero de la opcion: ");
     }
     public void imprimirConf(){
         System.out.println("1-Dificultad");
         System.out.println("2-Modo de Juego");
         System.out.println("3-Volver al Menu");
     }
     public void imprimirRep(){
         System.out.println("1-Descripcion de mis ultimos juegos");
         System.out.println("2-Ranking de Jugadores");
         System.out.println("3-Volver al Menu");
     }
     public void imprimirPerf(){
         System.out.println("1-Ver mis Datos");
         System.out.println("2-Modificar mis Datos");
         System.out.println("3-Eliminar mi cuenta");
         System.out.println("4-Volver al Menu");
     }
     public boolean login(String id2,String password){
         for (String tmp:id){
             if (tmp.equals(id2)){
             for (int i=0;i<id.size();i++){
                 if (contra.get(i).equals(password)){
                     return true;
                 }
             }    
             }
         }   
         return false;
     }
     
     public boolean loginPlayer2(String idPlayer1,String idPlayer2,String password2){
            for (int i=0;i<id.size();i++){
                if (id.get(i).equals(idPlayer2)&&!id.get(i).equals(idPlayer1)){
                        if (contra.get(i).equals(password2)&&idPlayer1!=idPlayer2){
                            return true;
                        }
                }
            }        
         return false;
     }
     public boolean entrar(String id2,String password){
          if (login(id2,password)==true){
              System.out.println("Bienvenido "+id2+" a Battleship");
          return true;
          }
          System.out.println("Tu username o password son incorrectos");
          return false;
     }
      public boolean entrarPlayer2(String idPlayer1,String idPlayer2,String password2){
          if (loginPlayer2(idPlayer1,idPlayer2,password2)==true){
              System.out.println("Player 2 Listo");
          return true;
          }
          System.out.println("Tu username o password son incorrectos");
          return false;
     }
   }