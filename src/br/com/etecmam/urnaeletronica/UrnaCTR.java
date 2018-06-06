package br.com.etecmam.urnaeletronica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import br.com.etecmam.urnaeletronica.dmp.Candidato;
import br.com.etecmam.urnaeletronica.dmp.CandidatoDAO;

public class UrnaCTR implements Initializable, 
								EventHandler<ActionEvent> {

	@FXML private ImageView imagem;
	@FXML private Label sigla;
	@FXML private Label candidato;
	@FXML private Label numeroCandidato1;
	@FXML private Label numeroCandidato2;
	@FXML private JFXButton branco;
	@FXML private JFXButton confirma;
	@FXML private JFXButton corrige;
	@FXML private JFXButton numero0;
	@FXML private JFXButton numero1;
	@FXML private JFXButton numero2;
	@FXML private JFXButton numero3;
	@FXML private JFXButton numero4;
	@FXML private JFXButton numero5;
	@FXML private JFXButton numero6;
	@FXML private JFXButton numero7;
	@FXML private JFXButton numero8;
	@FXML private JFXButton numero9;
	
	private String numero;
	private CandidatoDAO dao;
	private Candidato c;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		limparDados();

		dao = new CandidatoDAO();

		numero0.setOnAction(this);
		numero1.setOnAction(this);
		numero2.setOnAction(this);
		numero3.setOnAction(this);
		numero4.setOnAction(this);
		numero5.setOnAction(this);
		numero6.setOnAction(this);
		numero7.setOnAction(this);
		numero8.setOnAction(this);
		numero9.setOnAction(this);

		branco.setOnAction( a->{
			c = dao.pesquisar(88);
			candidato.setText( c.getNome() );
			sigla.setText( c.getSigla() );						
			imagem.setImage( new Image("branco.png") );			
			
		});
		
		corrige.setOnAction( a->{
			limparDados();
		});
		
		confirma.setOnAction( a->{
			
			if( c != null ) {
				
				c.setVotos( c.getVotos() + 1);
				dao.atualizar(c);
				
				Alert alert  = new Alert(AlertType.INFORMATION );
				alert.setTitle("ELEIÇÕES");
				alert.setHeaderText("CONFIRMAÇÃO DE VOTO");
				alert.setContentText("VOTO CONFIRMADO !!!");
				alert.show();				
				
			}
			
			limparDados();
			
		});

	}

	private void limparDados() {
		
		try {
			
			c = null; 
			numero = "";
			numeroCandidato1.setText("");
			numeroCandidato2.setText("");
			candidato.setText("CANDIDATO");
			sigla.setText("SIGLA");
						
			imagem.setImage( new Image("candidato.png") );		
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	

	@Override
	public void handle(ActionEvent event) {

		JFXButton botao = (JFXButton) event.getSource();

		numero += botao.getText();

		if (numero.length() < 2) {
			numeroCandidato1.setText( botao.getText() );
			
		}else if (numero.length() > 2) {
			//nada
		} else {
			numeroCandidato2.setText( botao.getText() );

			c = dao.pesquisar( Integer.valueOf(numero) );
			
			if (c == null)  c = dao.pesquisar(99);

			candidato.setText( c.getNome() );
			sigla.setText( c.getSigla() );
			imagem.setImage( new Image( c.getFoto() ) );

		}

	}

}
