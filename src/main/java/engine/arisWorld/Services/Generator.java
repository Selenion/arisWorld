package engine.arisWorld.Services;

import engine.arisWorld.Entities.World.InputGenWrapper;
import engine.arisWorld.Entities.World.Tile;
import engine.arisWorld.Entities.World.TileId;
import engine.arisWorld.Entities.World.TileType;
import engine.arisWorld.Repository.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class Generator {

    @Autowired
    private TileRepository tileRepository;

    public Generator() {
    }

    public void generateMap (InputGenWrapper inputGenWrapper){

        LinkedList<Tile> tiles = new LinkedList<>();

        int totalweight = 0;

        for (TileType type: inputGenWrapper.getTiletypes()
             ) {
            totalweight = totalweight + type.getWeight();
        }


        for (int i = -(inputGenWrapper.getSize_x()/2); i<= inputGenWrapper.getSize_x()/2; i++){
            for (int j = -(inputGenWrapper.getSize_y()/2); j<= inputGenWrapper.getSize_y()/2; j++){
                int idx = 0;
                for (double r = Math.random() * totalweight; idx < inputGenWrapper.getTiletypes().length - 1; ++idx) {
                    r -= inputGenWrapper.getTiletypes()[idx].getWeight();
                    if (r <= 0.0) break;
                }
                TileType randomType = inputGenWrapper.getTiletypes()[idx];
                tiles.add(new Tile(new TileId(i,j), randomType.getTiletype(), null));
            }
        }
        tileRepository.saveAll(tiles);

    }

}