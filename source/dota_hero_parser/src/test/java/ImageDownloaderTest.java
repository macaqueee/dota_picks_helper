import dota_advisor.model.Hero;
import dota_advisor.repository.HeroRepository;
import dota_buff_parser.Run;
import dota_buff_parser.config.AppConfigHolder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Run.class)
public class ImageDownloaderTest {

    private static final String HEROES_CONTAINER_CLASS_NAME = "hero";

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private AppConfigHolder appConfigHolder;

    private static String url = "https://www.dotabuff.com/assets/heroes";
    private static String imageFolder = "C:\\Users\\macaque\\development\\images\\";


    @Test
    public void imageDownloadTest() throws IOException {

        System.setProperty("http.agent","Mozilla");

        Document document = Jsoup.connect(appConfigHolder.getUrl()).get();

        Element body = document.body();
        Elements elementsByClass = body.getElementsByClass(HEROES_CONTAINER_CLASS_NAME);
        elementsByClass.forEach(el -> {
            String linkForDownload = parseUrl(el.attr("style"));
            String heroName = linkForDownload.substring(1, linkForDownload.indexOf('-'));
            String destinationFilePath = imageFolder + heroName + ".jpg";
            try {
                saveImage(url + linkForDownload, destinationFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        List<Hero> heroes = heroRepository.findAll();
    }

    private String parseUrl(String url) {
        return url.substring(url.lastIndexOf("/"), url.lastIndexOf(")"));
    }

    private static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

    @Test
    public void testDownloadImage() throws IOException {
        String link = "https://www.dotabuff.com/assets/heroes/juggernaut-5ace4f32c932a86b69173b854db3de00cd1425419f7c9ff0d824aad30b5ce1a8.jpg";
        saveImage(link, imageFolder + "jugger.jpg");
    }
}
