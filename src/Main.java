import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;
        ReadWriteFileUtils.txtToMarkDown(args[0],args[1]);


    }
}
