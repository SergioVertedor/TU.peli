package utils;

import lombok.Getter;
import lombok.Setter;
import model.AppUser;

public class SessionHandler {
    @Getter
    @Setter
    private static AppUser appUser;
}
