package it.unibo.mostra.view;

import it.unibo.mostra.view.api.ViewController;

public class ViewControllerImpl implements ViewController {

    private final Stage stage;
    private final SceneFactory sceneFactory;

    public ViewControllerImpl(Stage stage) {
        this.stage = stage;
        this.sceneFactory = new SceneFactoryImpl();
    }
    @Override
    public void setHomeView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHomeView'");
    }

    @Override
    public void setAdminLoginView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAdminLoginView'");
    }

    @Override
    public void setDipendeteLoginView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDipendeteLoginView'");
    }

    @Override
    public void setMainView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMainView'");
    }

    @Override
    public void setRicercaView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRicercaView'");
    }

    @Override
    public void setBiglietteriaView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBiglietteriaView'");
    }

    @Override
    public void setRecensioneView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRecensioneView'");
    }

    @Override
    public void setAdminAdd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAdminAdd'");
    }

    @Override
    public void setDipendenteTurni() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDipendenteTurni'");
    }

    
    
}
