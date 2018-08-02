package gregicadditions.item;

import net.minecraft.util.text.translation.LanguageMap;

import java.io.ByteArrayInputStream;

public class LocalizationChanges {
    public static void postInit() {
        LanguageMap.inject(new ByteArrayInputStream(("gregtech.machine.compressor.ev.name=Advanced Compressor III").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("gregtech.machine.electrolyzer.ev.name=Advanced Electrolyzer III").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("gregtech.machine.extractor.ev.name=Advanced Extractor III").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("recipemap.plasma_generator.name=Plasma Turbine Fuels").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("material.nitro_fuel=Cetane-Boosted Diesel").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.ingot=Epoxy Resin Bar").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.dustTiny=Tiny Pile of Epoxy Resin Pulp").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.dustSmall=Small Pile of Epoxy Resin Pulp").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.dust=Epoxy Resin Pulp").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.nugget=Epoxy Resin Chip").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.plateDense=Dense Epoxy Resin Sheet").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.plate=Epoxy Resin Sheet").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.epoxid.foil=Thin Epoxy Resin Sheet").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("material.epoxid=Epoxy Resin").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.parts.advanced.name=Microprocessor").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.parts.advanced.tooltip=A Basic Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.integrated.name=Programmed Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.basic.name=Integrated Logic Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.basic.tooltip=A Basic Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.advanced.name=Integrated Processor").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.advanced.tooltip=A Good Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.master.name=Crystalprocessor Assembly").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.master.tooltip=A Master Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.elite.name=Quantumprocessor Assembly").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.elite.tooltip=An Elite Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("item.material.oreprefix.plateCurved=Curved %s Plate").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.data.name=Workstation").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.data.tooltip=An Extreme Circuit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.board.elite.name=Neuro Processing Unit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.circuit.board.elite.tooltip=Neuto CPU").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.credit.darmstadtium.name=Neutronium Credit").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("metaitem.rubber_drop.name=Sticky Resin").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("tile.metal_casing.primitive_bricks.name=Firebricks").getBytes()));
        LanguageMap.inject(new ByteArrayInputStream(("gregtech.machine.primitive_blast_furnace.bronze.tooltip=Structure: 3x3x4 (WxLxH) The entire structure is made out of Firebricks (32 in total)./nFirst Layer is a 3x3 square./nSecond, third, and fourth layers are hollow, without the middle block./nThis block goes on the middle of any side in the second layer./nThe sides of Blast Furnaces can be shared, if the side does not have a controller./n").getBytes()));

    }
}
