package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TVSearchResult {
    private long page;
    private TV[] results;
    private long totalPages;
    private long totalResults;
}
