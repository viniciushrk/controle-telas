package br.sapiens.controllers.layout;

import br.sapiens.core.Header;
import br.sapiens.core.ViewEnum;
import br.sapiens.core.ViewsBuilder;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {

    private final ViewsBuilder viewsBuilder = new ViewsBuilder();
    @FXML
    private BorderPane painel;

    private Void trocaTela(ViewEnum tela){
        try {
            painel.setCenter(viewsBuilder.getPagina(tela));
            return null;
        }catch (Exception e) {
            var te = ViewEnum.Index;
            painel.setCenter(viewsBuilder.getPagina(ViewEnum.Error));
            return null;
        }
    }

    public void initialize() throws IOException {
        painel.setTop(new Header().getHeader(this::trocaTela));
        trocaTela(ViewEnum.Index);
    }
}