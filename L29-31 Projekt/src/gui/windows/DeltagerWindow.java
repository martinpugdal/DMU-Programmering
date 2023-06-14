package gui.windows;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Firma;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeltagerWindow extends Stage {
    Deltager deltager;
    private TextField txfNavn, txfTlfNr, txfAdresse, txfBy, txfLand, txfFirmaNavn, txfFirmaCvr, txfFirmaTlfNr;
    private CheckBox chbFirma;
    private GridPane firmaPane;

    public DeltagerWindow(Deltager deltager) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.deltager = deltager;

        this.setTitle("Deltager");
        GridPane pane = new GridPane();
        this.initContent(pane);

        if (deltager != null) {
            txfNavn.setText(deltager.getNavn());
            txfTlfNr.setText(deltager.getTlfNr());
            txfAdresse.setText(deltager.getAdresse());
            txfBy.setText(deltager.getBy());
            txfLand.setText(deltager.getLand());
            if (deltager.getFirma() != null) {
                chbFirma.setSelected(true);
                txfFirmaNavn.setText(deltager.getFirma().getNavn());
                txfFirmaCvr.setText(deltager.getFirma().getCvr());
                enableFirma();
            }
        }

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public DeltagerWindow() {
        this(null);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0, 0);

        txfNavn = new TextField();
        pane.add(txfNavn, 0, 1);
        txfNavn.setPrefWidth(200);

        Label lblTlfNr = new Label("Tlf. nr");
        pane.add(lblTlfNr, 0, 2);

        txfTlfNr = new TextField();
        pane.add(txfTlfNr, 0, 3);
        txfTlfNr.setPrefWidth(200);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 4);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 5);
        txfAdresse.setPrefWidth(200);

        Label lblBy = new Label("By");
        pane.add(lblBy, 0, 6);

        txfBy = new TextField();
        pane.add(txfBy, 0, 7);
        txfBy.setPrefWidth(200);

        Label lblLand = new Label("Land");
        pane.add(lblLand, 0, 8);

        txfLand = new TextField();
        pane.add(txfLand, 0, 9);
        txfLand.setPrefWidth(200);

        //------------------------------------------------------------------------------

        firmaPane = new GridPane();
        firmaPane.setPadding(new Insets(0));
        firmaPane.setHgap(10);
        firmaPane.setVgap(10);
        firmaPane.setGridLinesVisible(false);

        Label lblFirmaNavn = new Label("Firma navn");
        firmaPane.add(lblFirmaNavn, 0, 0);
        txfFirmaNavn = new TextField();
        txfFirmaNavn.setOnKeyTyped(event -> checkForFirmaExists());
        firmaPane.add(txfFirmaNavn, 1, 0);
        Label lblFirmaCvr = new Label("Firma CVR");
        firmaPane.add(lblFirmaCvr, 0, 1);
        txfFirmaCvr = new TextField();
        firmaPane.add(txfFirmaCvr, 1, 1);
        Label lblFirmaTlfNr = new Label("Firma tlf. nr");
        firmaPane.add(lblFirmaTlfNr, 0, 2);
        txfFirmaTlfNr = new TextField();
        firmaPane.add(txfFirmaTlfNr, 1, 2);

        chbFirma = new CheckBox("Firma");
        pane.add(chbFirma, 1, 0);
        firmaPane.setDisable(true);
        chbFirma.setOnAction(event -> enableFirma());

        pane.add(firmaPane, 1, 1, 1, pane.getRowCount()-1);

        //------------------------------------------------------------------------------

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 10);
        btnOpret.setOnAction(event -> {
            opretDeltagerAction();
            this.close();
        });
        GridPane.setMargin(btnOpret, new Insets(10, 0, 0, 0));

        Button btnAnnuller = new Button("Annuller");
        pane.add(btnAnnuller, 1, 10);
        btnAnnuller.setOnAction(event -> this.close());
        GridPane.setMargin(btnAnnuller, new Insets(10, 0, 0, 0));

    }

    private void checkForFirmaExists() {
        if (txfFirmaNavn.getText().isEmpty()) {
            txfFirmaCvr.setText("");
            txfFirmaTlfNr.setText("");
            return;
        }
        for (Firma firma : Controller.getFirmaer()) {
            if (firma.getNavn().equalsIgnoreCase(txfFirmaNavn.getText())) {
                txfFirmaCvr.setText(firma.getCvr());
                txfFirmaTlfNr.setText(firma.getTlfNr());
            }
        }
    }

    private void enableFirma() {
        if (chbFirma.isSelected()) {
            firmaPane.setDisable(false);
        }
        else {
            firmaPane.setDisable(true);
        }
    }

    private void opretDeltagerAction() {
        String navn = txfNavn.getText();
        String tlf = txfTlfNr.getText();
        String adresse = txfAdresse.getText();
        String by = txfBy.getText();
        String land = txfLand.getText();
        Firma firma = null;
        if (chbFirma.isSelected()) {
            for (Firma firma1 : Controller.getFirmaer()) {
                if (firma1.getNavn().equalsIgnoreCase(txfFirmaNavn.getText())) {
                    firma = firma1;
                }
            }
            if (firma == null) {
                firma = Controller.createFirma(txfFirmaNavn.getText(), txfFirmaCvr.getText(), txfTlfNr.getText());
            }
        }


        if (deltager != null) {
            Controller.updateDeltager(deltager, navn, tlf, adresse, by, land, firma);
        } else {
            Controller.createDeltager(navn, tlf, adresse, by, land, firma);
        }
    }
}
