package lab05.Ex1;

public class Container {
    Portion portion;

    public Container(Portion menu) {
        this.portion = menu; // aparentemente é preciso este método para poder usar o super(menu) nas classes que dão extend de container
    }

    public Portion getPortion() { // este método está aqui para nas classes filhas, estas poderem aceder ao toString da refeição
        return portion;
    }

    public static Container create(Portion menu) {
        switch (menu.getState()) {
            case Solid:
                if (menu.getTemperature() == Temperature.COLD)
                    return new PlasticBag(menu);
                else
                    return new Tupperware(menu);
            case Liquid:
                if (menu.getTemperature() == Temperature.COLD)
                    return new PlasticBottle(menu);
                else
                    return new TermicBottle(menu);
            default:
                System.out.println("Error! Unknown State enum declared!");
                System.exit(1);
        }
        return null;
    }
}
