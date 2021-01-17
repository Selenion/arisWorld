package engine.arisWorld.Entities.World;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Tile {

    @NotNull
    @Getter
    @Setter
    @EmbeddedId
    TileId tileId;

    @NotBlank
    @NotNull
    @Getter
    @Setter
    String tileType;

    @ElementCollection
    @Getter
    @Setter
    List<String> contentList;

    public Tile(TileId tileId, @NotBlank String tileType, List<String> contentList) {
        this.tileId = tileId;
        this.tileType = tileType;
        this.contentList = contentList;
    }

    public Tile() {

    }
}
