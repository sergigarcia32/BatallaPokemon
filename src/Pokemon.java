public class Pokemon {

    private String nombre;
    private Ataque ataque1;
    private Ataque ataque2;
    private int vida;

    public Pokemon(String nombre, Ataque ataque1, Ataque ataque2, int vida) {
        this.nombre = nombre;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public Ataque getAtaque1() {
        return ataque1;
    }

    public Ataque getAtaque2() {
        return ataque2;
    }
    public int getVida() {
            return vida;
    }
    public boolean hayVida() {
        return this.getVida() > 0;
    }

    public void recibirDaño(int daño) {
        this.vida -= daño;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nombre + " tiene " + vida + " PS restantes.");
    }

}
