import com.fasterxml.jackson.databind.ObjectMapper;
import service.BookService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printChoices(){
        System.out.println("""
                Hej, vad vill du göra?
                1. Skapa en bok
                2.Visa alla böcker
                9.Avsluta
                """);
    }

    public static void main(String[] args) throws IOException {

        BookService service = new BookService();

        Book book1 = new Book();

        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("src/main/resources/books.json");
        List<Book>booksFromJson = List.of(mapper.readValue(path.toFile(),Book[].class));


        System.out.println("""
                Hej, vad vill du göra?
                1. Skapa en bok
                2.Visa alla böcker
                9.Avsluta
                """);

        int choice = Integer.parseInt(scanner.nextLine());

        while (choice !=9){
            switch (choice){
                case 1:
                    List<Book> books = new ArrayList<>(booksFromJson);
                    System.out.println("Skriv in titel:");
                    String title = scanner.nextLine();
                    System.out.println("Skriv in författaren:");
                    String author = scanner.nextLine();
                    System.out.println("Skriv in antal sidor:");
                    int onOfPages = Integer.parseInt(scanner.nextLine());
                    String date = LocalDate.now().toString();
                    Book newBook = new Book(onOfPages,title,author,date);
                    books.add(newBook);
                    mapper.writeValue((path.toFile()), books);

                    System.out.println("""
               
                 Hej, vad vill du göra?
                 1. Skapa en bok
                 2.Visa alla böcker
                 9.Avsluta
                 """);

                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                case 2:
                    List<Book>booksFromJson2 = List.of(mapper.readValue(path.toFile(),Book[].class));
                    for (Book book : booksFromJson2){
                        System.out.println("Författare:" + book.getAuthor());
                        System.out.println("Titel:" + book.getTitle());
                        System.out.println("Antal sidor:" + book.getNumberOfPages());
                        System.out.println("Datum:" + book.getDate());
                    }




            }
            choice =9;

        }



    }

}
