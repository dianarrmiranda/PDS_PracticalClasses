package lab11.Ex1;

// Estratégia de ordenação por preço
class PriceSortingStrategy implements Strategy {
    public void sort(Mobile[] mobiles) {
        // Implementação da ordenação por preço
        int n = mobiles.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (mobiles[j].getPrice() < mobiles[min_idx].getPrice()) {
                    min_idx = j;
                }
            }
            Mobile temp = mobiles[min_idx];
            mobiles[min_idx] = mobiles[i];
            mobiles[i] = temp;
        }
        System.out.println("Usou o PriceSortingStrategy");
    }
}
