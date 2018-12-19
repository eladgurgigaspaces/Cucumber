package hellocucumber;

import com.gigaspaces.annotation.pojo.SpaceId;

public class MyData {

    String str;

    public MyData() {}

    public MyData(String input) {
        if (input.equals("Hello")) {
            this.str = "World";
        } else {
            this.str = input;
        }
    }

    @SpaceId
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
