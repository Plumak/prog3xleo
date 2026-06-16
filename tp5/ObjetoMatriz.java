package tp5;

public class ObjetoMatriz {
    private boolean norte;
    private boolean oeste;
    private boolean sur;
    private boolean este;
    private int value;
    
    public ObjetoMatriz(boolean norte, boolean oeste, boolean sur, boolean este, int value) {
        this.norte = norte;
        this.oeste = oeste;
        this.sur = sur;
        this.este = este;
        this.value = value;
    }

    public boolean isNorte() {
        return norte;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public boolean isOeste() {
        return oeste;
    }

    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }

    public boolean isSur() {
        return sur;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public boolean isEste() {
        return este;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    
}
