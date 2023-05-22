package lab11.Ex1;

public class EletronicMagazine {
        private StrategyFactory sortingStrategyFactory;
        private Mobile[] mobiles;
    
        public EletronicMagazine() {
            sortingStrategyFactory = new StrategyFactory();
            mobiles = new Mobile[5];
            // Preencher a lista de telemóveis com exemplos
            mobiles[0] = new Mobile("iPhone 14", 1599.99, "A14 Bionic", 128);
            mobiles[1] = new Mobile("Samsung Galaxy S22", 1299.99, "Exynos 2100", 512);
            mobiles[2] = new Mobile("Google Pixel 6", 749.99, "Snapdragon 765G", 128);
            mobiles[3] = new Mobile("OnePlus 9 Pro", 859.99, "Snapdragon 888", 256);
            mobiles[4] = new Mobile("Xiaomi Mi 13", 499.99, "Snapdragon 888", 128);
        }
    
        public void displayMobiles(String attribute) {
            // Obter a estratégia de ordenação apropriada
            Strategy sortingStrategy = sortingStrategyFactory.createStrategy(attribute);
    
            // Ordenar os telemóveis usando a estratégia selecionada
            sortingStrategy.sort(mobiles);
    
            // Exibir a lista ordenada de telemóveis
            showMobiles(mobiles);
        }
    
        public void showMobiles(Mobile[] mobiles) {
            System.out.println("List of Mobiles:");
            for (Mobile mobile : mobiles) {
                System.out.println("Name: " + mobile.getName());
                System.out.println("Price: $" + mobile.getPrice());
                System.out.println("Processor: " + mobile.getProcessor());
                System.out.println("Memory: " + mobile.getMemory() + "GB");
                System.out.println("------------------------");
        }
    }
}
