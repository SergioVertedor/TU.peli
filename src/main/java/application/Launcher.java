package application;

import service.APIService;
import utils.ListStorage;

public class Launcher {
  public static void main(String[] args) {
    ListStorage.fillLists();
    App.main(args);
  }
}
