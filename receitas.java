import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

public class receitas {
    public static void main(String[] args) {
        try (Scanner ler1 = new Scanner(System.in)) {
            int on = 1;
            int receitaPos = 0;
            String UserInputLista;
            ArrayList<String> receita = new ArrayList<String>(receitaPos);
            while (on == 1) {
                System.out.println("insira o nome da receita");
                UserInputLista = ler1.nextLine();
                receita.add(UserInputLista);
                System.out.println(receitaPos + ": " + receita.get(receitaPos));
                receitaPos++;
                System.out.println(receita);
                try {
                    System.out.println("digite 0 se deseja desligar o programa");
                    on = ler1.nextInt();
                    if (on != 0 && on != 1) {
                        System.out.println(" Insert invalido");
                        on = 1;
                    }
                } catch (Exception a) {
                    System.out.println("Insert invalido");
                }
                if (on == 0) {
                    create(args);
                    try {
                        FileReader lerLista = new FileReader("C:\\Users\\pedro\\Documents\\receitas.txt");
                        lerLista.read();
                        lerLista.close();
                        FileWriter escrever = new FileWriter("C:\\Users\\pedro\\Documents\\receitas.txt");
                        escrever.write("lista de receitas: " + receita);
                        escrever.close();
                    } catch (IOException c) {
                        System.out.println("Ocorreu um problema");
                        c.printStackTrace();
                    }
                }
            }
        }
    }
    public static void create(String[] args) {
        try {
            File novoaArquivo = new File("C:\\Users\\pedro\\Documents\\receitas.txt");
            if (novoaArquivo.createNewFile()) {
                System.out.println("nova lista criada: " + novoaArquivo.getName());
            } else {
                System.out.println("Arquivo ja existe");
            }
        } catch (IOException b) {
            System.out.println("Ocorreu um erro");
            b.printStackTrace();
        }
    }
}
