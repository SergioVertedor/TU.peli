package application;

import utils.ListStorage;

/** Clase que lanza la aplicación. */
public class Launcher {
  public static void main(String[] args) {
    ListStorage.fillLists();
    App.main(args);
  }
}
