package itson.ticketwizard.persistencia;
import java.util.List;
import itson.ticketwizard.entidades.Boleto;

public interface IBoletosDAO {
   public List<Boleto> consultarBoletos(Integer idEv);
}
