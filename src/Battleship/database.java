package Battleship;
import java.util.ArrayList;
import java.util.ArrayList;
public class database {
    
    ArrayList<Integer> puntos=new ArrayList<Integer>();
    ArrayList<String> id=new ArrayList<String>();
    ArrayList<String> password=new ArrayList<String>();
    String username="";
    public database(String id,String password, int puntos){
    String _id=id;
    String _password=password;
    int _puntos=puntos;
    }
    
    public void addID(String i){
        id.add(i);
    }
    public void addPassword(String contra){
        password.add(contra);
    }
    public void addPuntos(int punt){
        puntos.add(punt);
    }
    
    public void imprimir(){
        for (int i=0;i<id.size();i++){
        System.out.println("Player: "+id.get(i)+" Tiene: "+puntos.get(i)+" punto"+(puntos.get(i)==1?"":"s"));
    }
    }
    public void search(String a,String contra,int punt){
         boolean si = false;
        for (int i=0;i<id.size();i++){
            if (a.equals(id.get(i))){
                si=false;
        }
            else{
                si=true;
            }
    }
       
}   
    }