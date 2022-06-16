package utils;

import java.util.HashMap;

public class ImageLoader {
    private static final HashMap<String, String> imageAddressMap = new HashMap<>();

    private static void load() {
        if (imageAddressMap.isEmpty()) {
            imageAddressMap.put("tempAvatar", "src/main/resources/tempAvatar.jpg");

            imageAddressMap.put("startCautiousKiller", "src/main/resources/startAvatars/cautiousKiller.jpg");
            imageAddressMap.put("startCouper", "src/main/resources/startAvatars/couper.jpg");
            imageAddressMap.put("startMystery", "src/main/resources/startAvatars/mystery.jpg");
            imageAddressMap.put("startParanoid", "src/main/resources/startAvatars/paranoid.jpg");

            imageAddressMap.put("upCautiousKiller", "src/main/resources/avatars/upAvatars/cautiousKiller.jpg");
            imageAddressMap.put("upCouper", "src/main/resources/avatars/upAvatars/couper.jpg");
            imageAddressMap.put("upMystery", "src/main/resources/avatars/upAvatars/mystery.jpg");
            imageAddressMap.put("upParanoid", "src/main/resources/avatars/upAvatars/paranoid.jpg");

            imageAddressMap.put("leftCautiousKiller", "src/main/resources/avatars/leftAvatars/cautiousKiller.jpg");
            imageAddressMap.put("leftCouper", "src/main/resources/avatars/leftAvatars/couper.jpg");
            imageAddressMap.put("leftMystery", "src/main/resources/avatars/leftAvatars/mystery.jpg");
            imageAddressMap.put("leftParanoid", "src/main/resources/avatars/leftAvatars/paranoid.jpg");

            imageAddressMap.put("rightCautiousKiller", "src/main/resources/avatars/rightAvatars/cautiousKiller.jpg");
            imageAddressMap.put("rightCouper", "src/main/resources/avatars/rightAvatars/couper.jpg");
            imageAddressMap.put("rightMystery", "src/main/resources/avatars/rightAvatars/mystery.jpg");
            imageAddressMap.put("rightParanoid", "src/main/resources/avatars/rightAvatars/paranoid.jpg");

            imageAddressMap.put("coin", "src/main/resources/icons8-coins-64.png");

            imageAddressMap.put("ambassador", "src/main/resources/cards/Ambassador.jpg");
            imageAddressMap.put("assassin", "src/main/resources/cards/Assassin.jpg");
            imageAddressMap.put("commander", "src/main/resources/cards/Commander.jpg");
            imageAddressMap.put("duke", "src/main/resources/cards/Duke.jpg");
            imageAddressMap.put("princes", "src/main/resources/cards/Princes.jpg");

            imageAddressMap.put("ambassadorRight", "src/main/resources/cards/AmbassadorRight.jpg");
            imageAddressMap.put("assassinRight", "src/main/resources/cards/AssassinRight.jpg");
            imageAddressMap.put("commanderRight", "src/main/resources/cards/CommanderRight.jpg");
            imageAddressMap.put("dukeRight", "src/main/resources/cards/DukeRight.jpg");
            imageAddressMap.put("princesRight", "src/main/resources/cards/PrincesRight.jpg");

            imageAddressMap.put("ambassadorLeft", "src/main/resources/cards/AmbassadorLeft.jpg");
            imageAddressMap.put("assassinLeft", "src/main/resources/cards/AssassinLeft.jpg");
            imageAddressMap.put("commanderLeft", "src/main/resources/cards/CommanderLeft.jpg");
            imageAddressMap.put("dukeLeft", "src/main/resources/cards/DukeLeft.jpg");
            imageAddressMap.put("princesLeft", "src/main/resources/cards/PrincesLeft.jpg");

            imageAddressMap.put("ambassadorUp", "src/main/resources/cards/AmbassadorUp.jpg");
            imageAddressMap.put("assassinUp", "src/main/resources/cards/AssassinUp.jpg");
            imageAddressMap.put("commanderUp", "src/main/resources/cards/CommanderUp.jpg");
            imageAddressMap.put("dukeUp", "src/main/resources/cards/DukeUp.jpg");
            imageAddressMap.put("princesUp", "src/main/resources/cards/PrincesUp.jpg");

            imageAddressMap.put("behindCard", "src/main/resources/cards/behindCard.jpg");
            imageAddressMap.put("leftCard", "src/main/resources/cards/leftCard.jpg");
            imageAddressMap.put("upCard", "src/main/resources/cards/upCard.jpg");
            imageAddressMap.put("rightCard", "src/main/resources/cards/rightCard.jpg");

            imageAddressMap.put("backGround", "src/main/resources/backGround.jpg");
        }
    }

