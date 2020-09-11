package util;

/**
 * @Author long
 * @Date 2020/1/16 16:11
 * @Title
 * @Description //TODO
 **/

public class Activity {
    private String memory;
    private String name;
    private String id;

    public String getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "memory='" + memory + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Activity(String memory, String name, String id) {
        this.memory = memory;
        this.name = name;
        this.id = id;
    }
}
