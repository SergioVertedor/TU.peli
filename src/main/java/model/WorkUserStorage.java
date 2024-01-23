package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "work_user_storage")
public class WorkUserStorage implements java.io.Serializable {

  @EmbeddedId private WorkUserStorageId id;

  @Column(name = "valoracion")
  private double valoracion;

  @Column(name = "comentario")
  private String comentario;

  @Column(name = "en_lista")
  private boolean enLista;

  @Column(name = "en_favoritos")
  private boolean enFavoritos;
}
