package code.model;

import code.Vacancy;

import java.util.List;

public class Model {
    private Strategy strategy;

    public Model(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getAllVacancies(String searchString) {
        return strategy.getVacancies(searchString);
    }

}
