package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "almacenadas")
public class Store {
    private Work work;
    private AppUser user;
    private WorkStorage storage;
    @Column(name = "movie_location")
    private String movieLocation;
}
