import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadWriteFileUtils {
    private static SolutionLeetCode SetClass(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        SolutionLeetCode krutoy = new SolutionLeetCode();
        int superkrutoy;
        StringBuilder builder = new StringBuilder();
        krutoy.setTitle(reader.readLine());
        krutoy.setLink(reader.readLine());
        superkrutoy = reader.read();
        while (superkrutoy != -1) {
            builder.append((char) superkrutoy);
            superkrutoy = reader.read();
        }
        krutoy.setSourcecode(builder.toString());
        return krutoy;

    }

    private static void emptyMd(SolutionLeetCode cl, File md) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(md, true));
        writer.write("+ [" + cl.getTitle() + "](#" + cl.getLink().substring(30, cl.getLink().length() - 1) + ")\n");
        writer.write("## " + cl.getTitle() + "\n");
        writer.write(cl.getLink() + "\n");
        writer.write("```java\n");
        writer.write(cl.getSourcecode());
        writer.write("\n```\n");
        writer.close();
    }

    private static int EndOfTitles(File file) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(file.getPath()));
        int output = 1;
        for (; output < lines.size(); output++) {
            if (!lines.get(output).startsWith("+ [")) break;
        }
        return output;
    }

    private static void Writeinmd(SolutionLeetCode c, File md) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(md.getPath()));
        lines.add(EndOfTitles(md), "+ [" + c.getTitle() + "](#" + c.getLink().substring(30, c.getLink().length() - 1) + ")\n");
        lines.add("## " + c.getTitle());
        lines.add(c.getLink());
        lines.add("```java");
        lines.add(c.getSourcecode());
        lines.add("\n```");
        BufferedWriter writer = new BufferedWriter(new FileWriter(md));
        for (String s : lines) {
            writer.write(s + "\n");
        }
        writer.close();
    }

    public static void txtToMarkDown(String txtPath, String mdPath) throws IOException {
        File Megakrutoy = new File(txtPath);
        SolutionLeetCode solution = SetClass(Megakrutoy);
        File Ultrakrutoy = new File(mdPath);
        if (Files.readAllLines(Path.of(mdPath)).size() == 1) {
            emptyMd(solution, Ultrakrutoy);
        } else Writeinmd(solution, Ultrakrutoy);
    }

}
