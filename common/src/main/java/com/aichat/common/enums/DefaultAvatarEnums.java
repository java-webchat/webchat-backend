package com.aichat.common.enums;

/**
 * Created by zhengpeng on 2018/6/26.
 */
public enum DefaultAvatarEnums {


    DEFAULT_1("http://i1.umei.cc/uploads/tu/201712/10032/f499e94760.jpg","",1),
    DEFAULT_2("http://i1.umei.cc/uploads/tu/201711/9999/rn34c9be61cf.jpg","",2),
    DEFAULT_3("http://i1.umei.cc/uploads/tu/201711/10102/5ad0d16ebf.jpg","",3),
    DEFAULT_4("http://i1.umei.cc/uploads/tu/201708/10236/b7892f0ea31.jpg","",4),
    DEFAULT_5("http://i1.umei.cc/uploads/tu/201711/10102/5ad0d16ebf.jpg","",5),
    DEFAULT_6("http://i1.umei.cc/uploads/tu/201708/10277/91db9bd9db2.jpg","",6),
    DEFAULT_7("http://i1.umei.cc/uploads/tu/201711/9999/rn8bcb68bcf1.jpg","",7),
    DEFAULT_8("http://i1.umei.cc/uploads/tu/201608/56/ns5vlgq0ohe.jpg","",8),
    ;


    public static String getSrcById(Integer id){
        for (DefaultAvatarEnums c : DefaultAvatarEnums.values()) {
            if (id.equals(c.getId())) {
                return c.src;
            }
        }
        return null;
    }

    private  String src;
    private  String desc;
    private  Integer id;



    DefaultAvatarEnums(String src, String desc, Integer id) {
        this.src = src;
        this.desc = desc;
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