    public static String getStartCautiousKiller() {
        load();
        return imageAddressMap.get("startCautiousKiller");
    }

    public static String getStartCouper() {
        load();
        return imageAddressMap.get("startCouper");
    }

    public static String getStartMystery() {
        load();
        return imageAddressMap.get("startMystery");
    }

    public static String getStartParanoid() {
        load();
        return imageAddressMap.get("startParanoid");
    }

    public static String getUpCautiousKiller() {
        load();
        return imageAddressMap.get("upCautiousKiller");
    }

    public static String getUpCouper() {
        load();
        return imageAddressMap.get("upCouper");
    }

    public static String getUpMystery() {
        load();
        return imageAddressMap.get("upMystery");
    }

    public static String getUpParanoid() {
        load();
        return imageAddressMap.get("upParanoid");
    }

    public static String getLeftCautiousKiller() {
        load();
        return imageAddressMap.get("leftCautiousKiller");
    }

    public static String getLeftCouper() {
        load();
        return imageAddressMap.get("leftCouper");
    }

    public static String getLeftMystery() {
        load();
        return imageAddressMap.get("leftMystery");
    }

    public static String getLeftParanoid() {
        load();
        return imageAddressMap.get("leftParanoid");
    }

    public static String getRightCautiousKiller() {
        load();
        return imageAddressMap.get("rightCautiousKiller");
    }

    public static String getRightCouper() {
        load();
        return imageAddressMap.get("rightCouper");
    }

    public static String getRightMystery() {
        load();
        return imageAddressMap.get("rightMystery");
    }

    public static String getRightParanoid() {
        load();
        return imageAddressMap.get("rightParanoid");
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

    public static String getPrincess() {
        load();
        return imageAddressMap.get("princes");
    }

    public static String getAmbassadorRight() {
        load();
        return imageAddressMap.get("ambassadorRight");
    }

    public static String getAssassinRight() {
        load();
        return imageAddressMap.get("assassinRight");
    }

    public static String getCommanderRight() {
        load();
        return imageAddressMap.get("commanderRight");
    }

    public static String getDukeRight() {
        load();
        return imageAddressMap.get("dukeRight");
    }

    public static String getPrincesRight() {
        load();
        return imageAddressMap.get("princesRight");
    }

    public static String getAmbassadorLeft() {
        load();
        return imageAddressMap.get("ambassadorLeft");
    }

    public static String getAssassinLeft() {
        load();
        return imageAddressMap.get("assassinLeft");
    }

    public static String getCommanderLeft() {
        load();
        return imageAddressMap.get("commanderLeft");
    }

    public static String getDukeLeft() {
        load();
        return imageAddressMap.get("dukeLeft");
    }

    public static String getPrincesLeft() {
        load();
        return imageAddressMap.get("princesLeft");
    }

    public static String getAmbassadorUp() {
        load();
        return imageAddressMap.get("ambassadorUp");
    }

    public static String getAssassinUp() {
        load();
        return imageAddressMap.get("assassinUp");
    }

    public static String getCommanderUp() {
        load();
        return imageAddressMap.get("commanderUp");
    }

    public static String getDukeUp() {
        load();
        return imageAddressMap.get("dukeUp");
    }

    public static String getPrincesUp() {
        load();
        return imageAddressMap.get("princesUp");
    }

    public static String getBehindCard() {
        load();
        return imageAddressMap.get("behindCard");
    }

    public static String getLeftCard() {
        load();
        return imageAddressMap.get("leftCard");
    }

    public static String getRightCard() {
        load();
        return imageAddressMap.get("rightCard");
    }

    public static String getUpCard() {
        load();
        return imageAddressMap.get("upCard");
    }

    public static String getTempAvatar() {
        load();
        return imageAddressMap.get("tempAvatar");
    }

    public static String getBackGround() {
        load();
        return imageAddressMap.get("backGround");
    }
}
