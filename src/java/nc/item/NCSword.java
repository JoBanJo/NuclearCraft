package nc.item;

import net.minecraft.item.ItemSword;

public class NCSword extends ItemSword {
	public NCSword(ToolMaterial material) {
		super(material);
		//material.setRepairItem(new ItemStack(NCItems.material, 1, 7));
	}
}