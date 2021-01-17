package engine.arisWorld.Services;

import engine.arisWorld.Entities.World.Tile;
import engine.arisWorld.Repository.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;


@Service
public class Viewer {

    @Autowired
    TileRepository tileRepository;

    @Autowired
    TileService tileService;

    public String showMap(){
        LinkedList<StringBuilder> listofstrings = new LinkedList<>();
        int chars_in_row = tileService.getcountrows();

        StringBuilder output = new StringBuilder();
        int i=0;
        for (Tile t: tileRepository.findAll()
             ) {
            switch (t.getTileType()){
                case "City": output.append("C");
                break;
                case "Forest": output.append("F");
                break;
                case "Plains": output.append("P");
                break;
                case "Ruins": output.append("R");
                break;
                case "Nuclear desert": output.append("N");
                break;
                default: output.append("?");
                break;
            }
            i = i + 1;
            if (i >= chars_in_row){
                i = 0;
                output.append("\n");
            }
        }
        return output.toString();
    }
}
