package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class WatchProvider implements Serializable {
  @Id
  @Column(name = "id")
  private int providerId;

  @Column(name = "name")
  private String name;

  @Column(name = "logo_path")
  private String logoPath;

  @ManyToMany(mappedBy = "watchProviders")
  private Set<Work> works = new HashSet<>();
}
