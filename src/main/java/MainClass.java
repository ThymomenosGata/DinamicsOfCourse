import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        try {
            Dinamics.wow();
        }catch(IOException e){
            System.out.print("Отсутствует подключение к сети");
        }
    }
}
