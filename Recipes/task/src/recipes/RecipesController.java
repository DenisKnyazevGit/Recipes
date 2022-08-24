package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipesController {
    private RecipeBook recipeBook;

    public RecipesController() {
        this.recipeBook = new RecipeBook();
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity addNewRecipe(@RequestBody Recipe recipe) {
        int id = recipeBook.addRecipe(recipe);
        return new ResponseEntity<>(new AddNewRecipeResponse(id), null, HttpStatus.OK);
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity getRecipeById(@PathVariable int id) {
        Recipe recipe;
        try {
            recipe = this.recipeBook.getRecipeById(id);
        } catch (Exception e) {
            recipe = null;
        }

        if (recipe != null) {
            return new ResponseEntity<>(recipe, null, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }
}