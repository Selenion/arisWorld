package engine.arisWorld.Entities.World;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class TileId implements Serializable {

    @NotNull
    @NotBlank
    @Getter
    @Setter
    public int coordinates_x;

    @NotNull
    @NotBlank
    @Getter
    @Setter
    public int coordinates_y;

    public TileId(int coordinates_x, int coordinates_y) {
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
    }

    public TileId() {

    }
}
