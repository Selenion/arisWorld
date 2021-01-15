package engine.arisWorld.Controllers;

import engine.arisWorld.Entities.World.Tile;
import engine.arisWorld.Entities.World.TileId;
import engine.arisWorld.Repository.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TileController {

    @Autowired
    private TileRepository tileRepository;

    @GetMapping(path = "/api/getTileByCoordinates/{coordinates_x},{coordinates_y}", produces = "application/json")
    public Object getTileByCoordinates(@PathVariable int coordinates_x, @PathVariable int coordinates_y){
        if (tileRepository.existsById(new TileId(coordinates_x,coordinates_y))){
            Tile tile = tileRepository.findById(new TileId(coordinates_x,coordinates_y)).orElseThrow();
            return tile;
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/api/makeTile", consumes = "application/json")
    public Object makeTile (@Valid @RequestBody Tile tile){
        tile = tileRepository.save(tile);
        return tile;
    }

}
