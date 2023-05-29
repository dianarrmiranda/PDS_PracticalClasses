package lab11.Ex1;

public class MemorySortingStrategy implements Strategy{
    public void sort(Mobile[] mobiles) {
        // Implementação da ordenação por preço
        int n = mobiles.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (mobiles[j].getMemory() < mobiles[min_idx].getMemory()) {
                    min_idx = j;
                }
            }
            Mobile temp = mobiles[min_idx];
            mobiles[min_idx] = mobiles[i];
            mobiles[i] = temp;
        }
    } 
}
