package enums;

import example.enums.Enums;

public class EnumerationsMain {

    public static void main(String[] args) {

        Enums.EyeColor message = Enums.EyeColor.newBuilder()
//                .setEyeColor(Enums.EyeColorEnum.BLUE)
                .setEyeColor(Enums.EyeColorEnum.BROWN).build();

        System.out.println(message);

    }


}
