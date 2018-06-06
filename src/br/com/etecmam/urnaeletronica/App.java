package br.com.etecmam.urnaeletronica;

import java.util.List;

import br.com.etecmam.urnaeletronica.dmp.Candidato;
import br.com.etecmam.urnaeletronica.dmp.CandidatoDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
	
		CandidatoDAO dao = new CandidatoDAO();
		
		List<Candidato> lista = dao.listarCandidatos();
		
		if( lista.size() == 0 ) {
			
			dao.adicionar( new Candidato(10, "CHAVES", "PDC", "chaves.png", 0 ));
			dao.adicionar( new Candidato(20, "SEU MADRUGA", "PSM", "madruga.png", 0 ));
			dao.adicionar( new Candidato(30, "KIKO", "PDK", "kiko.png", 0 ));
			dao.adicionar( new Candidato(40, "DONA FLORINDA", "PDF", "florinda.png", 0 ));			
			dao.adicionar( new Candidato(99, "NULO", "NULO", "nulo.png", 0 ));
			dao.adicionar( new Candidato(88, "BRANCO", "BRANCO", "branco.png", 0 ));
						
		}		
		
		launch(args);
	}

	@Override
	public void start(Stage palco) throws Exception {
		
		Parent principal = FXMLLoader.load(getClass().getResource("/br/com/etecmam/urnaeletronica/ui/Urna.fxml"));
		palco.setScene( new Scene(principal) );
		palco.show();
		
	}

}
