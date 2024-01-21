package model;

import connector.HibernateUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "almacenadas")
public class Store {

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
  private WorkStorage storage;

  @Column(name = "movie_location")
  private String movieLocation;
}
