package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "almacen")
@NoArgsConstructor
@Getter
public class WorkStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idWorkStorage;
    @Column(name = "name")
    private String storageName;
    @Column(name = "type")
    private String storageType;

    public WorkStorage(String storageName, String storageType) {
        this.storageName = storageName;
        this.storageType = storageType;
    }
}

