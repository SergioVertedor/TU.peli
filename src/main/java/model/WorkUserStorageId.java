package model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class WorkUserStorageId implements java.io.Serializable {
  @Id
  @ManyToOne
  @JoinColumn(name = "work_id")
  private Work work;

  @Id
  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser user;

  @Id
  @ManyToOne
  @JoinColumn(name = "storage_id")
  private Storage storage;
}
