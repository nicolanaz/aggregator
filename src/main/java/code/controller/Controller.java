package code.controller;

import code.Vacancy;
import code.model.Model;

import java.util.List;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public List<Vacancy> onShowVacancies(String searchString) {
        return model.getAllVacancies(searchString);
    }
}
