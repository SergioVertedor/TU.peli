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
public class Company implements Serializable {
  @Id
  @Column(name = "id")
  private int idCompany;

  @Column(name = "name")
  private String companyName;

  @ManyToMany(mappedBy = "campanies")
  private Set<Work> works = new HashSet<>();
}
