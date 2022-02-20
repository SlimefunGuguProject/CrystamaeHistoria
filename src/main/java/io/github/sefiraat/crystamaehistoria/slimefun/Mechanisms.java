package io.github.sefiraat.crystamaehistoria.slimefun;

import io.github.sefiraat.crystamaehistoria.CrystamaeHistoria;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.chroniclerpanel.ChroniclerPanel;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.DummyLiquefactionBasinCrafting;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.LiquefactionBasin;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.LiquefactionBasinCache;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.RecipeItem;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.realisationaltar.RealisationAltar;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.staveconfigurator.StaveConfigurator;
import io.github.sefiraat.crystamaehistoria.stories.definition.StoryType;
import io.github.sefiraat.crystamaehistoria.utils.theme.ThemeType;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class Mechanisms {

    @Getter
    private static ChroniclerPanel chroniclerPanel1;
    @Getter
    private static ChroniclerPanel chroniclerPanel2;
    @Getter
    private static ChroniclerPanel chroniclerPanel3;
    @Getter
    private static ChroniclerPanel chroniclerPanel4;
    @Getter
    private static RealisationAltar realisationAltar1;
    @Getter
    private static RealisationAltar realisationAltar2;
    @Getter
    private static RealisationAltar realisationAltar3;
    @Getter
    private static RealisationAltar realisationAltar4;
    @Getter
    private static LiquefactionBasin liquefactionBasin1;
    @Getter
    private static LiquefactionBasin liquefactionBasin2;
    @Getter
    private static LiquefactionBasin liquefactionBasin3;
    @Getter
    private static LiquefactionBasin liquefactionBasin4;
    @Getter
    private static StaveConfigurator staveConfigurator;

    public static void setup() {

        final CrystamaeHistoria plugin = CrystamaeHistoria.getInstance();

        final ItemStack amalgamateDustRare = Materials.getAmalgamateDustRare().getItem();
        final ItemStack amalgamateIngotUncommon = Materials.getAmalgamateIngotUncommon().getItem();

        // Chronicler Tier 1
        chroniclerPanel1 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_1",
                new ItemStack(Material.COBBLED_DEEPSLATE_SLAB),
                ThemeType.MECHANISM,
                "记录者 (T1)",
                "记录者可以在任意方块中寻找",
                "并发掘出隐藏在其中的故事",
                "",
                "可发掘 T1-T2 方块"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.COBBLED_DEEPSLATE), new ItemStack(Material.COBBLED_DEEPSLATE), new ItemStack(Material.COBBLED_DEEPSLATE),
                SlimefunItems.CORINTHIAN_BRONZE_INGOT, new ItemStack(Material.AMETHYST_CLUSTER), SlimefunItems.CORINTHIAN_BRONZE_INGOT,
                SlimefunItems.MAGIC_LUMP_2, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.MAGIC_LUMP_2,
            },
            1
        );

        // Chronicler Tier 2
        chroniclerPanel2 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_2",
                new ItemStack(Material.DEEPSLATE_TILE_SLAB),
                ThemeType.MECHANISM,
                "记录者 (T2)",
                "记录者可以在任意方块中寻找",
                "并发掘出隐藏在其中的故事",
                "",
                "可发掘 T1-T3 方块"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.DEEPSLATE_BRICKS), new ItemStack(Material.DEEPSLATE_BRICKS), new ItemStack(Material.DEEPSLATE_BRICKS),
                amalgamateIngotUncommon, chroniclerPanel1.getItem(), amalgamateIngotUncommon,
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.MAGIC_LUMP_3,
            },
            2
        );

        // Chronicler Tier 3
        RecipeItem chroniclerT3Recipe = new RecipeItem(
            chroniclerPanel2.getItem(),
            StoryType.ELEMENTAL, 150,
            StoryType.CELESTIAL, 200,
            StoryType.VOID, 50
        );
        chroniclerPanel3 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_3",
                new ItemStack(Material.NETHER_BRICK_SLAB),
                ThemeType.MECHANISM,
                "记录者 (T3)",
                "记录者可以在任意方块中寻找",
                "并发掘出隐藏在其中的故事",
                "",
                "可发掘 T1-T4 方块"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            chroniclerT3Recipe.getDisplayRecipe(),
            3
        );

        // Chronicler Tier 4
        RecipeItem chroniclerT4Recipe = new RecipeItem(
            chroniclerPanel3.getItem(),
            StoryType.ELEMENTAL, 1000,
            StoryType.CELESTIAL, 850,
            StoryType.VOID, 650
        );
        chroniclerPanel4 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_4",
                new ItemStack(Material.DARK_PRISMARINE_SLAB),
                ThemeType.MECHANISM,
                "记录者 (T4)",
                "记录者可以在任意方块中寻找",
                "并发掘出隐藏在其中的故事",
                "",
                "可发掘 T1-T5 方块"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            chroniclerT4Recipe.getDisplayRecipe(),
            4
        );

        // Realisation Tier 1
        realisationAltar1 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_1",
                new ItemStack(Material.CHISELED_DEEPSLATE),
                ThemeType.MECHANISM,
                "现实祭坛 (T1)",
                "现实祭坛可以从已发掘出故事的方块中",
                "提取魔法能量，并将其转化为物理形态",
                "",
                "可提取 T1 - T2 方块"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                null, new ItemStack(Material.BOOK), null,
                SlimefunItems.CORINTHIAN_BRONZE_INGOT, new ItemStack(Material.AMETHYST_CLUSTER), SlimefunItems.CORINTHIAN_BRONZE_INGOT,
                SlimefunItems.MAGIC_LUMP_2, SlimefunItems.COMMON_TALISMAN, SlimefunItems.MAGIC_LUMP_2,
            },
            1
        );

        // Realisation Tier 2
        realisationAltar2 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_2",
                new ItemStack(Material.CHISELED_NETHER_BRICKS),
                ThemeType.MECHANISM,
                "现实祭坛 (T2)",
                "现实祭坛可以从已发掘出故事的方块中",
                "提取魔法能量，并将其转化为物理形态",
                "",
                "可提取 T1 - T3 方块"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                null, new ItemStack(Material.BOOK), null,
                amalgamateIngotUncommon, realisationAltar1.getItem(), amalgamateIngotUncommon,
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.SOULBOUND_RUNE, SlimefunItems.MAGIC_LUMP_3,
            },
            2
        );

        // Realisation Tier 3
        RecipeItem realisationT3Recipe = new RecipeItem(
            realisationAltar2.getItem(),
            StoryType.HISTORICAL, 100,
            StoryType.HUMAN, 350,
            StoryType.PHILOSOPHICAL, 150
        );
        realisationAltar3 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_3",
                new ItemStack(Material.CHISELED_RED_SANDSTONE),
                ThemeType.MECHANISM,
                "现实祭坛 (T3)",
                "现实祭坛可以从已发掘出故事的方块中",
                "提取魔法能量，并将其转化为物理形态",
                "",
                "可提取 T1 - T4 方块"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            realisationT3Recipe.getDisplayRecipe(),
            3
        );

        // Realisation Tier 4
        RecipeItem realisationT4Recipe = new RecipeItem(
            realisationAltar3.getItem(),
            StoryType.HISTORICAL, 1100,
            StoryType.HUMAN, 720,
            StoryType.PHILOSOPHICAL, 450
        );
        realisationAltar4 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_4",
                new ItemStack(Material.CHISELED_POLISHED_BLACKSTONE),
                ThemeType.MECHANISM,
                "现实祭坛 (T4)",
                "现实祭坛可以从已发掘出故事的方块中",
                "提取魔法能量，并将其转化为物理形态",
                "",
                "可提取 T1 - T5 方块"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            realisationT4Recipe.getDisplayRecipe(),
            4
        );

        // Liquefaction T1
        liquefactionBasin1 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_1",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "液化池 (T1)",
                "投入魔法水晶可将其转化为液化魔法水晶",
                "用于后续的魔法合成",
                "警告: 不要在里面有液化魔法水晶时破坏!",
                "",
                "最多可存储 500 液化魔法水晶"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.REINFORCED_ALLOY_INGOT, null, SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.CAULDRON), SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.COMMON_TALISMAN, SlimefunItems.REINFORCED_ALLOY_INGOT
            },
            500,
            Color.fromRGB(150, 150, 150)
        );

        // Liquefaction T2
        liquefactionBasin2 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_2",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "液化池 (T2)",
                "投入魔法水晶可将其转化为液化魔法水晶",
                "用于后续的魔法合成",
                "警告: 不要在里面有液化魔法水晶时破坏!",
                "",
                "最多可存储 1000 液化魔法水晶"
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                amalgamateDustRare, null, amalgamateDustRare,
                amalgamateDustRare, liquefactionBasin1.getItem(), amalgamateDustRare,
                amalgamateDustRare, SlimefunItems.ENCHANTMENT_RUNE, amalgamateDustRare
            },
            1000,
            Color.fromRGB(195, 195, 150)
        );

        // Liquefaction T3
        RecipeItem liquefactionT3Recipe = new RecipeItem(
            liquefactionBasin2.getItem(),
            StoryType.MECHANICAL, 90,
            StoryType.ALCHEMICAL, 250,
            StoryType.ANIMAL, 185
        );
        liquefactionBasin3 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_3",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "液化池 (T3)",
                "投入魔法水晶可将其转化为液化魔法水晶",
                "用于后续的魔法合成",
                "警告: 不要在里面有液化魔法水晶时破坏!",
                "",
                "最多可存储 2500 液化魔法水晶"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            liquefactionT3Recipe.getDisplayRecipe(),
            2500,
            Color.fromRGB(215, 200, 110)
        );

        // Liquefaction T4
        RecipeItem liquefactionT4Recipe = new RecipeItem(
            liquefactionBasin3.getItem(),
            StoryType.MECHANICAL, 750,
            StoryType.ALCHEMICAL, 700,
            StoryType.ANIMAL, 600
        );
        liquefactionBasin4 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_4",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "液化池 (T4)",
                "投入魔法水晶可将其转化为液化魔法水晶",
                "用于后续的魔法合成",
                "警告: 不要在里面有液化魔法水晶时破坏!",
                "",
                "最多可存储 5000 液化魔法水晶"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            liquefactionT4Recipe.getDisplayRecipe(),
            5000,
            Color.fromRGB(240, 220, 26)
        );

        // Stave Configurator
        RecipeItem staveConfiguratorRecipe = new RecipeItem(
            new ItemStack(Material.COPPER_BLOCK),
            StoryType.ELEMENTAL, 300,
            StoryType.MECHANICAL, 200,
            StoryType.ALCHEMICAL, 510
        );
        staveConfigurator = new StaveConfigurator(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_STAVE_CONFIGURATOR",
                new ItemStack(Material.CUT_COPPER),
                ThemeType.MECHANISM,
                "法杖配置器",
                "你可以使用法杖配置器来将",
                "法术绑定至法杖"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            staveConfiguratorRecipe.getDisplayRecipe()
        );

        // Slimefun Registry
        chroniclerPanel1.register(plugin);
        chroniclerPanel2.register(plugin);
        chroniclerPanel3.register(plugin);
        chroniclerPanel4.register(plugin);
        realisationAltar1.register(plugin);
        realisationAltar2.register(plugin);
        realisationAltar3.register(plugin);
        realisationAltar4.register(plugin);
        liquefactionBasin1.register(plugin);
        liquefactionBasin2.register(plugin);
        liquefactionBasin3.register(plugin);
        liquefactionBasin4.register(plugin);
        staveConfigurator.register(plugin);

        // Liquefaction Recipes
        LiquefactionBasinCache.addCraftingRecipe(chroniclerPanel3, chroniclerT3Recipe);
        LiquefactionBasinCache.addCraftingRecipe(chroniclerPanel4, chroniclerT4Recipe);

        LiquefactionBasinCache.addCraftingRecipe(realisationAltar3, realisationT3Recipe);
        LiquefactionBasinCache.addCraftingRecipe(realisationAltar4, realisationT4Recipe);

        LiquefactionBasinCache.addCraftingRecipe(liquefactionBasin3, liquefactionT3Recipe);
        LiquefactionBasinCache.addCraftingRecipe(liquefactionBasin4, liquefactionT4Recipe);

        LiquefactionBasinCache.addCraftingRecipe(staveConfigurator, staveConfiguratorRecipe);
    }
}
