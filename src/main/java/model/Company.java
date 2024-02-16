package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la tabla "company" en la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company")
public class Company implements Serializable {
  @Id
  @Column(name = "id")
  private int idCompany;

  @Column(name = "name")
  private String companyName;

  @ManyToMany(mappedBy = "companies")
  private Set<Work> works = new HashSet<>();
}
