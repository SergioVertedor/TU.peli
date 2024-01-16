module org.example.ddiud02javafxjsontest {
  // Para que funcione el módulo, hay que añadir las dependencias de la aplicación
  requires javafx.controls;
  requires javafx.fxml;
  // static hace que el módulo sea opcional, si no se usa, no se incluye en el módulo
  requires static lombok;
  requires okhttp3;
  requires com.google.gson;
  requires javafx.web;
  requires jakarta.persistence;
  requires org.hibernate.orm.core;
  requires java.naming;

  // Exports hace que el módulo sea visible para otros módulos, a diferencia de opens, no permite
  // el acceso a los elementos internos del módulo
  exports application;
  exports controllers;

  // Opens hace que el módulo sea visible para otros módulos, a diferencia de exports, también
  // permite el acceso a los elementos internos del módulo
  opens images.logo;
  opens controllers to
      javafx.fxml;
  opens application to
      javafx.fxml;
  opens model to org.hibernate.orm.core;
}
