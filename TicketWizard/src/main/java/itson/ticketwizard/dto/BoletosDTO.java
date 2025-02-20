package itson.ticketwizard.dto;

public class BoletosDTO {
    private Integer idBoleto;
    private String numeroSerie;
    private String fila;
    private String asiento;
    private Integer idEvento;

    /**
     *
     * @param idBoleto
     * @param numeroSerie
     * @param fila
     * @param asiento
     * @param idEvento
     */
    public BoletosDTO(Integer idBoleto, String numeroSerie, String fila, String asiento, Integer idEvento) {

        this.idBoleto = idBoleto;
        this.numeroSerie = numeroSerie;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
    }
    public Integer getIdBoleto() {
        return idBoleto;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }
    public String getFila() {
        return fila;
    }
    public String getAsiento() {
        return asiento;
    }
    public Integer getIdEvento() {
        return idEvento;
    }

}
