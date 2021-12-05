package arcanamod.arcana.common.compat;

import arcanamod.arcana.Arcana;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ArcanaModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ArcanaModMenu::genConfig;
    }

    private static Screen genConfig(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(translatable("title"))
                .setSavingRunnable(Arcana.config::save);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        builder.getOrCreateCategory(translatable("category.general"));
        return builder.build();
    }

    public static Text translatable(String text) {
        return new TranslatableText("config." + Arcana.MODID + "." + text);
    }
}
