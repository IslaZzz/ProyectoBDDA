package itson.ticketwizard.persistencia;
import java.util.List;
import itson.ticketwizard.entidades.Boleto;

public interface IBoletosDAO {
   public List<Boleto> consultarBoletosEvento(Integer idEv);
   public void venderBoletoBoletera(Integer idUsuario, Boleto boleto);
}
