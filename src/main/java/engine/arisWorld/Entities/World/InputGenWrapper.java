package engine.arisWorld.Entities.World;

import lombok.Getter;
import lombok.Setter;

public class InputGenWrapper {

    @Getter
    @Setter
    TileType[] tiletypes;

    @Getter
    @Setter
    int size_x;

    @Getter
    @Setter
    int size_y;

    public InputGenWrapper(TileType[] tiletypes, int size_x, int size_y) {
        this.tiletypes = tiletypes;
        this.size_x = size_x;
        this.size_y = size_y;
    }
}
