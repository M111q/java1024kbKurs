import entity.Boots;

public class Main {
    /*
    Klasa entity.User:
    id
    login
    password

    2. Klasa entity.Product:
    id
    productName
    price
    weight
    color (String)
    productCount

    3. Klasa entity.Boots – dziedzicząca po entity.Product:
    size (liczba całkowita)
    isNaturalSkin (boolean)

    4. Klasa entity.Cloth – dziedzicząca po entity.Product:
    size (String)
    material (String)



    Chciałbym, abym mógł dostać się do każdej zmiennej w klasie, ale żebym mógł modyfikować tylko następujące pola:
    Cenę produktu
    Ilość produktów

     */
    public static void main(String[] args) {
        // write your code here
        Boots trampki = new Boots(1L,"converse",100,1,"black",50,42,false);
        System.out.println(trampki);
    }
}
