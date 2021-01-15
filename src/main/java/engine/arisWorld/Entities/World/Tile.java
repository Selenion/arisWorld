package engine.arisWorld.Entities.World;

import com.sun.istack.NotNull;
import engine.arisWorld.Entities.Items.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Tile {

    @NotNull
    @NotBlank
    @Getter
    @Setter
    @EmbeddedId
    TileId tileId;

    @NotBlank
    @NotNull
    String tileType;

    @NotBlank
    @NotNull
    @ElementCollection
    List<String> ContentList;

    public Tile(TileId tileId, String tileType, List<String> contentList) {
        this.tileId = tileId;
        this.tileType = tileType;
        ContentList = contentList;
    }

    public Tile() {

    }
}
