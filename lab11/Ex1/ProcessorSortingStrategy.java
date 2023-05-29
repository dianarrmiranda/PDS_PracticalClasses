package lab11.Ex1;

public class ProcessorSortingStrategy implements Strategy {
    public void sort(Mobile[] mobiles) {
<<<<<<< HEAD
        // Implementação da ordenação por preço
        System.out.println("Usou o ProcessorSortingStrategy");
=======
        // Implementação da ordenação por processador (ordem alfabética)
        int n = mobiles.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (mobiles[j].getProcessor().compareTo(mobiles[min_idx].getProcessor()) < 0) {
                    min_idx = j;
                }
            }
            Mobile temp = mobiles[min_idx];
            mobiles[min_idx] = mobiles[i];
            mobiles[i] = temp;
        }

>>>>>>> aeee283 (ex1)
    } 
}
