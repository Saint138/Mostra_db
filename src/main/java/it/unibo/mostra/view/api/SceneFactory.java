package it.unibo.mostra.view.api;

public interface SceneFactory {
    
    Scene getHomescene(ViewController view);

    Scene getAdminLoginScene(ViewController view);

    Scene getDipendeteLoginScene(ViewController view);

    Scene getMainScene(ViewController view);

    Scene getRicercaScene(ViewController view);

    Scene getBiglietteriaScene(ViewController view);

    Scene getRecensioneScene(ViewController view);

    Scene getAdminAddScene(ViewController view);

    Scene getDipendenteTurniScene(ViewController view);
}
