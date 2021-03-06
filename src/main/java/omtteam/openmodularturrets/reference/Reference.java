package omtteam.openmodularturrets.reference;

import static omtteam.omlib.compatability.ModCompatibility.*;

public class Reference {
    public static final String MOD_ID = "openmodularturrets";
    public static final String NAME = "Open Modular Turrets";
    public static final String VERSION = "@VERSION@";
    public static final String ACCEPTED_MINECRAFT_VERSION = "[1.9,1.12)";

    public static final String DEPENDENCIES = "after:" + TEModID + ";after:" + CCModID + ";after:" + MekModID +
            ";after:" + EIOModID + ";after:" + TCModID + ";after:" + OCModID + ";required-after:omlib@[0.0.0,)";
}