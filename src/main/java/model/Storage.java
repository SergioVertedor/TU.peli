package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "almacen")
@NoArgsConstructor
@Getter
public class Storage implements java.io.Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int idWorkStorage;

  @Column(name = "name")
  private String storageName;

  @Column(name = "type")
  private String storageType;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private AppUser user;

  @OneToMany(mappedBy = "id.storage", cascade = CascadeType.ALL)
  private Set<WorkUserStorage> workUserStorages = new HashSet<>();

  public Storage(String storageName, String storageType) {
    this.storageName = storageName;
    this.storageType = storageType;
  }
}
