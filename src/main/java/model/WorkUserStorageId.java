package model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Clase que representa la clave primaria compuesta de la tabla work_user_storage
 */
@Embeddable
public class WorkUserStorageId implements java.io.Serializable {
  @ManyToOne
  @JoinColumn(name = "work_id")
  private Work work;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser user;

  @ManyToOne
  @JoinColumn(name = "storage_id")
  private Storage storage;

  public WorkUserStorageId(Work work, AppUser user, Storage storage) {
    this.work = work;
    this.user = user;
    this.storage = storage;
  }
  public WorkUserStorageId() {
  }
}
