package code;


import code.controller.Controller;
import code.model.HabrCareerStrategy;
import code.model.Model;
import code.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model(new HabrCareerStrategy());
        Controller controller = new Controller(model);
        View view = new View(controller);
        view.showVacancies("junior");
    }
}
