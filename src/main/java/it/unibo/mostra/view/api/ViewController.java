package it.unibo.mostra.view.api;
/**
 * Interface for the viewController.
 */
public interface ViewController {
    /**
     * Method that sets the Home view.
     */
    void setHomeView();

    void setAdminLoginView();

    void setDipendeteLoginView();
    
    void setMainView();

    void setRicercaView();

    void setBiglietteriaView();

    void setRecensioneView();

    void setAdminAdd();

    void setDipendenteTurni();
}
