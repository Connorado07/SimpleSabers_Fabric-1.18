package io.ronnox.simplesabers.MusicDisks;

import io.ronnox.simplesabers.SimpleSabers;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Items {

    public static final Item DISC_IMPERIAL_MARCH = register("music_disc_imperial_march", Sounds.SOUND_IMPERIAL_MARCH);






    public static Item register(String id, SoundEvent sound) {
        Item.Settings settings = new Item.Settings().rarity(Rarity.RARE).maxCount(1).group(SimpleSabers.SIMPLESABERS_GROUP);
        return Registry.register(Registry.ITEM, new Identifier(SimpleSabers.MOD_ID, id), new AbstractDiscItem(15, sound, settings));
    }

    public static void init() { }

}
