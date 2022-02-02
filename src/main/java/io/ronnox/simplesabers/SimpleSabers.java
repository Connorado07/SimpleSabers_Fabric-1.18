package io.ronnox.simplesabers;

import io.ronnox.simplesabers.tools.LightsaberToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SimpleSabers implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("simplesabers");

	//ItemGroup(s)
	public static final ItemGroup SIMPLESABERS_GROUP = FabricItemGroupBuilder.build(
			new Identifier("simplesabers", "general"),
			() -> new ItemStack(SimpleSabers.KYBER_CRYSTAL_RED));


	//Kyber Crystals
	public static final Item KYBER_CRYSTAL_RED = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP).rarity(Rarity.RARE).maxCount(1));
	public static final Item KYBER_CRYSTAL_BLUE = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP).rarity(Rarity.RARE).maxCount(1));
	public static final Item KYBER_CRYSTAL_GREEN = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP).rarity(Rarity.RARE).maxCount(1));
	public static final Item KYBER_CRYSTAL_PURPLE = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP).rarity(Rarity.RARE).maxCount(1));
	public static final Item KYBER_CRYSTAL_YELLOW = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP).rarity(Rarity.RARE).maxCount(1));
	public static final Item KYBER_CRYSTAL_WHITE = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP).rarity(Rarity.EPIC).maxCount(1));

	//Lightsabers
	public static ToolItem RED_LIGHTSABER = new SwordItem(LightsaberToolMaterial.INSTANCE, 19, -2.8F, new Item.Settings()
			.group(SIMPLESABERS_GROUP));
	public static ToolItem BLUE_LIGHTSABER = new SwordItem(LightsaberToolMaterial.INSTANCE, 17, -2F, new Item.Settings()
			.group(SIMPLESABERS_GROUP));
	public static ToolItem GREEN_LIGHTSABER = new SwordItem(LightsaberToolMaterial.INSTANCE, 18, -2.4F, new Item.Settings()
			.group(SIMPLESABERS_GROUP));
	public static ToolItem PURPLE_LIGHTSABER = new SwordItem(LightsaberToolMaterial.INSTANCE, 16, -1.8F, new Item.Settings()
			.group(SIMPLESABERS_GROUP));
	public static ToolItem YELLOW_LIGHTSABER = new SwordItem(LightsaberToolMaterial.INSTANCE, 17, -2.2F, new Item.Settings()
			.group(SIMPLESABERS_GROUP));
	public static ToolItem WHITE_LIGHTSABER = new SwordItem(LightsaberToolMaterial.INSTANCE, 17, -2.2F, new Item.Settings()
			.group(SIMPLESABERS_GROUP));

	//Items
	public static final Item DURASTEEL_INGOT = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final Item PLASTANIUM_INGOT = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final Item QUADERNIUM_INGOT = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final Item FOCUS_CRYSTAL = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final Item BOTTOM_SABER_PART = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final Item TOP_SABER_PART = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final Item PLASTANIUM_BALL = new Item(new FabricItemSettings().group(SIMPLESABERS_GROUP));



	//Blocks
	public static final Block RED_ORE = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(8.0F)
			.nonOpaque().luminance(3).collidable(false).requiresTool());
	public static final Block BLUE_ORE = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(8.0F)
			.nonOpaque().luminance(3).collidable(false).requiresTool());
	public static final Block GREEN_ORE = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(6.0F)
			.nonOpaque().luminance(3).collidable(false).requiresTool());
	public static final Block PURPLE_ORE = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(12.0F)
			.nonOpaque().luminance(3).collidable(false).requiresTool());
	public static final Block YELLOW_ORE = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(2.0F)
			.nonOpaque().luminance(3).collidable(false).requiresTool());
	public static final Block WHITE_ORE = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(7.0F)
			.nonOpaque().luminance(3).collidable(false).requiresTool());
	//BlockItems
	public static final BlockItem RED_ORE_ITEM = new BlockItem(RED_ORE, new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final BlockItem BLUE_ORE_ITEM = new BlockItem(BLUE_ORE, new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final BlockItem GREEN_ORE_ITEM = new BlockItem(GREEN_ORE, new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final BlockItem PURPLE_ORE_ITEM = new BlockItem(PURPLE_ORE, new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final BlockItem YELLOW_ORE_ITEM = new BlockItem(YELLOW_ORE, new FabricItemSettings().group(SIMPLESABERS_GROUP));
	public static final BlockItem WHITE_ORE_ITEM = new BlockItem(WHITE_ORE, new FabricItemSettings().group(SIMPLESABERS_GROUP));

	//OreGen
	private static ConfiguredFeature<?, ?> OVERWORLD_BLUE_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					SimpleSabers.BLUE_ORE.getDefaultState(), 3)); // vein size
	public static PlacedFeature OVERWORLD_BLUE_ORE_PLACED_FEATURE = OVERWORLD_BLUE_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(8), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height
	private static ConfiguredFeature<?, ?> OVERWORLD_GREEN_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					SimpleSabers.GREEN_ORE.getDefaultState(), 3)); // vein size
	public static PlacedFeature OVERWORLD_GREEN_ORE_PLACED_FEATURE = OVERWORLD_GREEN_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(8), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height
	//-------------------------------------------Nether OreGen-------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	private static ConfiguredFeature<?, ?> NETHER_RED_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.NETHERRACK, // we use OreConfiguredFeatures.NETHERRACK here
					SimpleSabers.RED_ORE.getDefaultState(), 3));
	public static PlacedFeature NETHER_RED_ORE_PLACED_FEATURE = NETHER_RED_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(8),
			SquarePlacementModifier.of(),
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));

	//-----------------------------------------------END ORE-------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------
	private static ConfiguredFeature<?, ?> END_WHITE_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.END_STONE), // we use new BlockMatchRuleTest(Blocks.END_STONE) here
					SimpleSabers.WHITE_ORE.getDefaultState(), 3));
	public static PlacedFeature END_WHITE_ORE_PLACED_FEATURE = END_WHITE_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(8),
			SquarePlacementModifier.of(),
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));
	private static ConfiguredFeature<?, ?> END_YELLOW_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.END_STONE), // we use new BlockMatchRuleTest(Blocks.END_STONE) here
					SimpleSabers.YELLOW_ORE.getDefaultState(), 3));
	public static PlacedFeature END_YELLOW_ORE_PLACED_FEATURE = END_YELLOW_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(8),
			SquarePlacementModifier.of(),
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));
	private static ConfiguredFeature<?, ?> END_PURPLE_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.END_STONE), // we use new BlockMatchRuleTest(Blocks.END_STONE) here
					SimpleSabers.PURPLE_ORE.getDefaultState(), 3));
	public static PlacedFeature END_PURPLE_ORE_PLACED_FEATURE = END_PURPLE_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(8),
			SquarePlacementModifier.of(),
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));



	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_red"), KYBER_CRYSTAL_RED);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_blue"), KYBER_CRYSTAL_BLUE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_green"), KYBER_CRYSTAL_GREEN);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_purple"), KYBER_CRYSTAL_PURPLE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_yellow"), KYBER_CRYSTAL_YELLOW);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_white"), KYBER_CRYSTAL_WHITE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "durasteel_ingot"), DURASTEEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "plastanium_ingot"), PLASTANIUM_INGOT);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "quadernium_ingot"), QUADERNIUM_INGOT);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "focus_crystal"), FOCUS_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "bottom_saber_part"), BOTTOM_SABER_PART);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "top_saber_part"), TOP_SABER_PART);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "plastanium_ball"), PLASTANIUM_BALL);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "red_lightsaber"), RED_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "blue_lightsaber"), BLUE_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "green_lightsaber"), GREEN_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "purple_lightsaber"), PURPLE_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "yellow_lightsaber"), YELLOW_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "white_lightsaber"), WHITE_LIGHTSABER);
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "red_ore"), RED_ORE);
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "blue_ore"), BLUE_ORE);
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "green_ore"), GREEN_ORE);
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "purple_ore"), PURPLE_ORE);
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "yellow_ore"), YELLOW_ORE);
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "white_ore"), WHITE_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "red_ore_item"), RED_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "blue_ore_item"), BLUE_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "green_ore_item"), GREEN_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "purple_ore_item"), PURPLE_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "yellow_ore_item"), YELLOW_ORE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "white_ore_item"), WHITE_ORE_ITEM);
		BlockRenderLayerMap.INSTANCE.putBlock(RED_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(BLUE_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(GREEN_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PURPLE_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(YELLOW_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(WHITE_ORE, RenderLayer.getCutout());
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("simplesabers", "overworld_blue_ore"), OVERWORLD_BLUE_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("simplesabers", "overworld_blue_ore"),
				OVERWORLD_BLUE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("simplesabers", "overworld_blue_ore")));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("simplesabers", "overworld_green_ore"), OVERWORLD_GREEN_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("simplesabers", "overworld_green_ore"),
				OVERWORLD_GREEN_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("simplesabers", "overworld_green_ore")));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("simplesabers", "nether_red_ore"), NETHER_RED_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("simplesabers", "nether_red_ore"),
				NETHER_RED_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("simplesabers", "nether_red_ore")));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("simplesabers", "end_white_ore"), END_WHITE_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("simplesabers", "end_white_ore"),
				END_WHITE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("simplesabers", "end_white_ore")));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("simplesabers", "end_yellow_ore"), END_YELLOW_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("simplesabers", "end_yellow_ore"),
				END_YELLOW_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("simplesabers", "end_yellow_ore")));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("simplesabers", "end_purple_ore"), END_PURPLE_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("simplesabers", "end_purple_ore"),
				END_PURPLE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("simplesabers", "end_purple_ore")));
	}
}

