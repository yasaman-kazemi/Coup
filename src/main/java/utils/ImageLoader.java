package utils;

import java.util.HashMap;

public class ImageLoader {
    private static final HashMap<String, String> imageAddressMap = new HashMap<>();

    private static void load() {
        if (imageAddressMap.isEmpty()) {
            imageAddressMap.put("cautiousKiller", "src/main/resources/avatars/cautiousKillerAvatar.jpg");
            imageAddressMap.put("couper", "src/main/resources/avatars/couperAvatar.jpg");
            imageAddressMap.put("mystery", "src/main/resources/avatars/mysteryAvatar.jpg");
            imageAddressMap.put("paranoid", "src/main/resources/avatars/paranoidAvatar.jpg");
            imageAddressMap.put("coin", "src/main/resources/coin.jpg");
            imageAddressMap.put("ambassador", "src/main/resources/cards/Ambassador.jpg");
            imageAddressMap.put("assassin", "src/main/resources/cards/Assassin.jpg");
            imageAddressMap.put("commander", "src/main/resources/cards/Commander.jpg");
            imageAddressMap.put("duke", "src/main/resources/cards/Duke.jpg");
            imageAddressMap.put("princes", "src/main/resources/cards/Princes.jpg");
        }
    }

    public static String getCautiousKiller() {
        load();
        return imageAddressMap.get("cautiousKiller");
    }

    public static String getCouper() {
        load();
        return imageAddressMap.get("couper");
    }

    public static String getMystery() {
        load();
        return imageAddressMap.get("mystery");
    }

    public static String getParanoid() {
        load();
        return imageAddressMap.get("paranoid");
    }

    public static String getCoin() {
        load();
        return imageAddressMap.get("coin");
    }

    public static String getAmbassador() {
        load();
        return imageAddressMap.get("ambassador");
    }

    public static String getAssassin() {
        load();
        return imageAddressMap.get("assassin");
    }

    public static String getCommander() {
        load();
        return imageAddressMap.get("commander");
    }

    public static String getDuke() {
        load();
        return imageAddressMap.get("duke");
    }

    public static String getPrinces() {
        load();
        return imageAddressMap.get("princes");
    }
}
