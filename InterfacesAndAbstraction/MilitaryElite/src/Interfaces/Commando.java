package Interfaces;

import java.util.Collection;

public interface Commando {
    Collection<Mission> getMissions();
    void completeMission();
}
