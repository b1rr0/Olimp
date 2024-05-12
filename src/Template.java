import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Template {

    // javac Template.java && java Template A LeetCoodeExample.B
    public static void main(String[] args) throws IOException {
        args=new String[]{"E"};
        generation(args);
    }

    private static void generation(String[] args) throws IOException {
        String templateName = "Templ1";
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
        String nameOfDir = "sol_" + dateFormat.format(new Date());
        String nameOfProject = "Solution_" + Math.abs(random.nextInt() % 1000);
        if (args.length > 0) {
            nameOfProject = args[0];
        }
        if (args.length == 2) {
            nameOfDir = args[1];
        }
        System.out.println(nameOfDir);
        String pathS = "src/" + nameOfDir + "/";
        pathS = new File(pathS).getAbsolutePath();
        pathS = pathS.replace("/src/src/", "/src/");
        Path path = Paths.get(pathS);
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }

        String s = "";
        pathS = "src/templates/" + templateName + ".java";
        pathS = new File(pathS).getAbsolutePath();
        pathS = pathS.replace("/src/src/", "/src/");
        try (FileReader reader = new FileReader(pathS)) {
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            s = stringBuilder.toString();
        }
        s = s.replace(templateName, nameOfProject);
        s = s.replace("templates", nameOfDir);

        File file = new File(path + "/" + nameOfProject + ".java");
        if (!file.exists()) {
            file.createNewFile();
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(s);
                writer.flush();
            }
        }
        file = new File(path + "/" + "input.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
