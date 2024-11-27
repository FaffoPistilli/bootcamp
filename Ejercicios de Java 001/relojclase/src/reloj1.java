public class reloj1 {
    private int horas;
    private int minutos;
    private int segundos;
    public reloj1() {
        this.horas = 12;
        this.minutos = 0;
        this.segundos = 0;
    }
    public reloj1(int horas, int minutos, int segundos) {
        setHoras(horas);
        setMinutos(minutos);
        setSegundos(segundos);
    }
    public reloj1(int segundosTotales) {
        setReloj(segundosTotales);
    }
    public void setReloj(int segundosTotales) {
        horas = segundosTotales / 3600 % 24;
        minutos = (segundosTotales % 3600) / 60;
        segundos = segundosTotales % 60;
    }
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        if (horas >= 0 && horas < 24) {
            this.horas = horas;
        } else {
            System.out.println("Hora inválida. Se ha establecido a 0.");
            this.horas = 0;
        }
    }
    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
        } else {
            System.out.println("Minutos inválidos. Se ha establecido a 0.");
            this.minutos = 0;
        }
    }
    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        if (segundos >= 0 && segundos < 60) {
            this.segundos = segundos;
        } else {
            System.out.println("Segundos inválidos. Se ha establecido a 0.");
            this.segundos = 0;
        }
    }
    public void tick() {
        segundos++;
        if (segundos >= 60) {
            segundos = 0;
            minutos++;
            if (minutos >= 60) {
                minutos = 0;
                horas++;
                if (horas >= 24) {
                    horas = 0;
                }
            }
        }
    }
    public void tickDecrement() {
        segundos--;
        if (segundos < 0) {
            segundos = 59;
            minutos--;
            if (minutos < 0) {
                minutos = 59;
                horas--;
                if (horas < 0) {
                    horas = 23;
                }
            }
        }
    }
    public void addReloj(reloj1 otroReloj) {
        int segundosTotales = this.getSegundosTotales() + otroReloj.getSegundosTotales();
        setReloj(segundosTotales);
    }
    public int restaReloj(reloj1 otroReloj) {
        return this.getSegundosTotales() - otroReloj.getSegundosTotales();
    }
    public String toString() {
        return String.format("[%02d:%02d:%02d]", horas, minutos, segundos);
    }
    private int getSegundosTotales() {
        return horas * 3600 + minutos * 60 + segundos;
    }

    //Esta es la funcion de Ian
    public void funcion_ian() {
        System.out.println("Esta es la funcion de Ian !!! :)");
    }
}