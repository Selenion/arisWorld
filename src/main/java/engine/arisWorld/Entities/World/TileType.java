package engine.arisWorld.Entities.World;

import lombok.Getter;
import lombok.Setter;

public class TileType {

    @Getter
    @Setter
    String tiletype;

    @Getter
    @Setter
    int weight;

    public TileType(String tiletype, int weight) {
        this.tiletype = tiletype;
        this.weight = weight;
    }
}
