package model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
}
