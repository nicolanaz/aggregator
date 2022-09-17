package code.model;

import code.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HabrCareerStrategy implements Strategy {
    private static final String URL_FORMAT = "https://career.habr.com/vacancies?page=%d&q=java+%s&type=all";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        int page = 1;
        try {
            do {
                Document document = getDocument(page, searchString);
                Elements elements = document.getElementsByClass("vacancy-card");

                if (elements.isEmpty()) break;

                for (Element element : elements) {
                    String siteName = "https://career.habr.com";
                    Elements title = element.getElementsByClass("vacancy-card__title-link");
                    Elements company = element.getElementsByClass("vacancy-card__company-title");
                    String url = title.get(0).getElementsByTag("a").attr("href");
                    Elements salary = element.getElementsByClass("basic-salary");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title.get(0).text());
                    vacancy.setCompanyName(company.get(0).text());
                    vacancy.setUrl(siteName + url);
                    vacancy.setSalary(salary.get(0).text());

                    vacancies.add(vacancy);
                }
                page++;
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vacancies;
    }

    private Document getDocument(int page, String searchString) {
        try {
            Document document = Jsoup.connect(String.format(URL_FORMAT, page, searchString)).get();
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
