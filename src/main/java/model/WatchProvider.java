package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WatchProvider implements java.io.Serializable {
	private int providerId;
	private String name;
	private String logoPath;
}
