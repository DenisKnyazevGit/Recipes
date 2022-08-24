package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipesController {
    private Recipe recipe;

    public RecipesController() {
    }

    @GetMapping("/api/recipe")
    public ResponseEntity getSeats() {
        ResponseEntity recipe = new ResponseEntity<>(this.recipe, null, HttpStatus.OK);

        return recipe;
    }

    @PostMapping("/api/recipe")
    public void postPurchase(@RequestBody Recipe recipe) {
        this.recipe = recipe;
    }
}