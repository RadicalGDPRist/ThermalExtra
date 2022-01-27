package mrthomas20121.thermal_extra.fluid;

import cofh.lib.fluid.FluidCoFH;
import mrthomas20121.thermal_extra.ItemRegistry;
import mrthomas20121.thermal_extra.ThermalExtraFluids;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fml.RegistryObject;

public class FluidThermalExtra extends FluidCoFH {

    public FluidThermalExtra(String key, String stillTexture, String flowTexture) {
        super(ThermalExtraFluids.FLUIDS, key, FluidAttributes.builder(new ResourceLocation(stillTexture), new ResourceLocation(flowTexture))
                        .density(4000)
                        .viscosity(2500)
                        .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY));

        bucket = ItemRegistry.ITEMS.register(bucket(key), () -> new BucketItem(stillFluid, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemRegistry.group)));

        properties.bucket(bucket);
    }

    public RegistryObject<Item> getBucket() {
        return this.bucket;
    }

    public RegistryObject<FlowingFluid> getStillFluid() {
        return this.stillFluid;
    }

    public RegistryObject<FlowingFluid> getFlowingFluid() {
        return this.flowingFluid;
    }
}