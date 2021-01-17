package engine.arisWorld.Controllers;

import engine.arisWorld.Entities.World.*;
import engine.arisWorld.Repository.TileRepository;
import engine.arisWorld.Services.Generator;
import engine.arisWorld.Services.TileService;
import engine.arisWorld.Services.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class TileController {

    @Autowired
    private TileRepository tileRepository;

    @Autowired
    private Generator generator;

    @Autowired
    private Viewer viewer;

    @Autowired
    private TileService tileService;

    @GetMapping(path = "/api/getTileByCoordinates/{coordinates_x},{coordinates_y}", produces = "application/json")
    public Object getTileByCoordinates(@PathVariable int coordinates_x, @PathVariable int coordinates_y) {
        if (tileRepository.existsById(new TileId(coordinates_x, coordinates_y))) {
            return tileRepository.findById(new TileId(coordinates_x, coordinates_y)).orElseThrow();
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/api/makeTile", consumes = "application/json")
    public Object makeTile(@Valid @RequestBody Tile tile) {
        tile = tileRepository.save(tile);
        return tile;
    }

    @GetMapping(path = "/api/getTilesAroundByCoordinates/{coordinates_x},{coordinates_y}", produces = "application/json")
    public Object getTilesAroundByCoordinates(@PathVariable int coordinates_x, @PathVariable int coordinates_y) {
        ArrayList<Tile> tiles = new ArrayList<>();
        int[] x = {-1, 0, 1};
        int[] y = {-1, 0, 1};

        for (int i : x) {
            for (int j : y) {
                tiles.add(tileRepository.findById(new TileId(coordinates_x + i, coordinates_y + j))
                        .orElse(new Tile(new TileId(coordinates_x + i, coordinates_y + j), "NoTile", null)));
            }
        }
        return tiles;
    }

    @Transactional
    @PostMapping(path = "/api/massMapUpdate", consumes = "application/json")
    public Object massMapUpdate(@Valid @RequestBody ArrayList<Tile> tiles) {
        tileRepository.saveAll(tiles);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "api/generateMap", consumes = "application/json")
    public Object generateMap(@RequestBody InputGenWrapper inputGenWrapper){
        generator.generateMap(inputGenWrapper);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/api/printWorld", produces = "application/json")
    public String printWorld(){
        return viewer.showMap();
    }

    @GetMapping(path = "/api/countX", produces = "application/json")
    public int countx(){
        return tileService.getcountrows();
    }

}
