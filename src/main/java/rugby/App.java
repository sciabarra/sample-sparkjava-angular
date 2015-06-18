package rugby;

import spark.Response;
import spark.utils.IOUtils;

import java.io.*;

import static spark.Spark.get;

/**
 * Created by msciab on 16/06/15.
 */
public class App {

    private static String base = System.getProperty("user.dir");
    private static File htmlBase = new File(base, "src/main/app/html".replace('/', File.separatorChar));
    private static File cssBase = new File(base, "src/main/app/css".replace('/', File.separatorChar));
    private static File jsBase = new File(base, "src/main/app/js".replace('/', File.separatorChar));
    private static File imgBase = new File(base, "src/main/app/img".replace('/', File.separatorChar));

    public static byte[] readFile(File base, String path) {
        try {
            File tgt = new File(base, path.replace('/', File.separatorChar));
            FileInputStream fis = new FileInputStream(tgt);
            return IOUtils.toByteArray(fis);
            //IOUtils.copy(fis, res.raw().getOutputStream());
        } catch (Exception ex) {
            CharArrayWriter caw = new CharArrayWriter();
            ex.printStackTrace(new PrintWriter(caw));
            return caw.toString().getBytes();
        }

    }

    public static byte[] fileWithType(Response res, File base, String path, String type) {
        res.type(type);
        return readFile(base, path);
    }

    public static byte[] concatWithType(Response res, File base, String index, String type) {
        res.type(type);
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(base, index)));
            String path = br.readLine();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (path != null) {
                baos.write(readFile(base, path));
                baos.write('\n');
                baos.write('\n');
                path = br.readLine();
            }
            return baos.toByteArray();
        } catch (Exception e) {
            CharArrayWriter caw = new CharArrayWriter();
            e.printStackTrace(new PrintWriter(caw));
            return caw.toString().getBytes();
        }
    }

    public static String imgType(String path) {
        if (path.endsWith(".gif"))
            return "image/gif";
        if (path.endsWith(".jpg"))
            return "image/jpeg";
        if (path.endsWith(".png"))
            return "image/png";
        return "application/octet-stream";
    }

    public static void routes() {

        get("/", (req, res) -> {
            res.redirect("/html/index.html");
            return "";
        });

        get("/html/*",
                (req, res) -> fileWithType(res, htmlBase, req.splat()[0], "text/html"));
        get("/css/*",
                (req, res) -> fileWithType(res, cssBase, req.splat()[0], "text/css"));
        get("/img/*",
                (req, res) -> fileWithType(res, imgBase, req.splat()[0], imgType(req.splat()[0])));
        get("/js/*",
                (req, res) -> {
                    String path = req.splat()[0];
                    if (path.endsWith(".txt"))
                        return concatWithType(res, jsBase, path, "text/javascript");
                    else
                        return fileWithType(res, jsBase, path, "text/javascript");
                });
    }
}
