package dao;

import api.ProductDao;
import entity.Product;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    String fileName;

    /*
    W konstruktorze parametrowym inicjalizuj nazwę pliku i zapisz ją w polu klasy
W każdej metodzie otwieraj na nowo plik i na koniec go zamykaj (!)
Niech jeden produkt oznacza jedną linię
Najlepiej w metodzie toString zdefiniuj format w jakim ma być zapisywany obiekt do pliku –
wartości pół możesz oddzielać jakimś separatorem np. #
Najlepiej, żebyś cały plik wczytywał do listy – najlepiej Produktów, a nie Stringów.
Musisz wtedy odpowiednio wczytanego Stringa sparsować – np. pierwsza wartość do hasha to Id,
kolejna do hasha to productName itd. Na wczytanej liście wykonuj odpowiednie operację w metodzie i ponownie
zapisuj całą listę do pliku. Choć nie jest to zbyt optymalne rozwiązanie (pod względem czasu) to będzie wystarczająco
bezpieczne.


 String fileName = "dane.txt";
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.write("Witaj mój pliku. ");
        printWriter.write("Obługuję te trudne pliki!. ");
        printWriter.close();
     */
    PrintWriter printWriter;

    {
        try {
            printWriter = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ProductDaoImpl(String fileName) {
        this.fileName = fileName + ".txt";
    }

    public void saveProduct(Product product) {
        printWriter.write(product);
    }

    public void saveProducts(List<Product> products) {

    }

    public void removeProductById(Long productId) {

    }

    public void removeProductByName(String productName) {

    }

    public List<Product> getAllProducts() {
        return null;
    }

    public Product getProductById(Long productId) {
        return null;
    }

    public Product getProductByProductName(String productName) {
        return null;
    }

    @Override
    public String toString() {
        return "ProductDaoImpl{" +
                "fileName='" + fileName + '\'' +
                ", printWriter=" + printWriter +
                '}';
    }
}
