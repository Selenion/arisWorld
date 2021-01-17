package engine.arisWorld.Repository;

import engine.arisWorld.Entities.World.Tile;
import engine.arisWorld.Entities.World.TileId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TileRepository extends CrudRepository<Tile, TileId> {

    @Query("select count(coordinates_x) from Tile where coordinates_y = 0")
    int gettilecount_y();

}
