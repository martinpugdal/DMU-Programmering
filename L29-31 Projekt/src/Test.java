import application.model.Deltager;
import application.model.Tilmelding;
import gui.Application;
import storage.Storage;

public class Test {
    public static void main(String[] args) {
        Application.initStorage();
        for (Deltager deltager : Storage.getDeltagere()) {
            for (Tilmelding tilmelding : deltager.getTilmeldinger()) {
                System.out.print("Tilmelding for deltageren %s til konferencen \"%s\" vil koste %skr\n".formatted(deltager.getNavn(), tilmelding.getKonference().getNavn(), tilmelding.beregnPris()));
            }
        }
    }
}
