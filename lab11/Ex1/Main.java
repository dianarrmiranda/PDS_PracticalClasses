package lab11.Ex1;

public class Main {
        public static void main(String[] args) {
            EletronicMagazine magazine = new EletronicMagazine();
            // Como os algoritmos de ordenação não estão implementados, o programa não ordena os telemóveis
            // Exibir lista de telemóveis ordenados por preço
            magazine.displayMobiles("price");
            System.out.println();
            // Exibir lista de telemóveis ordenados por processador
            magazine.displayMobiles("processor");
            System.out.println();
            // Exibir lista de telemóveis ordenados por memória
            magazine.displayMobiles("memory");
        }
}
