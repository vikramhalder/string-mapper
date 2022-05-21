import com.github.com.vikramhalder.stringmapper.StringMapper;

public class Test {
    static String jsonString = "" +
            "{" +
            " \"libraryName\": \"My Library\",\n" +
            "  \"musics\": [\n" +
            "    {\n" +
            "      \"artistName\": \"Aaron\",\n" +
            "      \"songName\": \"Beautiful\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"artistName\": \"Britney\",\n" +
            "      \"songName\": \"Oops I did It Again\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"artistName\": \"Britney\",\n" +
            "      \"songName\": \"Stronger\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String... args) {
        var map = new StringMapper(jsonString).map();
        String libraryName = map.getString("libraryName");
        String songName = map.getMapList("musics").get(0).getString("songName");
        String notFound = map.getMap("11").getMap("22").getString("obj");
        System.out.println(libraryName);
        System.out.println(songName);
        System.out.println(notFound);
    }
}
