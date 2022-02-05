package io.ronnox.simplesabers.MusicDisks;

import io.ronnox.simplesabers.SimpleSabers;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Sounds {

    public static final SoundEvent SOUND_IMPERIAL_MARCH = register("music_disc.imperial_march");


    public static SoundEvent register(String name) {
        Identifier id = new Identifier(SimpleSabers.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void init() { }

}
