import view.View;

public class Main {
    public static void main(String[] args) {
        try{
            View view = new View();
            view.draw();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
