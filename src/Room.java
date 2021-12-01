import java.util.regex.Pattern;
import java.util.*;

public class Room {
    private String name;
    private String script;
    private boolean reqKey;
    private boolean isEnd;
    private String image;
    private String code;
    private ArrayList<Room> rooms;
    private ArrayList<Key> keys;

    public Room() {
        name = "";
        script = "";
        isEnd = false;
        image = null;
        code = "";
        name = null;
        name = null;
    }
    
    public Room(String name, String script, boolean reqKey, boolean isEnd, String image, String code, ArrayList<Room> rooms, ArrayList<Key> keys) {
        this.setName(name);
        this.setScript(script);
        this.setReqKey(reqKey);
        this.setIsEnd(isEnd);
        this.setImage(image);
        this.setCode(code);
        this.rooms = new ArrayList<Room>();
        this.keys = new ArrayList<Key>();

        if (rooms != null) {
            for (Room room : rooms) {
                this.addRoom(room);
            }
        }

        if (keys != null) {
            for (Key key : keys) {
                this.addKey(key);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("setName in class Room: null input");
        if (name.equals(""))
            throw new IllegalArgumentException("setName in class Room: empty string");

        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public boolean getReqKey() {
        return reqKey;
    }

    public void setReqKey(boolean isLocked) {
        this.reqKey = isLocked;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public String getImage() {
        return image;
    }

    public String setImage(String path) {
        if (path == null || path.equals(""))
            return "image not found";

        String regexMac = "([\\w]:)?((/[\\S]+)|(/\"[\\w\\W]+\"))+.png";
        String regexWin = "([\\w]:)?((\\\\[\\w-.]+)|(\\\\\"[\\w\\s-.]+\"))+.png";

        if (!Pattern.matches(regexMac, path) && !Pattern.matches(regexWin, path) || path.contains(System.getProperty("line.separator")))
            throw new IllegalArgumentException("setImage in class Room: invalid file path");

        this.image = path;
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null && code.equals(""))
            this.code = null;
        else
            this.code = code;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        if (room == null)
            throw new IllegalArgumentException("addRoom in class Room: null input");

        rooms.add(room);
    }

    public void setRooms( ArrayList<Room> rooms ) {
        this.rooms = rooms;
    }

    public void delRoom(int index) {
        try {
            rooms.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("delRoom in class Room: index out of bounds");
        }
    }

    public ArrayList<Key> getKeys() {
        return keys;
    }

    public void addKey(Key key) {
        if (key == null)
            throw new IllegalArgumentException("addKey in class Room: null input");

        keys.add(key);
    }

    public void delKey(Key key) {
        if (keys.contains(key))
            keys.remove(key);
    }
}