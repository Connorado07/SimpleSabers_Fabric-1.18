package io.ronnox.simplesabers.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LightsaberToolMaterial implements ToolMaterial {
    public static final LightsaberToolMaterial INSTANCE = new LightsaberToolMaterial();

    @Override
    public int getDurability() {
        return 12300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.0F;
    }

    @Override
    public float getAttackDamage() {
        return 6.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 4;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.RAW_IRON);
    }
}
