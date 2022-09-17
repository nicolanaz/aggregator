package code.view;

import code.Vacancy;
import code.controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void showVacancies(String searchString) {
        for (Vacancy vacancy : controller.onShowVacancies(searchString)) {
            System.out.println(vacancy);
        }
    }
}
