public enum Mano {
    ESCALERA_COLOR(8),
    POKER(7),
    FULL(6),
    COLOR(5),
    ESCALERA(4),
    TRIO(3),
    DOBLE_PAR(2),
    PAR(1),
    CARTA_ALTA(0);

    private final int valor;
    Mano(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
