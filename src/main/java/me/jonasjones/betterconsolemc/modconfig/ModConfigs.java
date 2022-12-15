package me.jonasjones.betterconsolemc.modconfig;

import com.mojang.datafixers.util.Pair;
import me.jonasjones.betterconsolemc.BetterConsoleMC;

public class ModConfigs {
    public static SimpleConfig MODCONFIG;
    private static ModConfigProvider modconfigs;

    public static boolean IS_ENABLED;
    public static boolean REUQIRE_OP;

    public static void registerConfigs() {
        modconfigs = new ModConfigProvider();
        createConfigs();

        MODCONFIG = SimpleConfig.of(BetterConsoleMC.MODID + "-config").provider(modconfigs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        modconfigs.addSingleLineComment("This is the config file for BetterConsoleMC");
        modconfigs.addKeyValuePair(new Pair<>("bettercmd.enable", true), "whether or not to the mod is enabled or not.");
        modconfigs.addKeyValuePair(new Pair<>("bettercmd.requireOp", true), "whether or not operator level is required in order to run commands.");
    }

    private static void assignConfigs() {
        IS_ENABLED = MODCONFIG.getOrDefault("cmd.enable", true);
        REUQIRE_OP = MODCONFIG.getOrDefault("cmd.requireOp", true);

        SimpleConfig.LOGGER.info("All " + modconfigs.getConfigsList().size() + " have been set properly");
    }
}
