package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkStorage {
	private int idWorkStorage;
	private String storageName;
	private String storageType;
}
