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
    
    public String search(String id2){
        for(String tmp:id){
            if(tmp != null && tmp== id2){
                return "";
            }
        }
        return null;
}
    public boolean agregarplayer(String id2,String password,int puntos){
        if (search(id2)==null){
            id.add(id2);
            contra.add(password);
            Puntos.add(puntos);
            return true;
    }
         return false;
        }
    public void imprimir(){
        for (int i=0;i<id.size();i++){
            System.out.println("Nombre :"+id.get(i)+"Contrasena :"+contra.get(i)+"Puntos :"+Puntos.get(i));
        }
    }
   }