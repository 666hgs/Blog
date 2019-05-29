package main.java.cn.pojo;

//地址表
public class Place {
    private Integer id;
    private String name;
    private Integer parentid;

    public Place() {
    }

    public Place(Integer id, String name, Integer parentid) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentid=" + parentid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
