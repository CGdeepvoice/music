package com.example.demo.pojo;

public class SongList {
    private Integer id;
    private String title;
    private String pic;
    private String style;
    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", style='" + style + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
