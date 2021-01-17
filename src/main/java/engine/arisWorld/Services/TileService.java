package engine.arisWorld.Services;

import engine.arisWorld.Repository.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TileService {

    @Autowired
    private TileRepository tileRepository;

    public int getcountrows (){
        return tileRepository.gettilecount_y();
    }

}
